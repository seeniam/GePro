package sistema.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.controller.LoginController;
import sistema.controller.SetorController;
import sistema.controller.UsuarioController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Cadastro_Funcionário extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeCompleto;
	private JTextField textFieldCPF;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldSenha;
	private JLabel lblEntidade;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Funcionário frame = new Cadastro_Funcionário();
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
	public Cadastro_Funcionário() {
		setTitle("Cadastro de Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPessoaLogin = new JLabel("");
		lblPessoaLogin.setIcon(new ImageIcon(Cadastro_Funcionário.class.getResource("/img/img14.png")));
		lblPessoaLogin.setBounds(520, 27, 110, 110);
		contentPane.add(lblPessoaLogin);
		
		JLabel lblCadastroDeFuncionrio = new JLabel("Cadastro de Funcion\u00E1rio");
		lblCadastroDeFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCadastroDeFuncionrio.setBounds(178, 33, 315, 104);
		contentPane.add(lblCadastroDeFuncionrio);
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(368, 391, 112, 23);
		contentPane.add(btnCancelar);
		
		JRadioButton rdbtnResponsavel = new JRadioButton("Respons\u00E1vel");
		rdbtnResponsavel.setSelected(true);
		rdbtnResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnResponsavel.setBackground(new Color(51, 255, 204));
		rdbtnResponsavel.setBounds(122, 144, 145, 23);
		contentPane.add(rdbtnResponsavel);
		
		JRadioButton rdbtnFuncionario = new JRadioButton("Funcion\u00E1rio");
		rdbtnFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnFuncionario.setBackground(new Color(51, 255, 204));
		rdbtnFuncionario.setBounds(360, 144, 145, 23);
		contentPane.add(rdbtnFuncionario);
		
		lblEntidade = new JLabel("Entidade:");
		lblEntidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEntidade.setBounds(43, 193, 110, 14);
		contentPane.add(lblEntidade);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCompleto.setBounds(43, 223, 110, 16);
		contentPane.add(lblNomeCompleto);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(43, 253, 110, 14);
		contentPane.add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(43, 283, 110, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(43, 313, 110, 14);
		contentPane.add(lblSenha);
		
		textFieldNomeCompleto = new JTextField();
		textFieldNomeCompleto.setColumns(10);
		textFieldNomeCompleto.setBounds(195, 222, 423, 20);
		contentPane.add(textFieldNomeCompleto);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(195, 252, 249, 20);
		contentPane.add(textFieldCPF);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(195, 282, 249, 20);
		contentPane.add(textFieldEmail);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(195, 312, 249, 20);
		contentPane.add(passwordFieldSenha);
		
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOk.setBounds(129, 391, 89, 23);
		contentPane.add(btnOk);		
		
		JComboBox comboBoxEntidade = new JComboBox();
		comboBoxEntidade.setBackground(new Color(255, 255, 153));
		comboBoxEntidade.setBounds(195, 192, 145, 20);
		contentPane.add(comboBoxEntidade);
		
		SetorController sc = new SetorController();
		//String siglaSetor = sc.getSiglaSetor();	
		String siglaSetor = LoginController.getUsuario().getSetor().getSigla();
		comboBoxEntidade.addItem(siglaSetor);
		
		
		btnOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int tipo = -1; int rdTipo = 2; int cbTipo = -1;
				UsuarioController uc = new UsuarioController();
				
				char[] chars = passwordFieldSenha.getPassword();
				String senha = String.valueOf(chars);
				
				String entidade = comboBoxEntidade.getName();
				String nome     = textFieldNomeCompleto.getText();
				String cpf      = textFieldCPF.getText();
				String email    = textFieldEmail.getText();
	
				//cbTipo = sc.getIdSetor();
				cbTipo = LoginController.getUsuario().getSetor().getId_Setor();
				
				if(rdbtnResponsavel.isSelected() == true)
					rdTipo = 1;
				
				tipo = uc.definiTipo(cbTipo, rdTipo);
								
				uc.enviaDados(tipo, nome, cpf, email, senha, entidade);
			}
		});
		
		
	}
	
	

	
}
