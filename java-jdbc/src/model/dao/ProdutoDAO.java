package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.bean.Produto;

public class ProdutoDAO {
	//cria e executa a query
	public void create(Produto p) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stnt = null;
		
		try {
			//executa o comando sql
			stnt = con.prepareStatement("INSERT INTO produto (descricao,qtd,preco) VALUES(?,?,?)");
			stnt.setString(1, p.getDescricao());
			stnt.setInt(2, p.getQtd());
			stnt.setDouble(3, p.getPreco());
			
			stnt.executeUpdate();
			System.out.println("Salvo com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro na execução: "+e+"\n");
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection(con);
		}
		
	}
	
	public List<Produto> read(){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stnt = null;
		ResultSet rs = null;
		
		List<Produto> Produtos = new ArrayList<>();
		
		try {
			stnt = con.prepareStatement("SELECT * FROM produto");
			rs = stnt.executeQuery();
			
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQtd(rs.getInt("qtd"));
				produto.setPreco(rs.getDouble("preco"));
				
				Produtos.add(produto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stnt, rs);
		}
		return Produtos;
	}
	
public void update(Produto p) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stnt = null;
		
		try {
			//executa o comando sql
			stnt = con.prepareStatement("UPDATE produto SET descricao = ?, qtd = ?, preco = ? WHERE id = ? ");
			stnt.setString(1, p.getDescricao());
			stnt.setInt(2, p.getQtd());
			stnt.setDouble(3, p.getPreco());
			stnt.setInt(4, p.getId());
			
			stnt.executeUpdate();
			System.out.println("Atualizado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro na atualização: "+e+"\n");
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection(con);
		}
		
	}

public void delete(Produto p) {
	
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stnt = null;
	
	try {
		//executa o comando sql
		stnt = con.prepareStatement("DELETE FROM produtos WHERE id = ? ");
	
		stnt.setInt(4, p.getId());
		
		stnt.executeUpdate();
		System.out.println("Deletado com sucesso!");
	} catch (SQLException e) {
		System.out.println("Erro no delete: "+e+"\n");
		e.printStackTrace();
	}finally{
		ConnectionFactory.closeConnection(con);
	}
	
}
public List<Produto> readGetDesc(String desc){
	
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stnt = null;
	ResultSet rs = null;
	
	List<Produto> Produtos = new ArrayList<>();
	
	try {
		stnt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
		stnt.setString(1, "%"+desc+"%");
		rs = stnt.executeQuery();
		
		while(rs.next()) {
			Produto produto = new Produto();
			produto.setId(rs.getInt("id"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setQtd(rs.getInt("qtd"));
			produto.setPreco(rs.getDouble("preco"));
			
			Produtos.add(produto);
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		ConnectionFactory.closeConnection(con, stnt, rs);
	}
	return Produtos;
}

	
}
