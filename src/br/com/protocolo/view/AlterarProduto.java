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

public class AlterarProduto extends JFrame {

	private JPanel contentPane;
	public static JTextField tfcadmarcaalt;
	public static JTextField tfcaddescalt;
	public static JTextField tfcadcategoriaalt;
	public static JTextField tfcadpatrimonioalt;
	public static JTextField tfcadcodalt;
	public static JTextField tfcadmodeloalt;
	public static JTextField tfcadlocalalt;
	public static JTextField tfcadvaloralt;
	public static JTextField tfidprodutoalt;

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
					AlterarProduto frame = new AlterarProduto();
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
	public AlterarProduto() {
		setTitle(" ALTERAR PRODUTO");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AlterarProduto.class.getResource("/br/com/protocolo/imagem/livro.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(AlterarProduto.class.getResource("/br/com/protocolo/imagem/erroo.png")));
		button_1.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				
				tfcadcategoriaalt.setText("");
				tfcadpatrimonioalt.setText(""); // FEITO POR RAFAEL
				tfcadcodalt.setText("");
				tfcaddescalt.setText("");
				tfcadmarcaalt.setText("");
				tfcadmodeloalt.setText("");
				tfcadvaloralt.setText("");
				tfcadlocalalt.setText("");
				tfcadcategoriaalt.requestFocus();
			}
		});
		
		JLabel lblEx = new JLabel("Ex: 1000.00");
		lblEx.setForeground(Color.WHITE);
		lblEx.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEx.setBounds(298, 335, 71, 14);
		contentPane.add(lblEx);
		
		tfidprodutoalt = new JTextField();
		tfidprodutoalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfidprodutoalt.setEditable(false);
		tfidprodutoalt.setBackground(SystemColor.inactiveCaption);
		tfidprodutoalt.setBounds(5, 24, 86, 20);
		contentPane.add(tfidprodutoalt);
		tfidprodutoalt.setColumns(10);
		
		JLabel lblIdProduto = new JLabel("Id. Produto");
		lblIdProduto.setForeground(Color.WHITE);
		lblIdProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdProduto.setBounds(5, 5, 71, 14);
		contentPane.add(lblIdProduto);
		button_1.setToolTipText("LIMPAR CAMPOS");
		button_1.setOpaque(false);
		button_1.setFocusable(false);
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBounds(287, 10, 43, 46);
		contentPane.add(button_1);

		tfcadmodeloalt = new JTextField();
		tfcadmodeloalt.setBackground(SystemColor.inactiveCaption);
		tfcadmodeloalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadmodeloalt.setColumns(10);
		tfcadmodeloalt.setDocument(new UpperCaseDocument());
		tfcadmodeloalt.setBounds(5, 288, 364, 20);
		contentPane.add(tfcadmodeloalt);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(new Color(255, 255, 255));
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModelo.setBounds(5, 269, 52, 14);
		contentPane.add(lblModelo);

		tfcadvaloralt = new JTextField();
		tfcadvaloralt.setBackground(SystemColor.inactiveCaption);
		tfcadvaloralt.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadvaloralt.setColumns(10);
		tfcadvaloralt.setDocument(new UpperCaseDocument());
		tfcadvaloralt.setBounds(5, 332, 283, 20);
		contentPane.add(tfcadvaloralt);

		tfcadcodalt = new JTextField();
		tfcadcodalt.setBackground(SystemColor.inactiveCaption);
		tfcadcodalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadcodalt.setColumns(10);
		tfcadcodalt.setDocument(new UpperCaseDocument());
		tfcadcodalt.setBounds(5, 156, 364, 20);
		contentPane.add(tfcadcodalt);

		JLabel lblPatrimnio = new JLabel("Patrim\u00F4nio");
		lblPatrimnio.setForeground(new Color(255, 255, 255));
		lblPatrimnio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPatrimnio.setBounds(5, 93, 81, 14);
		contentPane.add(lblPatrimnio);

		tfcadpatrimonioalt = new JTextField();
		tfcadpatrimonioalt.setBackground(SystemColor.inactiveCaption);
		tfcadpatrimonioalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadpatrimonioalt.setColumns(10);
		tfcadpatrimonioalt.setDocument(new UpperCaseDocument());
		tfcadpatrimonioalt.setBounds(5, 112, 364, 20);
		contentPane.add(tfcadpatrimonioalt);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setForeground(new Color(255, 255, 255));
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValor.setBounds(5, 313, 43, 14);
		contentPane.add(lblValor);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(AlterarProduto.class.getResource("/br/com/protocolo/imagem/sucessoo.png")));
		button.setToolTipText("ALTERAR PRODUTO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfcadcategoriaalt.getText().equals("") || tfcadpatrimonioalt.getText().equals("")
						|| tfcadcodalt.getText().equals("") || tfcaddescalt.getText().equals("")
						|| tfcadmarcaalt.getText().equals("") || tfcadmodeloalt.getText().equals("")
						|| tfcadvaloralt.getText().equals("") || tfcadlocalalt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
				} else {
					AlterarProdutoDao apd = new AlterarProdutoDao();
					apd.AlterarProdutoDao();
					ListarProdutoDao lpd = new ListarProdutoDao();
					lpd.listar();
				}
			}
		});
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
		button.setBounds(331, 10, 43, 46);
		contentPane.add(button);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(new Color(255, 255, 255));
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigo.setBounds(5, 137, 52, 14);
		contentPane.add(lblCdigo);

		JLabel lblLocal = new JLabel("Local");
		lblLocal.setForeground(new Color(255, 255, 255));
		lblLocal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLocal.setBounds(5, 357, 43, 14);
		contentPane.add(lblLocal);

		tfcadlocalalt = new JTextField();
		tfcadlocalalt.setBackground(SystemColor.inactiveCaption);
		tfcadlocalalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadlocalalt.setColumns(10);
		tfcadlocalalt.setDocument(new UpperCaseDocument());
		tfcadlocalalt.setBounds(5, 376, 364, 20);
		contentPane.add(tfcadlocalalt);

		Date d = new Date();

		Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", local);

		tfcadmarcaalt = new JTextField();
		tfcadmarcaalt.setBackground(SystemColor.inactiveCaption);
		tfcadmarcaalt.setBounds(5, 244, 364, 20);
		contentPane.add(tfcadmarcaalt);
		tfcadmarcaalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadmarcaalt.setColumns(10);
		tfcadmarcaalt.setDocument(new UpperCaseDocument());

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(new Color(255, 255, 255));
		lblMarca.setBounds(5, 225, 48, 14);
		contentPane.add(lblMarca);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 11));

		tfcaddescalt = new JTextField();
		tfcaddescalt.setBackground(SystemColor.inactiveCaption);
		tfcaddescalt.setBounds(5, 200, 364, 20);
		contentPane.add(tfcaddescalt);
		tfcaddescalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcaddescalt.setColumns(10);
		tfcaddescalt.setDocument(new UpperCaseDocument());

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setForeground(new Color(255, 255, 255));
		lblDescrio.setBounds(5, 181, 71, 14);
		contentPane.add(lblDescrio);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));

		tfcadcategoriaalt = new JTextField();
		tfcadcategoriaalt.setBackground(SystemColor.inactiveCaption);
		tfcadcategoriaalt.setBounds(5, 68, 364, 20);
		contentPane.add(tfcadcategoriaalt);
		tfcadcategoriaalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcadcategoriaalt.setColumns(10);
		tfcadcategoriaalt.setDocument(new UpperCaseDocument());

		JLabel lblCategoria = new JLabel("Grupo");
		lblCategoria.setForeground(new Color(255, 255, 255));
		lblCategoria.setBounds(5, 49, 71, 14);
		contentPane.add(lblCategoria);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AlterarProduto.class.getResource("/br/com/protocolo/imagem/fundo.png")));
		lblNewLabel.setBounds(0, 0, 375, 400);
		contentPane.add(lblNewLabel);
	}
}
