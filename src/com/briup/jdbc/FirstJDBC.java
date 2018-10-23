package com.briup.jdbc;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class FirstJDBC {

	public static void main(String[] args) throws Exception {
/*
 * 1.注册驱动
 * 	1.1	安装jar包
 * 	1.2	Class.forName("oracle.jdbc.OracleDriver");
 * 	1.3 构造
 * 	1.4 	
 * **/	
//===============================================		
//		Class.forName("oracle.jdbc.OracleDriver");//2
//		
//		Driver driver=new OracleDriver();
//		DriverManager.registerDriver(driver);//3
		
//			-Djdbc.drivers=oracle.jdbc.driver.OracleDriver;//4 
		
//	 2.获取数据库连接对象	
		String url="jdbc:oracle:thin:@127.16.14.30:1521:xe";
		String user="briup";
		String password="briup";
		Connection connection=DriverManager.getConnection(url, user, password);
		System.out.println(connection);//2
		
//	3.创建Statement对象 搬运工
		Statement statement=connection.createStatement();
//	4.执行SOL语句
		//String sql="insert into s_emp(id,last_name,salary) values(32765221,'大锤',15000)";
		//String sql="update s_emp set salary=17000 where id=32765221";
		String sql="insert into s_emp(id,username,password) values(122；,'tom','123')";
		System.out.println(sql);
		boolean flag=statement.equals(sql);
		System.out.println(flag);
//	5.如果有结果集 处理结果集
//	6.	关闭资源 先开的后关
		statement.close();
		connection.close();
			
		
		
		
	}
}
