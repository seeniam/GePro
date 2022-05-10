package sistema.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistema.model.ProcessoModel;
import sistema.controller.LoginController;
import sistema.controller.ProcessoController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Principal_Central extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscarProcesso;
	private JTable tableProcessos;
	private boolean user;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_Central frame = new Principal_Central(true);
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
	public Principal_Central(boolean usuarioComum) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal_Central.class.getResource("/img/Logo GePro.png")));
		setBackground(new Color(153, 255, 204));
		this.user = usuarioComum;
		
		setTitle("Principal Central");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 515);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 102));
		setJMenuBar(menuBar);
		
		JMenu mnArquivos = new JMenu("Arquivos");
		mnArquivos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnArquivos);
		
		JMenu mnFuncoes = new JMenu("Fun\u00E7\u00F5es");
		mnFuncoes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnFuncoes);
		
		
		
		JMenuItem mntmProcurarProcessos = new JMenuItem("Procurar Processos");
		mntmProcurarProcessos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFuncoes.add(mntmProcurarProcessos);
		
		JMenuItem mntmCriarProcessos = new JMenuItem("Criar Processos");
		mntmCriarProcessos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastro_Processo cp = new Cadastro_Processo();
				cp.setVisible(true);
				
			}
		});
		mntmCriarProcessos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFuncoes.add(mntmCriarProcessos);
		
		JMenuItem mntmCadastrarFuncionrios = new JMenuItem("Cadastrar Funcion\u00E1rios");
		mntmCadastrarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean setor = true;
				Cadastro_Funcionário cadas = new Cadastro_Funcionário();
				cadas.setVisible(true);
				
			}
		});
		mntmCadastrarFuncionrios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFuncoes.add(mntmCadastrarFuncionrios);
		
		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		mnRelatorios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnRelatorios);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnAjuda);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginController lg = new LoginController();
				lg.logout();
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		mnAjuda.add(mntmLogout);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLoginPessoa = new JLabel("");
		lblLoginPessoa.setVerticalAlignment(SwingConstants.TOP);
		lblLoginPessoa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoginPessoa.setBounds(583, 20, 110, 110);
		lblLoginPessoa.setIcon(new ImageIcon(Principal_Central.class.getResource("/img/img14.png")));
		
		JLabel lblResponsavel = new JLabel("    Respons\u00E1vel");
		lblResponsavel.setBounds(583, 141, 110, 22);
		lblResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBoxFiltroPesquisa = new JComboBox();
		comboBoxFiltroPesquisa.setBackground(new Color(255, 255, 255));
		comboBoxFiltroPesquisa.setBounds(10, 187, 156, 22);
		comboBoxFiltroPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxFiltroPesquisa.setModel(new DefaultComboBoxModel(new String[] {"N\u00FAmero do Processo", "Status", "Assunto", "Natureza"}));
		comboBoxFiltroPesquisa.setToolTipText("");
		
		txtBuscarProcesso = new JTextField();
		txtBuscarProcesso.setBackground(new Color(255, 255, 255));
		txtBuscarProcesso.setBounds(180, 187, 513, 22);
		txtBuscarProcesso.setText("");
		txtBuscarProcesso.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane tabela = new JScrollPane();
		tabela.setBounds(180, 219, 541, 140);
		
		tableProcessos = new JTable();
		tableProcessos.setBackground(new Color(255, 255, 204));
		
		
		tableProcessos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		
		tabela.setViewportView(tableProcessos);
		contentPane.setLayout(null);
		contentPane.add(lblLoginPessoa);
		contentPane.add(lblResponsavel);
		contentPane.add(comboBoxFiltroPesquisa);
		contentPane.add(tabela);
		contentPane.add(txtBuscarProcesso);
		
		JLabel lblProcessosCentral = new JLabel("Processos - Central");
		lblProcessosCentral.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblProcessosCentral.setBounds(191, 57, 264, 83);
		contentPane.add(lblProcessosCentral);
		
		JLabel lblImgProcesso = new JLabel("");
		lblImgProcesso.setIcon(new ImageIcon(Principal_Central.class.getResource("/img/img6.png")));
		lblImgProcesso.setBounds(24, 20, 110, 110);
		contentPane.add(lblImgProcesso);
		
		ProcessoController tc = new ProcessoController();
		tableProcessos.setModel(tc);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cadastro_Processo cp = new Cadastro_Processo();
				cp.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(Principal_Central.class.getResource("/img/img4.png")));
		label.setBounds(236, 391, 42, 39);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Histórico hist = new Histórico();
				hist.setVisible(true);
				
			}
		});
		label_1.setIcon(new ImageIcon(Principal_Central.class.getResource("/img/img7.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(331, 376, 55, 67);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Principal_Central.class.getResource("/img/img12.png")));
		label_2.setBounds(385, 391, 46, 39);
		contentPane.add(label_2);
		
		JLabel lblEnviarProcesso = new JLabel("");
		lblEnviarProcesso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EnviarProcesso ep = new EnviarProcesso();
				ep.setVisible(true);	
			}
		});
		lblEnviarProcesso.setIcon(new ImageIcon(Principal_Central.class.getResource("/img/img11.png")));
		lblEnviarProcesso.setBounds(441, 391, 46, 39);
		contentPane.add(lblEnviarProcesso);
		
		JLabel lblPesquisa = new JLabel("");
		lblPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProcessoController pc = new ProcessoController();
				String search = txtBuscarProcesso.getText();
				String atributo ="";
				comboBoxFiltroPesquisa.getSelectedItem();
				int index = comboBoxFiltroPesquisa.getSelectedIndex();
				switch(index){
					case 0:
						atributo = "id_Processo";break;				
					case 1:
						atributo = "status_Processo";break;
					case 2:
						atributo = "assunto_Processo";break;
					case 3:
						atributo = "natureza_Processo";break;					
				}			
				pc.search(atributo, search);
				tableProcessos.setModel(pc);
			}
		});
		lblPesquisa.setIcon(new ImageIcon(Principal_Central.class.getResource("/img/img9.png")));
		lblPesquisa.setBounds(698, 170, 36, 39);
		contentPane.add(lblPesquisa);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cadastro_Funcionário cadas = new Cadastro_Funcionário();
				cadas.setVisible(true);
			}
		});
		label_5.setIcon(new ImageIcon(Principal_Central.class.getResource("/img/img1.png")));
		label_5.setBounds(277, 391, 36, 39);
		contentPane.add(label_5);
		
		if(this.user){			
			label_5.setVisible(false);
			lblPesquisa.setVisible(false);
			lblEnviarProcesso.setVisible(false);
			label_2.setVisible(false);
			label_1.setVisible(false);
			label.setVisible(false);
			lblResponsavel.setText("Funcionario");
			mntmCadastrarFuncionrios.setVisible(false);
		}
	}
}
