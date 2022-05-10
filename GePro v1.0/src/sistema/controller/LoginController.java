package sistema.controller;

import sistema.model.UsuarioModel;

public class LoginController {
	private static UsuarioModel usuario;
	private static boolean logado;
	
	
	public static UsuarioModel getUsuario() {
		return usuario;
	}

	public static void setUsuario(UsuarioModel usuario) {
		LoginController.usuario = usuario;
	}
	
	
	public static boolean isLogado() {
		return logado;
	}

	public static void setLogado(boolean logado) {
		LoginController.logado = logado;
	}

	public LoginController(){
		this.usuario = null;
		this.logado  = false;
	}
	
	public static boolean autentica(String login, String senha){
		usuario = UsuarioModel.buscaUsuario(login);		
		if (usuario != null){
			if (usuario.getSenha().equals(senha)){				
				setUsuario(usuario);
				LoginController.logado = true;
				
				
			}
		}
		return estaLogado();
	}
	
	public static int verificaTipoUsuario(){
		int tipo    = -1;
		if(usuario != null){
			return usuario.getTipo();
		}
		return -1;
	}


	public static boolean estaLogado(){
		return logado;
	}
	public static void logout(){
		setUsuario(null);
		logado = false;
	}
}
