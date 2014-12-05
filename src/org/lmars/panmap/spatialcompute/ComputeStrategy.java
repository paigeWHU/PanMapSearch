package org.lmars.panmap.spatialcompute;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ComputeStrategy {

	public abstract  boolean judge(String ID1,String ID2) throws SQLException;//返回判断的结果，例如是否对面关系，相邻关系等
	public abstract  ArrayList<String> compute(String ID) throws SQLException;//返回计算的结果 例如返回id代表的结合体的对面
}
