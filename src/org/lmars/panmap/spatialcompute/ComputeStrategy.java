package org.lmars.panmap.spatialcompute;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ComputeStrategy {

	public abstract  boolean judge(String ID1,String ID2) throws SQLException;//�����жϵĽ���������Ƿ�����ϵ�����ڹ�ϵ��
	public abstract  ArrayList<String> compute(String ID) throws SQLException;//���ؼ���Ľ�� ���緵��id����Ľ����Ķ���
}
