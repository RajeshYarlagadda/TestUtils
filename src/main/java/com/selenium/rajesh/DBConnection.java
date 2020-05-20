package com.selenium.rajesh;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		/*java.sql.Connection conn = DriverManager.getConnection("","root","passwordiot");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from widgetmanagement");*/
		java.sql.Connection conn = DriverManager.getConnection("","root","0tRsr00t");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from MASTER_ACCESS_RIGHTS where CODE like 'MENU_04_%'");
		if(rs.next())
			System.out.println("got connection");
		rs.close();
		st.close();
		conn.close();
	}

}
