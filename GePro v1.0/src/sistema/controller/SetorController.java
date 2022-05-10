package sistema.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import sistema.model.PessoaModel;
import sistema.model.SetorModel;
//import sun.print.PeekGraphics;

public class SetorController {
	
	
	public SetorController(){
		
	}

	public ArrayList<String> getSetorDestinatario(){
		SetorModel sm = new SetorModel();
		ArrayList<String> vetor = new ArrayList<String>();
		vetor = sm.pegarSiglaSetor();		
		return vetor;
	}
	
	public void enviaDados(String nome, String sigla){
		SetorModel setor = new SetorModel();
		setor.setNomeSetor(nome);
		setor.setSigla(sigla);
		
		setor.salvaDados();
		
		JOptionPane.showMessageDialog(null, "setor salvo com sucesso!");
	}
	
	public String getSiglaSetor(){
		
		SetorModel sm = new SetorModel();
		sm = LoginController.getUsuario().getSetor();
		return sm.getSigla();
	}
	
	public int getIdSetor(){
		
		SetorModel sm = new SetorModel();
		sm = LoginController.getUsuario().getSetor();
		int i = sm.getId_Setor();
		return i;
	}
	
	

	

}
