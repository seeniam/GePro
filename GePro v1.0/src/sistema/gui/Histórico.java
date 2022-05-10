package sistema.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistema.controller.LoginController;
import sistema.controller.ProcessoController;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Histórico extends JFrame {

	private JPanel contentPane;
	private JTable tableDataHoraTextoStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Histórico frame = new Histórico();
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
	public Histórico() {
		setTitle("Hist\u00F3rico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPessoaLogin = new JLabel("");
		lblPessoaLogin.setBounds(578, 22, 110, 110);
		lblPessoaLogin.setIcon(new ImageIcon(Histórico.class.getResource("/img/img2.png")));
		
		
		JLabel lblUsuario = new JLabel();
		lblUsuario.setBounds(599, 143, 89, 14);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//lblUsuario.setText(LoginController.getUsuario().getNome());
		System.out.println(lblUsuario.getText());
		JLabel lblProcesso = new JLabel("Processo");
		lblProcesso.setBounds(296, 56, 110, 30);
		lblProcesso.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBounds(52, 174, 64, 14);
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblProtocolo = new JLabel("Protocolo:");
		lblProtocolo.setBounds(52, 215, 80, 14);
		lblProtocolo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(416, 174, 46, 14);
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNatureza = new JLabel("Natureza:\r\n");
		lblNatureza.setBounds(416, 215, 70, 14);
		lblNatureza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPaneAreaDaTabela = new JScrollPane();
		scrollPaneAreaDaTabela.setBounds(52, 249, 630, 121);
		
		tableDataHoraTextoStatus = new JTable();
		tableDataHoraTextoStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		scrollPaneAreaDaTabela.setViewportView(tableDataHoraTextoStatus);
		contentPane.setLayout(null);
		contentPane.add(lblPessoaLogin);
		contentPane.add(lblUsuario);
		contentPane.add(lblProcesso);
		contentPane.add(lblAssunto);
		contentPane.add(lblProtocolo);
		contentPane.add(lblCliente);
		contentPane.add(lblNatureza);
		contentPane.add(scrollPaneAreaDaTabela);
		
		JLabel lblExemplo1 = new JLabel("Material did\u00E1tico em atraso");
		lblExemplo1.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblExemplo1.setBounds(128, 177, 248, 14);
		contentPane.add(lblExemplo1);
		
		JLabel lblExemplo2 = new JLabel("046382917466545-575");
		lblExemplo2.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblExemplo2.setBounds(128, 217, 248, 14);
		contentPane.add(lblExemplo2);
		
		JLabel lblExemplo3 = new JLabel("Passos Dias Aguiar");
		lblExemplo3.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblExemplo3.setBounds(493, 177, 163, 14);
		contentPane.add(lblExemplo3);
		
		JLabel lblExemplo4 = new JLabel("Extrema");
		lblExemplo4.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblExemplo4.setBounds(493, 218, 248, 14);
		contentPane.add(lblExemplo4);
		
		JLabel lblImgProcesso = new JLabel("");
		lblImgProcesso.setIcon(new ImageIcon(Histórico.class.getResource("/img/img6.png")));
		lblImgProcesso.setBounds(30, 22, 110, 110);
		contentPane.add(lblImgProcesso);
		
		JLabel lblStatus = new JLabel("TRANSITO");
		lblStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProcessoController processo = new ProcessoController();
				String status = lblStatus.getText();
				
				status = processo.mudaStatus(status);
				lblStatus.setText(status);
				
			}
		});
		lblStatus.setIcon(new ImageIcon(Histórico.class.getResource("/img/img5.png")));
		lblStatus.setBackground(new Color(51, 255, 255));
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatus.setBounds(94, 396, 125, 47);
		contentPane.add(lblStatus);
		
		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVoltar.setIcon(new ImageIcon(Histórico.class.getResource("/img/img13.png")));
		lblVoltar.setBounds(298, 404, 95, 39);
		contentPane.add(lblVoltar);
		
		
	}
}
