package org.lmars.panmap.parser;

import java.util.Map;
import java.util.Set;

public interface GrammarIface {

	/*
	 *  ���û����ñ����ļ�·���ĺ���
	 */
	public abstract void SetOWLFile(String fileStr);

	/*
	 *  ���û�����postgis���ݿ��ַ�ĺ���
	 */
	public abstract void SetPgAddress(String ipaddress);

	/* 
	 * ���û���������postgis���ݿ��û���������ĺ���
	 */
	public abstract void SetPgUsernPass(String user, String pass);

	/*
	 * ִ�в�ѯ�ĺ���
	 */
	public abstract Map<String, Set<String>> query(String expr)
			throws Exception;

}