package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/dbmercadinho";
	private final static String USER = "root";
	private final static String PASS = "";
	
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("ERRO na Conexão: "+ e);
		}
	}
	
	public static void closeConnection(Connection con) {
		
			try {
				if(con != null) {
				con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
public static void closeConnection(Connection con, PreparedStatement stat) {
	closeConnection(con);
	try {
		if(stat != null) {
			stat.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void closeConnection(Connection con, PreparedStatement stat, ResultSet rs) {
	closeConnection(con,stat);
	
	try {
		if(rs != null) {
			rs.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}

