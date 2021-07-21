package model.bean;
//cria o bean do produto
public class Produto {
	private int id;
	private String descricao;
	private int qtd;
	private double preco;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}
}
