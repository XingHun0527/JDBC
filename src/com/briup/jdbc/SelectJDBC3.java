package com.briup.jdbc;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectJDBC3 {
public static void main(String[] args) throws Exception {
	Connection connection=null;
	PreparedStatement Statement=null;
	ResultSet resultSet=null;
	//存放从数据库中查询的员工信息

			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@127.16.14.30:1521:xe";
			String user="briup";
			String password="briup";
			connection=DriverManager.getConnection(url, user, password);
			
			//构建时需要传SQL语句
			//String sql="select last_name,id,salary,start_date from s_emp where id=1";
			//String sql="select last_name,id,salary from s_emp";
			
			int id=2343345;
			String lastName="Makkkk";
			String sql="insert into s_emp(id,last_name) values(?,?,?)";//问号占位
			Statement=connection.prepareStatement(sql);
			Statement.execute();
////////////			resultSet.
			/*
			 * boolean execute() 有没有返回值
			 * int executeUpdate() 影响了几行
			 * ResultSet executeQuery()结果集、查询语句
			 * **/
////////////////			 resultSet=Statement.executeQuery();
		
				resultSet.close();
				Statement.close();
				connection.close();
		
	}
}
