package com.briup.jdbc;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SelectJDBC {

////////////////////////////////////////////////	
static {
	Properties properties=new Properties();
	properties.put("anthor","briup");
	try {
		Reader reader=new FileReader("D:/360Downloads/eclipse/wackspace/JDBC 77/file/db.properties");
	properties.load(reader);
//	driverName=properties.getProperty("driverName");
//	 url=properties.getProperty("url123");
	} catch (IOException e) {
		e.printStackTrace();
		}
	}

/////////////////////////////////////////////
public static void main(String[] args) {
	
	
	Connection connection=null;
	PreparedStatement pStatement=null;
	ResultSet resultSet=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@127.16.14.30:1521:xe";
			String user="briup";
			String password="briup";
			connection=DriverManager.getConnection(url, user, password);
			
			//构建时需要传SQL语句
			//String sql="select last_name,id,salary,start_date from s_emp where id=1";
			String sql="select last_name,id,salary,start_date from s_emp";
			pStatement=connection.prepareStatement(sql);
			/*
			 * boolean execute() 有没有返回值
			 * int executeUpdate() 影响了几行
			 * ResultSet executeQuery()结果集、查询语句
			 * **/
			 resultSet=pStatement.executeQuery();
			//处理结果集 next() get...()
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				String lastName=resultSet.getString("last_name");
				double salary=resultSet.getDouble("salary");
				Date startDate=resultSet.getDate("start_date");
				
				System.out.println(id+" "+lastName+" "+salary+" "+startDate);
				
				
				
				
				
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关资源
			try {
				if(resultSet!=null){
				resultSet.close();
				}
				if(pStatement!=null){
				pStatement.close();
				}
				if(connection!=null){
				connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
