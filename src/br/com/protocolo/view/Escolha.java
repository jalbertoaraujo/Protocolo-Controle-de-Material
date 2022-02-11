package br.com.protocolo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.protocolo.DAO.ListarUltimoHistoricoDao;
import br.com.protocolo.uteis.AbreTelaAlterarProduto;
import br.com.protocolo.uteis.AbreTelaHistorico;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class Escolha extends JFrame {

	private JPanel contentPane;
	public static JTable tabelainformacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual do Windows
					Escolha frame = new Escolha();
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
	public Escolha() {
		setTitle(" OP\u00C7\u00D5ES");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Escolha.class.getResource("/br/com/protocolo/imagem/livro.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 395, 88);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("ALTERAR PRODUTO");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setIcon(new ImageIcon(Escolha.class.getResource("/br/com/protocolo/imagem/alterar.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AbreTelaAlterarProduto atap = new AbreTelaAlterarProduto();
				atap.AbreTelaHistorico();
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(105, 7, 281, 46);
		contentPane.add(scrollPane);
		
		tabelainformacao = new JTable();
		tabelainformacao.setRowSelectionAllowed(false);
		tabelainformacao.setEnabled(false);
		tabelainformacao.setShowVerticalLines(false);
		tabelainformacao.setShowHorizontalLines(false);
		tabelainformacao.setShowGrid(false);
		tabelainformacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabelainformacao.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"\u00DALTIMA MOVIMENTA\u00C7\u00C3O", "CONTRATO ATUAL"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelainformacao.getColumnModel().getColumn(0).setResizable(false);
		tabelainformacao.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(tabelainformacao);
		btnNewButton.setBounds(5, 2, 49, 56);
		contentPane.add(btnNewButton);
		
		JButton btnHistrico = new JButton("");
		btnHistrico.setToolTipText("INSERIR NOVA MOVIMENTA\u00C7\u00C3O");
		btnHistrico.setContentAreaFilled(false);
		btnHistrico.setOpaque(false);
		btnHistrico.setBorderPainted(false);
		btnHistrico.setIcon(new ImageIcon(Escolha.class.getResource("/br/com/protocolo/imagem/historico1.png")));
		btnHistrico.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHistrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AbreTelaHistorico ath = new AbreTelaHistorico();
				ath.AbreTelaHistorico();
				dispose();
			}
		});
		btnHistrico.setBounds(54, 2, 49, 56);
		contentPane.add(btnHistrico);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Escolha.class.getResource("/br/com/protocolo/imagem/fundo.png")));
		lblNewLabel.setBounds(0, 0, 390, 61);
		contentPane.add(lblNewLabel);
		
		tabelainformacao.getTableHeader().setReorderingAllowed(false);// manter menu da tabelafixo
		
		ListarUltimoHistoricoDao luhd = new ListarUltimoHistoricoDao();
		luhd.listar();
	}
}
