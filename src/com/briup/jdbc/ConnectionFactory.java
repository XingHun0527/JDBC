package com.briup.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 1 2 6   
 *   3 4 5 
 * */

public class ConnectionFactory {
	private static String driverName;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		try {
			Properties properties=new Properties();
			/*properties.put("author", "briup");
			Reader reader=new FileReader("src/com/briup/util/db.properties");*/
			//web中使用
			InputStream reader=ConnectionFactory.class.getResourceAsStream("db.properties");
			properties.load(reader);
			
			driverName=properties.getProperty("driverName123");
			url=properties.getProperty("url123");
			user=properties.getProperty("user");
			password=properties.getProperty("password");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 配置文件：XML properties  
	 * 
	 * 获取连接对象
	 * */
	public static Connection getConnection() {
		Connection connection=null;
		try {
	//		1.注册驱动 4 全类名  
			Class.forName(driverName);
	//		2.获取数据库连接对象 Connection
			connection=
					DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 	关闭资源
	 * */
	public static  void close(Connection connection,Statement pStatement,ResultSet resultSet) {
		try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(pStatement!=null) {
				pStatement.close();
			}
			if(connection!=null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}



