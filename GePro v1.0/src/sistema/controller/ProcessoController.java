package sistema.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import sistema.model.PessoaModel;
import sistema.model.ProcessoModel;
import sistema.model.SetorModel;
import sistema.model.UsuarioModel; 


public class ProcessoController extends AbstractTableModel{

	private ArrayList<ProcessoModel> processos;
	private String[] colunas = {"Processo", "Status", "Assunto", "Natureza do Processo"};
		
	
	public ProcessoController(ArrayList<ProcessoModel> processos, String[] colunas) {
		this.processos = processos;
		this.colunas   = colunas;
	}

	public ProcessoController() {
		this.processos = ProcessoModel.buscaProcesso(LoginController.getUsuario().getSetor());
	}		
	
	public void search(String atributo, String key){
		this.processos = ProcessoModel.buscaDados(LoginController.getUsuario().getSetor(),atributo, key);
	}
	
	public String mudaStatus(String status){
		
		if(status == "TRANSITO")
			status = "RECEBIDO";
		if(status == "RECEBIDO")
			status = "ANÁLISE";
			
		return status;
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public int getRowCount() {		
		return this.processos.size();
	}
	
	public String getColumnName(int column){
		return colunas[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch(columnIndex){
		case 0:
			return this.processos.get(rowIndex).getIdProcesso();			
		case 1:
			return this.processos.get(rowIndex).getStatus(); 
		case 2:
			return this.processos.get(rowIndex).getAssunto(); 
		case 3:
			return this.processos.get(rowIndex).getNaturezaProcesso();
		default:
			System.err.println("Índice inválido para propriedade do bean Usuario.class");
			return null;
			}		
	}
	
	public void enviaDados(int numProcesso, String assunto, String natureza, String descricao, String setor, String nome, String cpf, int idSetor){
		
		PessoaController pc = new PessoaController();
		ProcessoModel dp = new ProcessoModel();
		PessoaModel   pm = new PessoaModel();
		UsuarioModel  um = new UsuarioModel();
		SetorModel    sm = new SetorModel();
		
		int idPessoa = -1;		                                                                                                                                                                                                                                                                          		
                                                                                                                                                                                                                                                       		
		sm.setSigla(setor);
		sm.setId_Setor(idSetor);
		um = LoginController.getUsuario();
			
		pm = pc.enviaDados(nome, cpf);
	
		idPessoa = pc.getIdPessoaController(pm, cpf);
		pm.setID(idPessoa);		
		
		dp.setIdProcesso(numProcesso);
		dp.setAssunto(assunto);
		dp.setNaturezaProcesso(natureza);
		dp.setDescricao(descricao);		
		dp.setIdUsuario(um);
		dp.setIdPessoa(pm);
		dp.setIdSetor(sm);
		
		dp.salvaDados();
		
		JOptionPane.showMessageDialog(null, "Processo N°" + numProcesso + " enviado com sucesso!");
		fireTableCellUpdated(getRowCount(), getColumnCount());
	}
}
	

