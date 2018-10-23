

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectJDBC {
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
			
			//����ʱ��Ҫ��SQL���
			//String sql="select last_name,id,salary,start_date from s_emp where id=1";
			String sql="select last_name,id,salary,start_date from s_emp";
			pStatement=connection.prepareStatement(sql);
			/*
			 * boolean execute() ��û�з���ֵ
			 * int executeUpdate() Ӱ���˼���
			 * ResultSet executeQuery()���������ѯ���
			 * **/
			 resultSet=pStatement.executeQuery();
			//��������� next() get...()
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
			//����Դ
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