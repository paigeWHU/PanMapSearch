package org.lmars.panmap.parser;

import java.util.Map;
import java.util.Set;

public interface GrammarIface {

	/*
	 *  让用户设置本体文件路径的函数
	 */
	public abstract void SetOWLFile(String fileStr);

	/*
	 *  让用户设置postgis数据库地址的函数
	 */
	public abstract void SetPgAddress(String ipaddress);

	/* 
	 * 让用户设置连接postgis数据库用户名和密码的函数
	 */
	public abstract void SetPgUsernPass(String user, String pass);

	/*
	 * 执行查询的函数
	 */
	public abstract Map<String, Set<String>> query(String expr)
			throws Exception;

}