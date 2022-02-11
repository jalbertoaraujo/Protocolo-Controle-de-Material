package br.com.protocolo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Entrar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual do Windows
					Entrar frame = new Entrar();
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
	public Entrar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Entrar.class.getResource("/br/com/protocolo/imagem/sdalogo.png")));		
		setTitle(" CONTROLE DE ATIVOS");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Entrar.class.getResource("/br/com/protocolo/imagem/Logo SOLL Nova - C\u00F3pia.png")));
		lblNewLabel.setBounds(6, 3, 457, 212);
		contentPane.add(lblNewLabel);
		
		JLabel lblProtocoloDePonto = new JLabel("Controle de Ativos");
		lblProtocoloDePonto.setForeground(new Color(0, 0, 128));
		lblProtocoloDePonto.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblProtocoloDePonto.setBounds(189, 191, 222, 27);
		contentPane.add(lblProtocoloDePonto);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFocusable(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(Entrar.class.getResource("/br/com/protocolo/imagem/acessar.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal pri = new Principal();
				pri.setVisible(true);				
			}
		});
		btnNewButton.setBounds(434, 194, 55, 52);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(0, 250, 489, 25);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDesenvolvidoPorJorge = new JLabel("Desenvolvido por Jorge Alberto");
		lblDesenvolvidoPorJorge.setBounds(325, 5, 164, 14);
		panel.add(lblDesenvolvidoPorJorge);
		lblDesenvolvidoPorJorge.setForeground(new Color(255, 255, 255));
		lblDesenvolvidoPorJorge.setFont(new Font("Tahoma", Font.BOLD, 9));
	}
}
