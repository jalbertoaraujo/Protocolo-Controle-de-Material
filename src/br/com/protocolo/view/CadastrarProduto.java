package br.com.protocolo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;

import br.com.protocolo.DAO.CadastrarProdutoDao;
import br.com.protocolo.DAO.ListarProdutoDao;
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

public class CadastrarProduto extends JFrame {

	private JPanel contentPane;
	public static JTextField tfcaddata;
	public static JTextField tfcadmarca;
	public static JTextField tfcaddesc;
	public static JTextField tfcadcategoria;
	public static JTextField tfcadpatrimonio;
	public static JTextField tfcadcod;
	public static JTextField tfcadmodelo;
	public static JTextField tfcadlocal;
	public static JTextField tfcadvalor;

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
					CadastrarProduto frame = new CadastrarProduto();
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
	public CadastrarProduto() {
		setTitle(" CADASTRAR NOVO PRODUTO");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CadastrarProduto.class.getResource("/br/com/protocolo/imagem/livro.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 289);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(CadastrarProduto.class.getResource("/br/com/protocolo/imagem/erroo.png")));
		button_1.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				
				tfcadcategoria.setText("");
				tfcadpatrimonio.setText(""); // FEITO POR RAFAEL
				tfcadcod.setText("");
				tfcaddesc.setText("");
				tfcadmarca.setText("");
				tfcadmodelo.setText("");
				tfcadvalor.setText("");
				tfcadlocal.setText("");
				tfcadcategoria.requestFocus();
			}
		});
		button_1.setToolTipText("LIMPAR CAMPOS");
		button_1.setOpaque(false);
		button_1.setFocusable(false);
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBounds(285, 211, 43, 46);
		contentPane.add(button_1);

		tfcadmodelo = new JTextField();
		tfcadmodelo.setBackground(SystemColor.inactiveCaption);
		tfcadmodelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadmodelo.setColumns(10);
		tfcadmodelo.setDocument(new UpperCaseDocument());
		tfcadmodelo.setBounds(231, 128, 135, 20);
		contentPane.add(tfcadmodelo);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(new Color(255, 255, 255));
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModelo.setBounds(232, 110, 52, 14);
		contentPane.add(lblModelo);

		tfcadvalor = new JTextField();
		tfcadvalor.setBackground(SystemColor.inactiveCaption);
		tfcadvalor.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadvalor.setColumns(10);
		tfcadvalor.setDocument(new UpperCaseDocument());
		tfcadvalor.setBounds(118, 186, 86, 20);
		contentPane.add(tfcadvalor);

		tfcadcod = new JTextField();
		tfcadcod.setBackground(SystemColor.inactiveCaption);
		tfcadcod.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadcod.setColumns(10);
		tfcadcod.setDocument(new UpperCaseDocument());
		tfcadcod.setBounds(258, 29, 108, 20);
		contentPane.add(tfcadcod);

		JLabel lblPatrimnio = new JLabel("Patrim\u00F4nio");
		lblPatrimnio.setForeground(new Color(255, 255, 255));
		lblPatrimnio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPatrimnio.setBounds(136, 11, 81, 14);
		contentPane.add(lblPatrimnio);

		tfcadpatrimonio = new JTextField();
		tfcadpatrimonio.setBackground(SystemColor.inactiveCaption);
		tfcadpatrimonio.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadpatrimonio.setColumns(10);
		tfcadpatrimonio.setDocument(new UpperCaseDocument());
		tfcadpatrimonio.setBounds(136, 29, 108, 20);
		contentPane.add(tfcadpatrimonio);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setForeground(new Color(255, 255, 255));
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValor.setBounds(119, 168, 43, 14);
		contentPane.add(lblValor);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(CadastrarProduto.class.getResource("/br/com/protocolo/imagem/sucessoo.png")));
		button.setToolTipText("CADASTRAR NOVO PRODUTO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfcadcategoria.getText().equals("") || tfcadpatrimonio.getText().equals("")
						|| tfcadcod.getText().equals("") || tfcaddesc.getText().equals("")
						|| tfcadmarca.getText().equals("") || tfcadmodelo.getText().equals("")
						|| tfcadvalor.getText().equals("") || tfcadlocal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
				} else {
					CadastrarProdutoDao cpd = new CadastrarProdutoDao();
					cpd.cadastrarproduto(null);
					ListarProdutoDao lpd = new ListarProdutoDao();
					lpd.listar();
				}
			}
		});
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
		button.setBounds(329, 211, 43, 46);
		contentPane.add(button);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(new Color(255, 255, 255));
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigo.setBounds(258, 11, 52, 14);
		contentPane.add(lblCdigo);

		JLabel lblLocal = new JLabel("Local");
		lblLocal.setForeground(new Color(255, 255, 255));
		lblLocal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLocal.setBounds(224, 168, 43, 14);
		contentPane.add(lblLocal);

		tfcadlocal = new JTextField();
		tfcadlocal.setBackground(SystemColor.inactiveCaption);
		tfcadlocal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadlocal.setColumns(10);
		tfcadlocal.setDocument(new UpperCaseDocument());
		tfcadlocal.setBounds(222, 186, 145, 20);
		contentPane.add(tfcadlocal);

		Date d = new Date();

		Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", local);
		tfcaddata = new JTextField();
		tfcaddata.setBackground(SystemColor.inactiveCaption);
		tfcaddata.setBounds(14, 186, 86, 20);
		contentPane.add(tfcaddata);
		tfcaddata.setEditable(false);
		tfcaddata.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcaddata.setColumns(10);
		tfcaddata.setDocument(new UpperCaseDocument());
		tfcaddata.setText(sdf.format(d));

		JLabel lblData = new JLabel("Data");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setBounds(14, 168, 36, 14);
		contentPane.add(lblData);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));

		tfcadmarca = new JTextField();
		tfcadmarca.setBackground(SystemColor.inactiveCaption);
		tfcadmarca.setBounds(14, 128, 192, 20);
		contentPane.add(tfcadmarca);
		tfcadmarca.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadmarca.setColumns(10);
		tfcadmarca.setDocument(new UpperCaseDocument());

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(new Color(255, 255, 255));
		lblMarca.setBounds(16, 110, 48, 14);
		contentPane.add(lblMarca);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 11));

		tfcaddesc = new JTextField();
		tfcaddesc.setBackground(SystemColor.inactiveCaption);
		tfcaddesc.setBounds(14, 79, 352, 20);
		contentPane.add(tfcaddesc);
		tfcaddesc.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcaddesc.setColumns(10);
		tfcaddesc.setDocument(new UpperCaseDocument());

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setForeground(new Color(255, 255, 255));
		lblDescrio.setBounds(16, 61, 71, 14);
		contentPane.add(lblDescrio);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));

		tfcadcategoria = new JTextField();
		tfcadcategoria.setBackground(SystemColor.inactiveCaption);
		tfcadcategoria.setBounds(14, 29, 108, 20);
		contentPane.add(tfcadcategoria);
		tfcadcategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadcategoria.setColumns(10);
		tfcadcategoria.setDocument(new UpperCaseDocument());

		JLabel lblCategoria = new JLabel("Grupo");
		lblCategoria.setForeground(new Color(255, 255, 255));
		lblCategoria.setBounds(16, 11, 71, 14);
		contentPane.add(lblCategoria);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastrarProduto.class.getResource("/br/com/protocolo/imagem/fundo.png")));
		lblNewLabel.setBounds(0, 0, 381, 261);
		contentPane.add(lblNewLabel);
	}
}
