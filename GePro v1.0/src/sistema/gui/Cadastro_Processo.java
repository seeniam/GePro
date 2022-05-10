package sistema.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import sistema.controller.LoginController;
import sistema.controller.PessoaController;
import sistema.controller.ProcessoController;
import sistema.controller.SetorController;
import sistema.model.ConexaoBanco;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class Cadastro_Processo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNumeroProcesso;
	private JTextField textFieldCPFCliente;
	private JTextField textFieldCliente;
	private JTextField textFieldAssunto;
	private JTextField textFieldDescricao;
	int idSetor = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Processo frame = new Cadastro_Processo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro_Processo() {
				
		setTitle("Cadastro de Processos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 627);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(383, 556, 110, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblCadastroDeProcesso = new JLabel("Cadastro de Processo");
		lblCadastroDeProcesso.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCadastroDeProcesso.setBounds(180, 32, 318, 92);
		contentPane.add(lblCadastroDeProcesso);
		
		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBackground(new Color(153, 255, 204));
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAssunto.setBounds(26, 158, 89, 14);
		contentPane.add(lblAssunto);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBackground(new Color(153, 255, 204));
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliente.setBounds(26, 189, 136, 14);
		contentPane.add(lblCliente);
		
		JLabel lblCpfDoCliente = new JLabel("CPF do Cliente:");
		lblCpfDoCliente.setBackground(new Color(153, 255, 204));
		lblCpfDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpfDoCliente.setBounds(26, 228, 136, 14);
		contentPane.add(lblCpfDoCliente);
		
		JLabel lblNumeroDoProcesso = new JLabel("N\u00FAmero do Processo:");
		lblNumeroDoProcesso.setBackground(new Color(153, 255, 204));
		lblNumeroDoProcesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDoProcesso.setBounds(26, 264, 162, 14);
		contentPane.add(lblNumeroDoProcesso);
		
		JLabel lblSetorDestinatario = new JLabel("Setor Destinat\u00E1rio:");
		lblSetorDestinatario.setBackground(new Color(153, 255, 204));
		lblSetorDestinatario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSetorDestinatario.setBounds(26, 304, 136, 14);
		contentPane.add(lblSetorDestinatario);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBackground(new Color(153, 255, 204));
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(26, 340, 136, 23);
		contentPane.add(lblDescricao);
		
		textFieldNumeroProcesso = new JTextField();
		textFieldNumeroProcesso.setColumns(10);
		textFieldNumeroProcesso.setBounds(167, 263, 412, 20);
		contentPane.add(textFieldNumeroProcesso);
		
		textFieldCPFCliente = new JTextField();
		textFieldCPFCliente.setColumns(10);
		textFieldCPFCliente.setBounds(167, 227, 412, 20);
		contentPane.add(textFieldCPFCliente);
		
		textFieldCliente = new JTextField();
		textFieldCliente.setColumns(10);
		textFieldCliente.setBounds(167, 188, 412, 20);
		contentPane.add(textFieldCliente);
		
		textFieldAssunto = new JTextField();
		textFieldAssunto.setColumns(10);
		textFieldAssunto.setBounds(167, 157, 412, 20);
		contentPane.add(textFieldAssunto);
		
		JLabel lblNaturezaDoProcesso = new JLabel("Natureza do Processo:");
		lblNaturezaDoProcesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNaturezaDoProcesso.setBounds(26, 477, 147, 14);
		contentPane.add(lblNaturezaDoProcesso);
		
		JRadioButton rdRequerimento = new JRadioButton("Requerimento");
		rdRequerimento.setSelected(true);
		rdRequerimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdRequerimento.setBackground(new Color(51, 255, 204));
		rdRequerimento.setBounds(184, 475, 134, 23);
		contentPane.add(rdRequerimento);
		
		JRadioButton rdMemorando = new JRadioButton("Memorando");
		rdMemorando.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdMemorando.setBackground(new Color(51, 255, 204));
		rdMemorando.setBounds(320, 475, 109, 23);
		contentPane.add(rdMemorando);
		
		JRadioButton rdOficio = new JRadioButton("Of\u00EDcio");
		rdOficio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdOficio.setBackground(new Color(51, 255, 204));
		rdOficio.setBounds(432, 475, 109, 23);
		contentPane.add(rdOficio);
		
		JLabel lblImgProcesso = new JLabel("");
		lblImgProcesso.setIcon(new ImageIcon(Cadastro_Processo.class.getResource("/img/img6.png")));
		lblImgProcesso.setBounds(25, 14, 110, 110);
		contentPane.add(lblImgProcesso);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(167, 340, 412, 51);
		contentPane.add(textFieldDescricao);
		
		JComboBox comboBoxSetorDestinatario = new JComboBox();
		comboBoxSetorDestinatario.setBackground(new Color(255, 255, 153));
		comboBoxSetorDestinatario.setBounds(167, 303, 161, 20);
		contentPane.add(comboBoxSetorDestinatario);

		//ComboBOX Setor Destinatario
		SetorController sc = new SetorController();
		ArrayList<String> setor = sc.getSetorDestinatario();
		String sigla = "";
		 
		while(idSetor < setor.size()){
			System.out.println(sigla = setor.get(idSetor));
			comboBoxSetorDestinatario.addItem(sigla);
			idSetor++;			
		}
		
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				ProcessoController pc = new ProcessoController();
				PessoaController ps = new PessoaController(); 
				
				String opcaoRD = "";

				if(rdRequerimento.isSelected())
					opcaoRD = rdRequerimento.getText();					
				if(rdMemorando.isSelected())
					opcaoRD = rdMemorando.getText();
				if(rdOficio.isSelected())
					opcaoRD = rdOficio.getText();
				
				System.out.println(opcaoRD);
				
				String assunto = textFieldAssunto.getText();
				int numProcesso =(int)Float.parseFloat(textFieldNumeroProcesso.getText());
				String cliente = textFieldCliente.getText();
				String cpfCliente = textFieldCPFCliente.getText();
				String setor = comboBoxSetorDestinatario.getSelectedItem().toString();
				String descricao = textFieldDescricao.getText();
				
				idSetor -= 1;
				
				pc.enviaDados(numProcesso, assunto, opcaoRD, descricao, setor, cliente, cpfCliente, idSetor);
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEnviar.setBounds(99, 554, 89, 23);
		contentPane.add(btnEnviar);
		
		
	}
}
