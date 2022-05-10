package sistema.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistema.controller.SetorController;

import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;

public class EnviarProcesso extends JFrame {

	private JPanel contentPane;
	private JTable tableProcessosProtocolos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnviarProcesso frame = new EnviarProcesso();
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
	public EnviarProcesso() {
		setTitle("Enviar Processo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(162, 406, 89, 39);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Relat\u00F3rio");
		lblNewLabel.setBounds(174, 249, 98, 24);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JCheckBox chckbxSetorDestinatario = new JCheckBox("Setor Destinat\u00E1rio");
		chckbxSetorDestinatario.setBounds(29, 135, 140, 23);
		chckbxSetorDestinatario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxSetorDestinatario.setBackground(new Color(51, 255, 204));
		
		JCheckBox chckbxCentral = new JCheckBox("Central");
		chckbxCentral.setBounds(29, 168, 140, 23);
		chckbxCentral.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCentral.setBackground(new Color(51, 255, 204));
		
		JComboBox comboBoxSetor = new JComboBox();
		comboBoxSetor.setBounds(197, 138, 121, 20);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(134, 11, 290, 101);
		
		tableProcessosProtocolos = new JTable();
		tableProcessosProtocolos.setModel(new DefaultTableModel(
			
		));
		scrollPane.setViewportView(tableProcessosProtocolos);
		contentPane.setLayout(null);
		contentPane.add(chckbxCentral);
		contentPane.add(lblNewLabel);
		contentPane.add(btnEnviar);
		contentPane.add(chckbxSetorDestinatario);
		contentPane.add(comboBoxSetor);
		contentPane.add(scrollPane);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(EnviarProcesso.class.getResource("/img/img13.png")));
		btnVoltar.setBounds(120, 406, 39, 39);
		contentPane.add(btnVoltar);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBackground(Color.WHITE);
		formattedTextField.setBounds(47, 278, 324, 117);
		contentPane.add(formattedTextField);
		
		JLabel lblImgProcesso = new JLabel("");
		lblImgProcesso.setIcon(new ImageIcon(EnviarProcesso.class.getResource("/img/img6.png")));
		lblImgProcesso.setBounds(10, 11, 110, 110);
		contentPane.add(lblImgProcesso);
		
		SetorController sc = new SetorController();
		ArrayList<String> setor = sc.getSetorDestinatario();
		String sigla = "";
		int idSetor = 1;
		while(idSetor < setor.size()){
			System.out.println(sigla = setor.get(idSetor));
			comboBoxSetor.addItem(sigla);
			idSetor++;			
		}
	}
}
