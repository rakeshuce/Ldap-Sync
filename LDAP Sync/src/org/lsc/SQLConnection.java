package org.lsc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {

	 
	
	 
		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
			//Connection conn = DriverManager.getConnection("jdbc:sqlserver://HOSP_SQL1.company.com;user=name;password=abcdefg;database=Test");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://r90hvvwn.asia.kofax.com;user=sa;password=saperion@123;database=ldap");
			System.out.println(conn.isClosed());
			
			Statement sta = conn.createStatement();
			//String Sql = "select * from testing_table";
		//	ResultSet rs = sta.executeQuery(Sql);
		//	while (rs.next()) {
		//		System.out.println(rs.getString("txt_title"));
		//	}
		}
	
}
