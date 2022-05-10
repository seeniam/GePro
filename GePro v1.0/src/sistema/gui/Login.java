package sistema.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.controller.LoginController;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldUsuario;
	private JPasswordField passwordFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		LoginController ob = new LoginController();
		ob.logout();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/Walpaper GePro.png")));
		setTitle("Acesso a GePro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 270);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(51, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(10, 77, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(10, 125, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				char[] chars = passwordFieldSenha.getPassword();
				String senha = String.valueOf(chars);					
				
				
				
				if(ob.autentica(txtFieldUsuario.getText(), senha)){
					JOptionPane.showMessageDialog(null, "Logado");
					int tipo = ob.verificaTipoUsuario();
					Principal_Central pc;
					Principal_Setor ps;
					Acesso acesso;
					boolean usuarioComum = false;
					
					switch(tipo){
						case 0: acesso = new Acesso(); acesso.setVisible(true); dispose(); break;
						case 1: pc = new Principal_Central(usuarioComum); pc.setVisible(true); dispose(); break;
						case 2: usuarioComum = true; pc = new Principal_Central(usuarioComum); pc.setVisible(true); dispose(); break;
						case 3: ps = new Principal_Setor(usuarioComum); ps.setVisible(true); dispose(); break;
						case 4: usuarioComum = true; ps = new Principal_Setor(usuarioComum);   ps.setVisible(true); dispose(); break;
						case 5: 
					}									
					ob.estaLogado();
					dispose();					
				}
				else{
					JOptionPane.showMessageDialog(null, "Erro");
					passwordFieldSenha.setText("");
					passwordFieldSenha.requestFocus();
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(142, 184, 89, 39);
		contentPane.add(btnLogin);
		
		txtFieldUsuario = new JTextField();
		txtFieldUsuario.setBounds(79, 76, 322, 20);
		contentPane.add(txtFieldUsuario);
		txtFieldUsuario.setColumns(10);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setToolTipText("");
		passwordFieldSenha.setBounds(79, 124, 322, 20);
		contentPane.add(passwordFieldSenha);
		
		JLabel lblVoltar = new JLabel("");
		lblVoltar.setVisible(false);
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Acesso acesso = new Acesso();
				acesso.setVisible(true);
			}
		});
		lblVoltar.setIcon(new ImageIcon(Login.class.getResource("/img/img13.png")));
		lblVoltar.setBounds(241, 184, 39, 39);
		contentPane.add(lblVoltar);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(142, 185, 89, 36);
		contentPane.add(lblLogin);
	}
}
