package sistema.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class Acesso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acesso frame = new Acesso();
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
	public Acesso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Acesso.class.getResource("/img/Logo GePro.png")));
		setTitle("Acesso a GePro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 284);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 204));
		contentPane.setBorder(new EmptyBorder(6, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(91, 150, 52, 23);
		contentPane.add(lblLogin);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastro.setBounds(318, 150, 90, 23);
		contentPane.add(lblCadastro);
		
		
		JLabel LoginLabel = new JLabel("");
		LoginLabel.setBackground(Color.WHITE);
		LoginLabel.setIcon(new ImageIcon(Acesso.class.getResource("/img/img8.png")));
		LoginLabel.setBounds(66, 21, 110, 118);
		contentPane.add(LoginLabel);
		
		JLabel CadastroLabel = new JLabel("");
		CadastroLabel.setIcon(new ImageIcon(Acesso.class.getResource("/img/img2.png")));
		CadastroLabel.setBounds(298, 29, 110, 110);
		contentPane.add(CadastroLabel);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cadastro cadas = new Cadastro();
				cadas.setVisible(true);
				dispose();
			}
		});
		label.setIcon(new ImageIcon(Acesso.class.getResource("/img/img10.png")));
		label.setBounds(328, 184, 46, 39);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		label_1.setIcon(new ImageIcon(Acesso.class.getResource("/img/img10.png")));
		label_1.setBounds(101, 184, 46, 39);
		contentPane.add(label_1);
		
		
	}
}
