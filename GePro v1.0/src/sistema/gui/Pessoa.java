package sistema.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.controller.PessoaController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pessoa extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldNumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pessoa frame = new Pessoa();
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
	public Pessoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(26, 72, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(26, 171, 46, 14);
		contentPane.add(lblCpf);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(97, 69, 218, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(97, 168, 218, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PessoaController ps = new PessoaController(); 
				
				String cliente    = textFieldNome.getText();
				String cpfCliente = textFieldCPF.getText();
				int numero        = (int)Float.parseFloat(textFieldNumero.getText());
				ps.enviaDados(cliente, cpfCliente);
			}
		});
		btnCadastrar.setBounds(166, 215, 89, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(176, 22, 46, 14);
		contentPane.add(lblCliente);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(26, 123, 46, 14);
		contentPane.add(lblNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(97, 120, 218, 20);
		contentPane.add(textFieldNumero);
		textFieldNumero.setColumns(10);
	}
	
	
}
