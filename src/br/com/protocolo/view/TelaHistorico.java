package br.com.protocolo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.protocolo.DAO.CadastrarHistoricoDao;
import br.com.protocolo.DAO.ListarHistoricoDao;
import br.com.protocolo.DAO.PovoarComboMovimentacaodeDao;
import br.com.protocolo.DAO.PovoarComboMovimentacaoparaDao;
import br.com.protocolo.DAO.RelatorioHistorico;
import br.com.protocolo.uteis.ColorirTabela;
import br.com.protocolo.uteis.ColorirTabelaHistorico;
import br.com.protocolo.uteis.UpperCaseDocument;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class TelaHistorico extends JFrame {

	private JPanel contentPane;
	public static JTextField tfhistcategoria;
	public static JTextField tfhistpatrimonio;
	public static JTextField tfhistcod;
	public static JTextField tfhistdescricao;
	public static JTextField tfhistmarca;
	public static JTextField tfhistmodelo;
	public static JTextField tfhistdata;
	public static JTextField tfhistvalor;
	public static JTextField tfhistlocal;
	private final JSeparator separator = new JSeparator();
	private JLabel lblPortador;
	private JLabel lblMovimentao;
	private JLabel lblResponsvel;
	private JLabel label_6;
	private JLabel lblContrato;
	public static JTextField tfhistportador;
	public static JTextField tfhistresp;
	public static JTextField tfhistdatahist;
	public static JTextField tfhistlocalhist;
	public static JLabel lblMovimentaoPara;
	public static JTable tabelahistorico;
	private JLabel lblId;
	public static JTextField tfhistid;
	private JLabel lblNewLabel;
	private JButton button;
	public static JComboBox cbmovimentacaode;
	public static JComboBox cbmovimentacaopara;

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
					TelaHistorico frame = new TelaHistorico();
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
	public TelaHistorico() {
		setResizable(false);
		setTitle(" MOVIMENTA\u00C7\u00C3O");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaHistorico.class.getResource("/br/com/protocolo/imagem/livro.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1306, 708);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro
				
				button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaHistorico.tfhistportador.setText("");												
						TelaHistorico.tfhistresp.setText("");
						TelaHistorico.tfhistlocalhist.setText("");
						TelaHistorico.tfhistportador.requestFocus();
					}
				});
				
				JButton button_1 = new JButton("");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						RelatorioHistorico rh = new RelatorioHistorico();
						rh.RelatorioHistorico();
					}
				});
				
				cbmovimentacaode = new JComboBox();
				cbmovimentacaode.setFont(new Font("Tahoma", Font.BOLD, 9));
				cbmovimentacaode.setBounds(150, 93, 264, 20);
				contentPane.add(cbmovimentacaode);
				
				cbmovimentacaopara = new JComboBox();
				cbmovimentacaopara.setFont(new Font("Tahoma", Font.BOLD, 9));
				cbmovimentacaopara.setBounds(419, 93, 275, 20);
				contentPane.add(cbmovimentacaopara);
				button_1.setToolTipText("Relat\u00F3rio Hist\u00F3rico de Movimenta\u00E7\u00E3o");
				button_1.setIcon(new ImageIcon(TelaHistorico.class.getResource("/br/com/protocolo/imagem/rell1.png")));
				button_1.setRolloverEnabled(false);
				button_1.setRequestFocusEnabled(false);
				button_1.setFocusable(false);
				button_1.setFocusTraversalKeysEnabled(false);
				button_1.setFocusPainted(false);
				button_1.setContentAreaFilled(false);
				button_1.setBorderPainted(false);
				button_1.setBounds(1244, 74, 52, 44);
				contentPane.add(button_1);
				button.setIcon(new ImageIcon(TelaHistorico.class.getResource("/br/com/protocolo/imagem/erroo.png")));
				button.setRolloverEnabled(false);
				button.setRequestFocusEnabled(false);
				button.setFocusable(false);
				button.setFocusTraversalKeysEnabled(false);
				button.setFocusPainted(false);
				button.setContentAreaFilled(false);
				button.setBorderPainted(false);
				button.setBounds(1187, 73, 52, 44);
				contentPane.add(button);
		
				JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
				lblDescrio.setForeground(Color.WHITE);
				lblDescrio.setBounds(369, 11, 71, 14);
				contentPane.add(lblDescrio);
				lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				tfhistmarca = new JTextField();
				tfhistmarca.setBackground(SystemColor.inactiveCaption);
				tfhistmarca.setBounds(648, 29, 150, 20);
				contentPane.add(tfhistmarca);
				tfhistmarca.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistmarca.setEditable(false);
				tfhistmarca.setColumns(10);
		
				tfhistdescricao = new JTextField();
				tfhistdescricao.setBackground(SystemColor.inactiveCaption);
				tfhistdescricao.setBounds(369, 29, 269, 20);
				contentPane.add(tfhistdescricao);
				tfhistdescricao.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistdescricao.setEditable(false);
				tfhistdescricao.setColumns(10);
		
				tfhistid = new JTextField();
				tfhistid.setBackground(SystemColor.inactiveCaption);
				tfhistid.setBounds(10, 29, 64, 20);
				contentPane.add(tfhistid);
				tfhistid.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistid.setEditable(false);
				tfhistid.setColumns(10);
		
				JLabel lblPatrimnio = new JLabel("Patrim\u00F4nio");
				lblPatrimnio.setForeground(Color.WHITE);
				lblPatrimnio.setBounds(182, 11, 81, 14);
				contentPane.add(lblPatrimnio);
				lblPatrimnio.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				tfhistvalor = new JTextField();
				tfhistvalor.setBackground(SystemColor.inactiveCaption);
				tfhistvalor.setBounds(1049, 29, 86, 20);
				contentPane.add(tfhistvalor);
				tfhistvalor.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistvalor.setEditable(false);
				tfhistvalor.setColumns(10);
		
				JLabel lblLocal = new JLabel("Local");
				lblLocal.setForeground(Color.WHITE);
				lblLocal.setBounds(1145, 11, 43, 14);
				contentPane.add(lblLocal);
				lblLocal.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				tfhistcategoria = new JTextField();
				tfhistcategoria.setBackground(SystemColor.inactiveCaption);
				tfhistcategoria.setBounds(83, 29, 86, 20);
				contentPane.add(tfhistcategoria);
				tfhistcategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistcategoria.setEditable(false);
				tfhistcategoria.setColumns(10);
		
				tfhistdata = new JTextField();
				tfhistdata.setBackground(SystemColor.inactiveCaption);
				tfhistdata.setBounds(953, 29, 86, 20);
				contentPane.add(tfhistdata);
				tfhistdata.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistdata.setEditable(false);
				tfhistdata.setColumns(10);
		
				JLabel lblCodgo = new JLabel("C\u00F3digo");
				lblCodgo.setForeground(Color.WHITE);
				lblCodgo.setBounds(273, 11, 52, 14);
				contentPane.add(lblCodgo);
				lblCodgo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				tfhistcod = new JTextField();
				tfhistcod.setBackground(SystemColor.inactiveCaption);
				tfhistcod.setBounds(273, 29, 86, 20);
				contentPane.add(tfhistcod);
				tfhistcod.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistcod.setEditable(false);
				tfhistcod.setColumns(10);
		
				JLabel lblCategoria = new JLabel("Grupo");
				lblCategoria.setForeground(Color.WHITE);
				lblCategoria.setBounds(83, 11, 71, 14);
				contentPane.add(lblCategoria);
				lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				JLabel lblModelo = new JLabel("Modelo");
				lblModelo.setForeground(Color.WHITE);
				lblModelo.setBounds(808, 11, 52, 14);
				contentPane.add(lblModelo);
				lblModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				JLabel lblMarca = new JLabel("Marca");
				lblMarca.setForeground(Color.WHITE);
				lblMarca.setBounds(648, 11, 48, 14);
				contentPane.add(lblMarca);
				lblMarca.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				JLabel lblValor = new JLabel("Valor");
				lblValor.setForeground(Color.WHITE);
				lblValor.setBounds(1049, 11, 43, 14);
				contentPane.add(lblValor);
				lblValor.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				tfhistlocal = new JTextField();
				tfhistlocal.setBackground(SystemColor.inactiveCaption);
				tfhistlocal.setBounds(1145, 29, 145, 20);
				contentPane.add(tfhistlocal);
				tfhistlocal.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistlocal.setEditable(false);
				tfhistlocal.setColumns(10);
		
				JLabel lblData = new JLabel("Data");
				lblData.setForeground(Color.WHITE);
				lblData.setBounds(953, 11, 36, 14);
				contentPane.add(lblData);
				lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				lblId = new JLabel("Id");
				lblId.setForeground(Color.WHITE);
				lblId.setBounds(10, 11, 52, 14);
				contentPane.add(lblId);
				lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				tfhistpatrimonio = new JTextField();
				tfhistpatrimonio.setBackground(SystemColor.inactiveCaption);
				tfhistpatrimonio.setBounds(177, 29, 86, 20);
				contentPane.add(tfhistpatrimonio);
				tfhistpatrimonio.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistpatrimonio.setEditable(false);
				tfhistpatrimonio.setColumns(10);
		
				tfhistmodelo = new JTextField();
				tfhistmodelo.setBackground(SystemColor.inactiveCaption);
				tfhistmodelo.setBounds(808, 29, 135, 20);
				contentPane.add(tfhistmodelo);
				tfhistmodelo.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistmodelo.setEditable(false);
				tfhistmodelo.setColumns(10);
				
				Date d = new Date();

				Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
														// colocar o codigo de cada país
														// e o mesmo assume o formato.

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", local);
		tfhistdatahist = new JTextField();
		tfhistdatahist.setBackground(SystemColor.inactiveCaption);
		tfhistdatahist.setBounds(699, 93, 86, 20);
		contentPane.add(tfhistdatahist);
		tfhistdatahist.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfhistdatahist.setColumns(10);
		tfhistdatahist.setText(sdf.format(d));
		
				lblMovimentao = new JLabel("MOVIMENTA\u00C7\u00C3O DE");
				lblMovimentao.setForeground(Color.WHITE);
				lblMovimentao.setBounds(150, 75, 129, 14);
				contentPane.add(lblMovimentao);
				lblMovimentao.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				tfhistresp = new JTextField();
				tfhistresp.setBackground(SystemColor.inactiveCaption);
				tfhistresp.setBounds(792, 93, 135, 20);
				contentPane.add(tfhistresp);
				tfhistresp.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistresp.setColumns(10);
				tfhistresp.setDocument(new UpperCaseDocument());
		
				JButton btnNewButton = new JButton("");
				btnNewButton.setBorderPainted(false);
				btnNewButton.setContentAreaFilled(false);
				btnNewButton.setFocusPainted(false);
				btnNewButton.setFocusTraversalKeysEnabled(false);
				btnNewButton.setFocusable(false);
				btnNewButton.setRequestFocusEnabled(false);
				btnNewButton.setRolloverEnabled(false);
				btnNewButton.setBounds(1141, 73, 52, 44);
				contentPane.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						if (tfhistportador.getText().equals("") 
								|| tfhistresp.getText().equals("")
								|| tfhistlocalhist.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
						} else {
							CadastrarHistoricoDao chd = new CadastrarHistoricoDao();
							chd.cadastrarhistorico(null);
							ListarHistoricoDao lhd = new ListarHistoricoDao();
							lhd.listar();
						}
					}
				});
				btnNewButton.setIcon(new ImageIcon(TelaHistorico.class.getResource("/br/com/protocolo/imagem/sucessoo.png")));
		
				lblMovimentaoPara = new JLabel("MOVIMENTA\u00C7\u00C3O PARA");
				lblMovimentaoPara.setForeground(Color.WHITE);
				lblMovimentaoPara.setBounds(424, 75, 169, 14);
				contentPane.add(lblMovimentaoPara);
				lblMovimentaoPara.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				tfhistportador = new JTextField();
				tfhistportador.setBackground(SystemColor.inactiveCaption);
				tfhistportador.setBounds(10, 93, 135, 20);
				contentPane.add(tfhistportador);
				tfhistportador.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistportador.setColumns(10);
				tfhistportador.setDocument(new UpperCaseDocument());
		
				lblContrato = new JLabel("CONTRATO");
				lblContrato.setForeground(Color.WHITE);
				lblContrato.setBounds(933, 75, 81, 14);
				contentPane.add(lblContrato);
				lblContrato.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				lblPortador = new JLabel("PORTADOR");
				lblPortador.setForeground(Color.WHITE);
				lblPortador.setBounds(11, 75, 71, 14);
				contentPane.add(lblPortador);
				lblPortador.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				tfhistlocalhist = new JTextField();
				tfhistlocalhist.setBackground(SystemColor.inactiveCaption);
				tfhistlocalhist.setBounds(933, 93, 204, 20);
				contentPane.add(tfhistlocalhist);
				tfhistlocalhist.setFont(new Font("Tahoma", Font.BOLD, 11));
				tfhistlocalhist.setColumns(10);
				tfhistlocalhist.setDocument(new UpperCaseDocument());
		
				lblResponsvel = new JLabel("RESPONS\u00C1VEL");
				lblResponsvel.setForeground(Color.WHITE);
				lblResponsvel.setBounds(792, 75, 86, 14);
				contentPane.add(lblResponsvel);
				lblResponsvel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				label_6 = new JLabel("DATA");
				label_6.setForeground(Color.WHITE);
				label_6.setBounds(699, 75, 36, 14);
				contentPane.add(label_6);
				label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 62, 1320, 4);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(0, 126, 1320, 5);
		contentPane.add(separator_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.info);
		scrollPane.setBounds(10, 142, 1280, 527);
		contentPane.add(scrollPane);

		tabelahistorico = new JTable();
		tabelahistorico.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabelahistorico.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"PORTADOR", "MOVIMENTA\u00C7\u00C3O DE ", "MOVIMENTA\u00C7\u00C3O PARA", "DATA", "RESPONS\u00C1VEL", "CONTRATO"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelahistorico.getColumnModel().getColumn(0).setResizable(false);
		tabelahistorico.getColumnModel().getColumn(0).setPreferredWidth(40);
		tabelahistorico.getColumnModel().getColumn(1).setResizable(false);
		tabelahistorico.getColumnModel().getColumn(1).setPreferredWidth(185);
		tabelahistorico.getColumnModel().getColumn(2).setResizable(false);
		tabelahistorico.getColumnModel().getColumn(2).setPreferredWidth(185);
		tabelahistorico.getColumnModel().getColumn(3).setResizable(false);
		tabelahistorico.getColumnModel().getColumn(3).setPreferredWidth(15);
		tabelahistorico.getColumnModel().getColumn(4).setResizable(false);
		tabelahistorico.getColumnModel().getColumn(4).setPreferredWidth(40);
		tabelahistorico.getColumnModel().getColumn(5).setResizable(false);
		tabelahistorico.getColumnModel().getColumn(5).setPreferredWidth(159);
		scrollPane.setViewportView(tabelahistorico);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaHistorico.class.getResource("/br/com/protocolo/imagem/fundo3.jpg")));
		lblNewLabel.setBounds(0, 0, 1300, 680);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null); // tela sempre no centro

		tabelahistorico.setDefaultRenderer(Object.class, new ColorirTabelaHistorico());
		tabelahistorico.getTableHeader().setReorderingAllowed(false);// manter menu da tabelafixo
		
		PovoarComboMovimentacaodeDao pcmdd = new PovoarComboMovimentacaodeDao();
		pcmdd.listar();
		
		PovoarComboMovimentacaoparaDao pcmdp = new PovoarComboMovimentacaoparaDao();
		pcmdp.listar();
		
	}
}
