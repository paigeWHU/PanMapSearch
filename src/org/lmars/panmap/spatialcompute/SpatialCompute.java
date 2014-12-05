package org.lmars.panmap.spatialcompute;

import java.sql.SQLException;
import java.util.ArrayList;

public class SpatialCompute {

	public SpatialCompute(String strategyString) {
		// TODO Auto-generated constructor stub
		switch (strategyString) {
		case "Opposite":
			computeStrategy = new OppositeStrategy();
			break;
		
		default:
			break;
		}
	}
	public ComputeStrategy computeStrategy;
	public boolean judge(String ID1,String ID2) throws SQLException{
		//�����жϵĽ���������Ƿ�����ϵ�����ڹ�ϵ��
		boolean result = computeStrategy.judge(ID1, ID2);
		return result;
	}
	public  ArrayList<String> compute(String ID) throws SQLException{
		//���ؼ���Ľ�� ���緵��id����Ľ����Ķ���
		ArrayList<String> result = computeStrategy.compute(ID);
		return result;
	}
}
