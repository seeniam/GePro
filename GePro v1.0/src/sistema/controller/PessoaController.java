package sistema.controller;

import javax.swing.JOptionPane;

import sistema.model.PessoaModel;

public class PessoaController {
	
	public PessoaController(){
	}
	
	public PessoaModel enviaDados(String nome, String cpf){
		
		PessoaModel pm = new PessoaModel();
		pm.setNome(nome);
		pm.setCpf(cpf);		
		pm.salvaDados(pm);
		
		//JOptionPane.showMessageDialog(null, "cliente salvo com sucesso!");
		
		return pm;
		
	}
	
	public int getIdPessoaController(PessoaModel pm, String cpf){
		
		int id = pm.getIdPessoa(cpf);
		return id;
	}

}
