package sistema.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import sistema.controller.SetorController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeDaEntidade;
	private JTextField textFieldSigla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro.class.getResource("/img/Logo GePro.png")));
		setTitle("Cadastro de Entidade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 298);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnSetor = new JRadioButton("Setor");
		rdbtnSetor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnSetor.setBackground(new Color(0, 255, 204));
		rdbtnSetor.setBounds(225, 56, 109, 23);
		contentPane.add(rdbtnSetor);
		
		JRadioButton rdbtnCentral = new JRadioButton("Central");
		rdbtnCentral.setSelected(true);
		rdbtnCentral.setBackground(new Color(0, 255, 204));
		rdbtnCentral.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnCentral.setBounds(95, 56, 109, 23);
		contentPane.add(rdbtnCentral);
		
		JLabel lblNomeDaEntidade = new JLabel("Nome da Entidade");
		lblNomeDaEntidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDaEntidade.setBounds(10, 103, 118, 23);
		contentPane.add(lblNomeDaEntidade);
		
		JLabel lblSigla = new JLabel("Sigla");
		lblSigla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSigla.setBounds(52, 144, 76, 23);
		contentPane.add(lblSigla);
		
		textFieldNomeDaEntidade = new JTextField();
		textFieldNomeDaEntidade.setBounds(138, 106, 221, 20);
		contentPane.add(textFieldNomeDaEntidade);
		textFieldNomeDaEntidade.setColumns(10);
		
		textFieldSigla = new JTextField();
		textFieldSigla.setColumns(10);
		textFieldSigla.setBounds(138, 147, 221, 20);
		contentPane.add(textFieldSigla);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetorController setor = new SetorController();
		
				String nome  = textFieldNomeDaEntidade.getText();
				String sigla = textFieldSigla.getText();
				
				setor.enviaDados(nome, sigla);
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrar.setBounds(138, 209, 109, 39);
		contentPane.add(btnCadastrar);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Acesso acesso = new Acesso();
				acesso.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(Cadastro.class.getResource("/img/img13.png")));
		label.setBounds(257, 209, 46, 39);
		contentPane.add(label);
	}

}
