package runPackage;

import model.bean.Produto;
import model.dao.ProdutoDAO;

public class RunMain {

	public static void main(String[] args) {
		//Produto p = new Produto();
		ProdutoDAO run = new ProdutoDAO();
		
		/*p.setDescricao("Achocolatado");
		p.setId(1);
		p.setPreco(11.0);
		p.setQtd(14);
		
		run.update(p);*/
		
		for(Produto pr : run.readGetDesc("")) {
			System.out.println("ID: "+pr.getId()+"\nDESCRIÇÃO: "+pr.getDescricao()+"\nQUANTIDADE: "+pr.getQtd()+"\n"
					+ "PREÇO: "+pr.getPreco()+"\n");
		}
		
	}

}
