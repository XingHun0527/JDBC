package com.briup.jdbc;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectJDBC2 {
public static void main(String[] args) {
	Connection connection=null;
	PreparedStatement pStatement=null;
	ResultSet resultSet=null;
	//存放从数据库中查询的员工信息
	 List<Employee> list=new ArrayList<Employee>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@127.16.14.30:1521:xe";
			String user="briup";
			String password="briup";
			connection=DriverManager.getConnection(url, user, password);
			
			//构建时需要传SQL语句
			//String sql="select last_name,id,salary,start_date from s_emp where id=1";
			String sql="select last_name,id,salary from s_emp";
			
		/*	int id=2343345;
			String lastName="Makkkk";
			String sql="insert into s_emp(id,last_name) values(???)";//问号占位
*/			pStatement=connection.prepareStatement(sql);
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
			//	Date startDate=resultSet.getDate("start_date");
			//	String fristName=resultSet.getString("frist_name");
				
			//	System.out.println(id+" "+lastName+" "+salary+" "+startDate);
				//封装一个员工对象
				Employee employee=new Employee(lastName,id,salary);
			//		System.out.println(employee);
				//放入集合
				list.add(employee);
				
				
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
		//主方法JDBC 连接数据库已经结束
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		//遍历方法 同上
//		list.forEach(System.out::println);
		
	}
}
