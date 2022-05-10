package sistema.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistema.controller.LoginController;
import sistema.controller.ProcessoController;
import sistema.controller.SetorController;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal_Setor extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscarProcesso;
	private JTable tableProcessoDataTipoStatus;
	private boolean user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_Setor frame = new Principal_Setor(true);
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
	public Principal_Setor(boolean usuarioComum) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal_Setor.class.getResource("/img/Logo GePro.png")));
		setBackground(new Color(153, 255, 255));
		this.user = usuarioComum;
		
		setTitle("Principal Setor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 515);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(51, 255, 204));
		setJMenuBar(menuBar);
		
		JMenu mnArquivos = new JMenu("Arquivos");
		mnArquivos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnArquivos);
		
		JMenu mnFuncoes = new JMenu("Fun\u00E7\u00F5es");
		mnFuncoes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnFuncoes);
		
		JMenuItem mntmTransferirProcesso = new JMenuItem("Transferir Processo");
		mntmTransferirProcesso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFuncoes.add(mntmTransferirProcesso);
		
		JMenuItem mntmCadastrarFuncionarios = new JMenuItem("Cadastrar Funcion\u00E1rios");
		mntmCadastrarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean setor = false;
				Cadastro_Funcionário cadas = new Cadastro_Funcionário();
				cadas.setVisible(true);
				//dispose();
				
			}
		});
		mntmCadastrarFuncionarios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFuncoes.add(mntmCadastrarFuncionarios);
		
		JMenuItem mntmProcurarProcessos = new JMenuItem("Procurar Processos");
		mntmProcurarProcessos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFuncoes.add(mntmProcurarProcessos);
		
		
		
		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		mnRelatorios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnRelatorios);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnAjuda);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginController lg = new LoginController();
				lg.logout();
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		mnAjuda.add(mntmLogout);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLoginPessoa = new JLabel("");
		lblLoginPessoa.setBounds(589, 20, 110, 110);
		lblLoginPessoa.setIcon(new ImageIcon(Principal_Setor.class.getResource("/img/img14.png")));
		
		JLabel lblResponsavel = new JLabel("Respons\u00E1vel");
		lblResponsavel.setBounds(603, 127, 110, 22);
		lblResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBoxFiltroPesquisa = new JComboBox();
		comboBoxFiltroPesquisa.setBackground(new Color(153, 255, 255));
		comboBoxFiltroPesquisa.setBounds(10, 187, 156, 22);
		comboBoxFiltroPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxFiltroPesquisa.setModel(new DefaultComboBoxModel(new String[] {"N\u00FAmero do Processo", "Status", "Assunto", "Tipo", "Todos"}));
		
		txtBuscarProcesso = new JTextField();
		txtBuscarProcesso.setBackground(new Color(51, 255, 204));
		txtBuscarProcesso.setBounds(180, 187, 513, 22);
		txtBuscarProcesso.setColumns(10);
		
		JScrollPane scrollPaneAreaDaTabela = new JScrollPane();
		scrollPaneAreaDaTabela.setBounds(180, 224, 533, 133);
		
		tableProcessoDataTipoStatus = new JTable();
		tableProcessoDataTipoStatus.setBackground(new Color(255, 255, 204));
		tableProcessoDataTipoStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		scrollPaneAreaDaTabela.setViewportView(tableProcessoDataTipoStatus);
		contentPane.setLayout(null);
		contentPane.add(lblLoginPessoa);
		contentPane.add(lblResponsavel);
		contentPane.add(comboBoxFiltroPesquisa);
		contentPane.add(txtBuscarProcesso);
		contentPane.add(scrollPaneAreaDaTabela);
		
		JLabel lblProcessosSetor = new JLabel("Processos - Setor");
		lblProcessosSetor.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblProcessosSetor.setBounds(191, 57, 264, 83);
		contentPane.add(lblProcessosSetor);
		
		JLabel lblImgProcesso = new JLabel("");
		lblImgProcesso.setIcon(new ImageIcon(Principal_Setor.class.getResource("/img/img6.png")));
		lblImgProcesso.setBounds(25, 20, 110, 110);
		contentPane.add(lblImgProcesso);
		
		
		ProcessoController tc = new ProcessoController();
		
		tableProcessoDataTipoStatus.setModel(tc);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProcessoController pc = new ProcessoController();
				String search = txtBuscarProcesso.getText();
				int index = -1; String atributo ="";
				comboBoxFiltroPesquisa.getSelectedItem();
				index = comboBoxFiltroPesquisa.getSelectedIndex();
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
				tableProcessoDataTipoStatus.setModel(pc);
			}
		});
		label.setIcon(new ImageIcon(Principal_Setor.class.getResource("/img/img9.png")));
		label.setBounds(698, 177, 36, 32);
		contentPane.add(label);
		
		JLabel lblHistorico = new JLabel("");
		lblHistorico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Histórico hist = new Histórico();
				hist.setVisible(true);
			}
		});
		lblHistorico.setIcon(new ImageIcon(Principal_Setor.class.getResource("/img/img7.png")));
		lblHistorico.setBounds(394, 379, 36, 39);
		contentPane.add(lblHistorico);
		
		JLabel lblEnviarProcesso = new JLabel("");
		lblEnviarProcesso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EnviarProcesso ep = new EnviarProcesso();
				ep.setVisible(true);
			}
		});
		lblEnviarProcesso.setIcon(new ImageIcon(Principal_Setor.class.getResource("/img/img11.png")));
		lblEnviarProcesso.setBounds(448, 379, 46, 39);
		contentPane.add(lblEnviarProcesso);
		
		JLabel lblCadastrarUsuario = new JLabel("");
		lblCadastrarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cadastro_Funcionário cadas = new Cadastro_Funcionário();
				cadas.setVisible(true);
			}
		});
		lblCadastrarUsuario.setIcon(new ImageIcon(Principal_Setor.class.getResource("/img/img12.png")));
		lblCadastrarUsuario.setBounds(336, 379, 36, 39);
		contentPane.add(lblCadastrarUsuario);
		
		if(this.user){
			mntmCadastrarFuncionarios.setVisible(false);
			lblResponsavel.setText("Funcionario");
			lblEnviarProcesso.setVisible(false);
			lblHistorico.setVisible(false);
			
		}
		
	}
	
	


}
