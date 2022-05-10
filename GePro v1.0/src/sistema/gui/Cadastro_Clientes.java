package sistema.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Cadastro_Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEndereco;
	private JTextField textFieldEmail;
	private JTextField textFieldIdentidade;
	private JTextField textFieldCPF;
	private JTextField textFieldCelular;
	private JTextField textFieldTelefone;
	private JTextField textFieldCEP;
	private JTextField textFieldUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Clientes frame = new Cadastro_Clientes();
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
	public Cadastro_Clientes() {
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 452);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelPessoa = new JLabel("");
		LabelPessoa.setIcon(new ImageIcon(Cadastro_Clientes.class.getResource("/img/img6.png")));
		LabelPessoa.setBounds(27, 35, 110, 110);
		contentPane.add(LabelPessoa);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOk.setBounds(135, 379, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(396, 381, 104, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNovoProcesso = new JLabel("Processo");
		lblNovoProcesso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNovoProcesso.setBounds(315, 329, 71, 39);
		contentPane.add(lblNovoProcesso);
		
		JButton btnNovoProcesso = new JButton("");
		btnNovoProcesso.setIcon(new ImageIcon(Cadastro_Clientes.class.getResource("/img/img5.png")));
		btnNovoProcesso.setBounds(266, 329, 39, 39);
		contentPane.add(btnNovoProcesso);
		
		JRadioButton rdbtnEntidade = new JRadioButton("Entidade");
		rdbtnEntidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnEntidade.setBackground(Color.WHITE);
		rdbtnEntidade.setBounds(182, 122, 109, 23);
		contentPane.add(rdbtnEntidade);
		
		JRadioButton rdbtnPessoaFisica = new JRadioButton("Pessoa F\u00EDsica");
		rdbtnPessoaFisica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnPessoaFisica.setBackground(Color.WHITE);
		rdbtnPessoaFisica.setBounds(351, 124, 109, 23);
		contentPane.add(rdbtnPessoaFisica);
		
		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCadastroDeClientes.setBounds(200, 70, 289, 45);
		contentPane.add(lblCadastroDeClientes);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(27, 181, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereco.setBounds(27, 211, 80, 15);
		contentPane.add(lblEndereco);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(27, 241, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblIdentidade = new JLabel("Identidade:");
		lblIdentidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdentidade.setBounds(27, 271, 80, 14);
		contentPane.add(lblIdentidade);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(351, 181, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCep.setBounds(351, 211, 46, 14);
		contentPane.add(lblCep);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUf.setBounds(572, 211, 46, 14);
		contentPane.add(lblUf);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(351, 241, 46, 14);
		contentPane.add(lblCelular);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(351, 271, 80, 14);
		contentPane.add(lblTelefone);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(102, 180, 240, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(101, 210, 240, 20);
		contentPane.add(textFieldEndereco);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(102, 240, 240, 20);
		contentPane.add(textFieldEmail);
		
		textFieldIdentidade = new JTextField();
		textFieldIdentidade.setColumns(10);
		textFieldIdentidade.setBounds(102, 270, 240, 20);
		contentPane.add(textFieldIdentidade);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(421, 180, 240, 20);
		contentPane.add(textFieldCPF);
		
		textFieldCelular = new JTextField();
		textFieldCelular.setColumns(10);
		textFieldCelular.setBounds(421, 240, 240, 20);
		contentPane.add(textFieldCelular);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(421, 270, 240, 20);
		contentPane.add(textFieldTelefone);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setColumns(10);
		textFieldCEP.setBounds(421, 210, 149, 20);
		contentPane.add(textFieldCEP);
		
		textFieldUF = new JTextField();
		textFieldUF.setColumns(10);
		textFieldUF.setBounds(597, 210, 62, 20);
		contentPane.add(textFieldUF);
	}
}
