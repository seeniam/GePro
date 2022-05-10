package sistema.controller;

import javax.swing.JOptionPane;

import sistema.model.PessoaModel;
import sistema.model.SetorModel;
import sistema.model.UsuarioModel;

public class UsuarioController {

	public UsuarioController(){}
	
	
	public void enviaDados(int tipo, String nome, String cpf, String email, String senha, String entidade){
		PessoaController pc = new PessoaController();
		PessoaModel pm = new PessoaModel();
		UsuarioModel um = new UsuarioModel();
		int idSetor = LoginController.getUsuario().getSetor().getId_Setor();		
		pm = pc.enviaDados(nome, cpf);
		int idPessoa = pc.getIdPessoaController(pm, cpf);

		um.setSetor(LoginController.getUsuario().getSetor());
		um.setID(idPessoa);
		um.setTipo(tipo);	
		um.setLogin(email);
		um.setSenha(senha);
		um.setIdSetor(idSetor);
		
		um.salvaDados();		
		JOptionPane.showMessageDialog(null, "usuario salvo com sucesso!");
	}

	public int definiTipo(int entidade, int status){
		int tipo = -1;
		
		//admin
		if (entidade == 0 && status == 0)
			tipo = 0;
		//central
		if (entidade == 1 && status == 1) //responsavel
			tipo = 1;	
		if (entidade == 1 && status == 2)//comum
			tipo = 2;
		//setor
		if (entidade >= 2 && status == 1)//responsavel
			tipo = 3;
		if (entidade >= 2 && status == 2)//comum
			tipo = 4;
		
		return tipo;
	}
	
	

	
}
