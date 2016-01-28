package ycui.projet.pgp.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/db_pgp";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private Connection conn = null;
	
	public DataBaseConnection(){
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.conn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return this.conn;
	}
	public void close(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
