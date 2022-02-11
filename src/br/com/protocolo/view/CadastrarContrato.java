package br.com.protocolo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;

import br.com.protocolo.DAO.AlterarProdutoDao;
import br.com.protocolo.DAO.CadastrarContratoDao;
import br.com.protocolo.DAO.CadastrarProdutoDao;
import br.com.protocolo.DAO.ListarContratoDao;
import br.com.protocolo.DAO.ListarProdutoDao;
import br.com.protocolo.DAO.RetornaNumeroIdDao;
import br.com.protocolo.uteis.UpperCaseDocument;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CadastrarContrato extends JFrame {

	private JPanel contentPane;
	public static JTextField tfcaddepartamento;
	public static JTextField tfidcadcontrato;
	public static JTable tabelacontrato;

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
					CadastrarContrato frame = new CadastrarContrato();
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
	public CadastrarContrato() {
		setTitle(" CADASTRAR NOVO DEPARTAMENTO");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CadastrarContrato.class.getResource("/br/com/protocolo/imagem/livro.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 422, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(CadastrarContrato.class.getResource("/br/com/protocolo/imagem/erroo.png")));
		button_1.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				
				tfcaddepartamento.setText("");		
				tfcaddepartamento.requestFocus();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 99, 404, 291);
		contentPane.add(scrollPane);
		
		tabelacontrato = new JTable();
		tabelacontrato.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabelacontrato.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"DEPARTAMENTOS"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tabelacontrato);
		
		tfidcadcontrato = new JTextField();
		tfidcadcontrato.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfidcadcontrato.setEditable(false);
		tfidcadcontrato.setBackground(SystemColor.inactiveCaption);
		tfidcadcontrato.setBounds(5, 24, 86, 20);
		contentPane.add(tfidcadcontrato);
		tfidcadcontrato.setColumns(10);
		
		JLabel lblIdProduto = new JLabel("Id. Dep\u00E1rtamento");
		lblIdProduto.setForeground(Color.WHITE);
		lblIdProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdProduto.setBounds(5, 5, 112, 14);
		contentPane.add(lblIdProduto);
		button_1.setToolTipText("LIMPAR CAMPOS");
		button_1.setOpaque(false);
		button_1.setFocusable(false);
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBounds(319, 11, 43, 46);
		contentPane.add(button_1);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(CadastrarContrato.class.getResource("/br/com/protocolo/imagem/sucessoo.png")));
		button.setToolTipText("ALTERAR PRODUTO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfcaddepartamento.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
				} else {
					CadastrarContratoDao ccd = new CadastrarContratoDao();
					ccd.cadastrarproduto(null);
					ListarContratoDao lcd = new ListarContratoDao();
					lcd.listar();
				}
			}
		});
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
		button.setBounds(363, 11, 43, 46);
		contentPane.add(button);

		Date d = new Date();

		Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", local);

		tfcaddepartamento = new JTextField();
		tfcaddepartamento.setBackground(SystemColor.inactiveCaption);
		tfcaddepartamento.setBounds(5, 68, 404, 20);
		contentPane.add(tfcaddepartamento);
		tfcaddepartamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcaddepartamento.setColumns(10);
		tfcaddepartamento.setDocument(new UpperCaseDocument());
		
		JLabel lblCategoria = new JLabel("Novo Departamento");
		lblCategoria.setForeground(new Color(255, 255, 255));
		lblCategoria.setBounds(5, 49, 137, 14);
		contentPane.add(lblCategoria);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastrarContrato.class.getResource("/br/com/protocolo/imagem/fundo.png")));
		lblNewLabel.setBounds(0, 0, 416, 400);
		contentPane.add(lblNewLabel);
		
		tabelacontrato.getTableHeader().setReorderingAllowed(false);// manter menu da tabelafixo
		
		ListarContratoDao lcd = new ListarContratoDao();
		lcd.listar();
		
		RetornaNumeroIdDao rnd = new RetornaNumeroIdDao();
		rnd.RetornaNumeroIdDao();
	}
}
