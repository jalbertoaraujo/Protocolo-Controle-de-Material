package br.com.protocolo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.protocolo.DAO.BuscarProdutoDao;
import br.com.protocolo.DAO.ListarProdutoDao;
import br.com.protocolo.DAO.RelatorioGeralAtivos;
import br.com.protocolo.DAO.SomaValorProdutoDao;
import br.com.protocolo.uteis.AbreTelaHistorico;
import br.com.protocolo.uteis.ColorirTabela;
import br.com.protocolo.uteis.UpperCaseDocument;

import java.awt.Frame;
import java.awt.Window.Type;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;

public class Principal extends JFrame {
	public static JTable tabelaproduto;
	public static JTextField tfprodutorelacao;
	public static JTextField tfvalorativos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual
																									// do
																									// Windows
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Principal.class.getResource("/br/com/protocolo/imagem/livro.png")));
		setTitle(" RELA\u00C7\u00C3O DE PRODUTOS");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1236, 503);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RelatorioGeralAtivos rga = new RelatorioGeralAtivos();
				rga.RelatorioGeralAtivos();
			}
		});
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CadastrarContrato cc = new CadastrarContrato();
				cc.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(Principal.class.getResource("/br/com/protocolo/imagem/departamento.jpg")));
		button_1.setToolTipText("CADASTRAR NOVO CONTRATO");
		button_1.setRolloverEnabled(false);
		button_1.setRequestFocusEnabled(false);
		button_1.setOpaque(false);
		button_1.setFocusable(false);
		button_1.setFocusTraversalKeysEnabled(false);
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBounds(743, 11, 41, 37);
		getContentPane().add(button_1);
		button.setIcon(new ImageIcon(Principal.class.getResource("/br/com/protocolo/imagem/relatorio2.png")));
		button.setToolTipText("RELAT\u00D3RIO TOTAL DE ATIVOS");
		button.setRolloverEnabled(false);
		button.setRequestFocusEnabled(false);
		button.setOpaque(false);
		button.setFocusable(false);
		button.setFocusTraversalKeysEnabled(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBounds(694, 11, 41, 37);
		getContentPane().add(button);
		
		JLabel lblValorTotalDe = new JLabel("Valor Total de Ativos");
		lblValorTotalDe.setForeground(Color.WHITE);
		lblValorTotalDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorTotalDe.setBounds(925, 28, 126, 14);
		getContentPane().add(lblValorTotalDe);
		
		tfvalorativos = new JTextField();
		tfvalorativos.setEditable(false);
		tfvalorativos.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfvalorativos.setBackground(SystemColor.inactiveCaption);
		tfvalorativos.setBounds(1053, 25, 163, 20);
		getContentPane().add(tfvalorativos);
		tfvalorativos.setColumns(10);
		
		JLabel lblBuscarProduto = new JLabel("Buscar Produto");
		lblBuscarProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscarProduto.setForeground(SystemColor.window);
		lblBuscarProduto.setBounds(11, 9, 90, 14);
		getContentPane().add(lblBuscarProduto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 1210, 410);
		getContentPane().add(scrollPane);

		tabelaproduto = new JTable();
		tabelaproduto.setAutoCreateRowSorter(true);
		tabelaproduto.setColumnSelectionAllowed(true);
		tabelaproduto.setCellSelectionEnabled(true);
		tabelaproduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabelaproduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				
				Escolha esc = new Escolha();
				esc.setVisible(true);
				
			}
		});
		tabelaproduto.setShowGrid(false);
		tabelaproduto.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID. PRODUTO", "GRUPO", "PATRIM\u00D4NIO", "C\u00D3D.", "DESCRI\u00C7\u00C3O", "MARCA", "MODELO", "DATA", "VALOR"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelaproduto.getColumnModel().getColumn(0).setResizable(false);
		tabelaproduto.getColumnModel().getColumn(0).setPreferredWidth(23);
		tabelaproduto.getColumnModel().getColumn(1).setResizable(false);
		tabelaproduto.getColumnModel().getColumn(1).setPreferredWidth(17);
		tabelaproduto.getColumnModel().getColumn(2).setResizable(false);
		tabelaproduto.getColumnModel().getColumn(2).setPreferredWidth(20);
		tabelaproduto.getColumnModel().getColumn(3).setResizable(false);
		tabelaproduto.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabelaproduto.getColumnModel().getColumn(4).setResizable(false);
		tabelaproduto.getColumnModel().getColumn(4).setPreferredWidth(270);
		tabelaproduto.getColumnModel().getColumn(5).setResizable(false);
		tabelaproduto.getColumnModel().getColumn(6).setResizable(false);
		tabelaproduto.getColumnModel().getColumn(6).setPreferredWidth(35);
		tabelaproduto.getColumnModel().getColumn(7).setResizable(false);
		tabelaproduto.getColumnModel().getColumn(7).setPreferredWidth(30);
		tabelaproduto.getColumnModel().getColumn(8).setResizable(false);
		tabelaproduto.getColumnModel().getColumn(8).setPreferredWidth(30);
		scrollPane.setViewportView(tabelaproduto);

		tfprodutorelacao = new JTextField();
		tfprodutorelacao.setBackground(SystemColor.inactiveCaption);
		tfprodutorelacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfprodutorelacao.setBounds(10, 25, 564, 20);
		getContentPane().add(tfprodutorelacao);
		tfprodutorelacao.setColumns(10);
		tfprodutorelacao.setDocument(new UpperCaseDocument());

		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setRolloverEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarProduto cp = new CadastrarProduto();
				cp.setVisible(true);
			}
		});
		btnNewButton.setToolTipText("CADASTRAR NOVO PRODUTO");
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/br/com/protocolo/imagem/cadastar.png")));
		btnNewButton.setBounds(643, 10, 41, 37);
		getContentPane().add(btnNewButton);

		JButton btnbuscar = new JButton("");
		btnbuscar.setContentAreaFilled(false);
		btnbuscar.setFocusPainted(false);
		btnbuscar.setFocusTraversalKeysEnabled(false);
		btnbuscar.setOpaque(false);
		btnbuscar.setRequestFocusEnabled(false);
		btnbuscar.setRolloverEnabled(false);
		btnbuscar.setFocusable(false);
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tfprodutorelacao.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "PREENCHER O CAMPO PARA REALIZAR A BUSCA");
				} else {
					BuscarProdutoDao bpd = new BuscarProdutoDao();
					bpd.listar();
				}
			}
		});
		btnbuscar.setToolTipText("BUSCAR PRODUTO");
		btnbuscar.setIcon(new ImageIcon(Principal.class.getResource("/br/com/protocolo/imagem/listar.png")));
		btnbuscar.setBounds(598, 10, 41, 37);
		getContentPane().add(btnbuscar);
		getRootPane().setDefaultButton(btnbuscar);// entrar com a tecla enter
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/br/com/protocolo/imagem/fundo3.jpg")));
		lblNewLabel.setBounds(0, 0, 1230, 475);
		getContentPane().add(lblNewLabel);

		tabelaproduto.setDefaultRenderer(Object.class, new ColorirTabela());
		tabelaproduto.getTableHeader().setReorderingAllowed(false);// manter
																	// menu da
																	// tabelafixo

		ListarProdutoDao lpd = new ListarProdutoDao();
		lpd.listar();
		
		SomaValorProdutoDao svp = new SomaValorProdutoDao();
		svp.listar();
	}
}
