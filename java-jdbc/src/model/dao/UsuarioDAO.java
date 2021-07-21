package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import connection.ConnectionFactory;
import model.bean.Usuario;
//import model.bean.Usuario;

public class UsuarioDAO {
	
public boolean chechLogin(Usuario user){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stnt = null;
		ResultSet rs = null;
		boolean check = false;
		
		
		try {
			
			stnt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
			stnt.setString(1, user.getLogin());
			stnt.setString(2, user.getSenha());
			rs = stnt.executeQuery();
			
			while(rs.next()) {
				check = true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stnt, rs);
		}
		return check;
	}
	
}
