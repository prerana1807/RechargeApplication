package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	public static Connection myConnection() {
	Connection con=null;
	try {
	Class.forName("oracle.jdbc.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prerana");
	System.out.println("Connection"+con);
}catch(Exception e)
	{
	System.out.println(e);
	}
	return con;

}
}
