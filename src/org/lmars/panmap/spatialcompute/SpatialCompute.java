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
		//返回判断的结果，例如是否对面关系，相邻关系等
		boolean result = computeStrategy.judge(ID1, ID2);
		return result;
	}
	public  ArrayList<String> compute(String ID) throws SQLException{
		//返回计算的结果 例如返回id代表的结合体的对面
		ArrayList<String> result = computeStrategy.compute(ID);
		return result;
	}
}
