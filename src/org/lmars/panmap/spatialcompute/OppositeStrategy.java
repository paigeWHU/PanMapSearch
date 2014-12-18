package org.lmars.panmap.spatialcompute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.sf.json.JSONObject;

import org.lmars.panmap.geo.GeoMultiPolygon;
import org.lmars.panmap.geo.Geometry;
import org.lmars.panmap.geo.GeometryFactory;
import org.lmars.panmap.geo.MyPoint;
import org.lmars.panmap.parser.SpatialSelect;

public class OppositeStrategy extends ComputeStrategy {

	@Override
	public boolean judge(String ID1, String ID2) throws SQLException {
		// TODO Auto-generated method stub
		//����ID1��ID2�Ƿ��ж����ϵ
		//���ȷ��ؼ��������ٿ����������Ƿ����ID2
		ArrayList<String> result = compute(ID1);
		if (result.contains(ID2)) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<String> compute(String ID) throws SQLException {
		// TODO Auto-generated method stub
		
		//�����ҵ�����gid=17����Ӧ����
		ResultSet resultDoor = DistanceSelect(ID, "1");
		ArrayList<String> resultRoom = new ArrayList<String>();
		 while(resultDoor.next())//�Ը÷����ÿһ���Ž��б���
		 {
			 
			//�洢���п��ܵĽ���������
			 ArrayList<String> doorsSet = new ArrayList<String>();
			 String doorid =  resultDoor.getObject(1).toString();//�õ��÷����ŵ�id
			 //��������Ӧ������
			 ResultSet resultCorridorResultSet = DistanceSelect(doorid, "4");
			 String corridorid = null;
			 
			if(resultCorridorResultSet.next())
			{
				corridorid =  resultCorridorResultSet.getObject(1).toString();
			}else {
				return resultRoom;
			}
			doorsSet = DoorSet(corridorid);					
			
			
			//�������п��ܵ��ţ��ж�����������õ��ıߵļнǴ�С���������������
			 //�õ��õ����ȵķ���		
			 double lineDirection = CorridorDirection(corridorid, doorid);
			 
			 //�������ȵķ����Լ�������֮�����ߵķ������Ժ�ѡ������һ�ι���
			 for (int i = 0; i < doorsSet.size(); i++) {
				//�õ����������ߵķ�λ��
				 if (doorid.equals(doorsSet.get(i))) {
					continue;
				}
				 String sqlString2 = "select ST_Azimuth(ST_Centroid(t1.geom), ST_Centroid(t2.geom))/(2*pi())*360 from polygon_r_21  as t1, polygon_r_21  as t2 where t1.gid="+doorid+" and t2.gid="+doorsSet.get(i);				 
				 ResultSet doorDirectionResultSet = SqlExcute(sqlString2);	
				 double doorDirection=0;
				 
				 if(doorDirectionResultSet.next())
				 {
					 doorDirection = Double.valueOf(doorDirectionResultSet.getObject(1).toString());
				 }				 				 								 												 
				 //�õ������ߵķ�λ����߷�λ��֮��ļн�
				 double angle = lineDirection - doorDirection;
				 if (angle<0) {
					angle = angle + 360;
				}
				 if (angle>180) {
					angle = 360 - angle;
				}
				 if (angle>=45&&angle<=135) {
					 //���ŷ���Ҫ�󣬸��ݴ��ŵõ���Ӧ�ķ���
					ResultSet roomResultSet = DistanceSelect(doorsSet.get(i), "2");
					
					if(roomResultSet.next())
					resultRoom.add(roomResultSet.getObject(1).toString());
					 
				}
			}
			 	
		 }
		 return resultRoom;
	}
	
	/*
	 * ��������id�����������ȵ������ŵ�id����
	 */
	private ArrayList<String> DoorSet(String corridorID) throws SQLException {
		 ArrayList<String> doorsSet = new ArrayList<String>();

		 
			 //�ҵ������ϵ�������
			 ResultSet resultDoorSet = DistanceSelect(corridorID, "1");
			 while(resultDoorSet.next()){
				 String sss =  resultDoorSet.getObject(1).toString();
				 doorsSet.add(sss);	
			 }
		
		return doorsSet;
	}
	
	/*
	 * ���������ڵ����ȵķ��� ������
	 */
	private double CorridorDirection(String corridorID,String doorID) throws SQLException{
		//��ʼ�����ȵı߽��б��� �ҵ������Ӧ�ı� ��������������
		 ArrayList<MyPoint> corridorPoints = new ArrayList<MyPoint>();
		 //�õ����ȴ���ļ�����
		 String sql = "select ST_AsGeoJSON(geom) from polygon_r_21 where gid="+corridorID;
		 ResultSet temp = SqlExcute(sql);
		 JSONObject resultJson = null;
		 if (temp.next()) {
			 resultJson = JSONObject.fromObject(temp.getObject(1).toString());
		}
		 GeoMultiPolygon geometry =  (GeoMultiPolygon) GeometryFactory.createGeometryBase(resultJson );//�ҵ����ȵļ�����
		 int count = geometry.geoPolygons.get(0).polygonRings.get(0).numPoints;
		 for (int i = 0; i < count-1; i++) {
			 String x1String = String.valueOf(geometry.geoPolygons.get(0).polygonRings.get(0).ringPoints.get(i).x);
			 String y1String = String.valueOf(geometry.geoPolygons.get(0).polygonRings.get(0).ringPoints.get(i).y);
			 String x2String = String.valueOf(geometry.geoPolygons.get(0).polygonRings.get(0).ringPoints.get(i+1).x);
			 String y2String = String.valueOf(geometry.geoPolygons.get(0).polygonRings.get(0).ringPoints.get(i+1).y);
			String sqlString = "select ST_Contains(ST_Buffer('LINESTRING ( "+x1String+" "+y1String+"," +x2String+" "+y2String +" )'::geometry,0.5),t1.geom) from polygon_r_21 as t1 where t1.gid="+doorID;
//			System.out.print(sqlString+"\n");
			ResultSet isWithinResultSet = SqlExcute(sqlString);
			while(isWithinResultSet.next()){
				String tOrf =  isWithinResultSet.getObject(1).toString();
				if (Boolean.valueOf(tOrf)) {//�ҵ���������ж�Ӧ��ϵ�ı�
					//����ñߵ�������

					
					if(Double.valueOf(geometry.geoPolygons.get(0).polygonRings.get(0).ringPoints.get(i).x)>Double.valueOf(geometry.geoPolygons.get(0).polygonRings.get(0).ringPoints.get(i+1).x))
					{//�ȱ���������ұߵĵ�
						corridorPoints.add(geometry.geoPolygons.get(0).polygonRings.get(0).ringPoints.get(i));
						corridorPoints.add(geometry.geoPolygons.get(0).polygonRings.get(0).ringPoints.get(i+1));
					}else {
						corridorPoints.add(geometry.geoPolygons.get(0).polygonRings.get(0).ringPoints.get(i+1));
						corridorPoints.add(geometry.geoPolygons.get(0).polygonRings.get(0).ringPoints.get(i));
					}
					
					break;
				}
				
			}
			
		}
		 String sqlString = "select ST_Azimuth( 'POINT("+corridorPoints.get(1).x+" "+corridorPoints.get(1).y+")'::geometry,'POINT("+corridorPoints.get(0).x+" "+corridorPoints.get(0).y+")'::geometry)/(2*pi())*360";
		 double lineDirection;
		 ResultSet directionResultSet = SqlExcute(sqlString);
		 directionResultSet.next();
		 String tOrf =  directionResultSet.getObject(1).toString();
		 lineDirection = Double.valueOf(tOrf);
		 return lineDirection;
	}
	
	/*
	 * �ҵ�����idstring��Ӧ���� \����\���� ��һ������
	 */
	private ResultSet DistanceSelect(String idString,String calss) throws SQLException {
		String sqlString = "select p2.gid from polygon_r_21 as p1, polygon_r_21 as p2 where p1.gid="+idString+" and p2.calss="+calss+" and ST_DWithin(p1.geom, p2.geom,0.11)";
		return SqlExcute(sqlString);
	}
	
	
	
	/*
	 * ִ��sql��䲢����ResultSet���͵Ĳ�ѯ���
	 */
	private  ResultSet SqlExcute(String sqlString) throws SQLException {
		 Connection conn = null;
		 java.sql.Statement st=null;
		 ResultSet rs=null;
		 String url = "jdbc:postgresql://"+excuteVar.address;
		 String user = excuteVar.user;
		 String password = excuteVar.pass;
		 JSONObject resultJson = null;
		 try{
			 Class.forName("org.postgresql.Driver");
			 conn = DriverManager.getConnection(url,user,password);
			 st = conn.createStatement();
			 rs = ((java.sql.Statement) st).executeQuery(sqlString);
			

			 
	     }catch(Exception e){
			 e.printStackTrace();
			  rs.close();
	          st.close();
	          conn.close();
	     }finally{

	          conn.close();
	     }
		 return rs;
	}
	

}
