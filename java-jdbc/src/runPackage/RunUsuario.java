package runPackage;

import model.bean.Usuario;
import model.dao.UsuarioDAO;

public class RunUsuario {

	public static void main(String[] args) {
		Usuario user = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
		
		user.setLogin("usuarioteste");
		user.setSenha("123456");
		
		System.out.println(dao.chechLogin(user));

	}

}
