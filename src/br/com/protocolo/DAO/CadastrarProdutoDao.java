package br.com.protocolo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.protocolo.model.ConnectionFactory;
import br.com.protocolo.view.CadastrarProduto;

public class CadastrarProdutoDao {
	
	private Connection connection;

	public CadastrarProdutoDao() {

		this.connection = new ConnectionFactory().getConnection();

	}

	public void cadastrarproduto(CadastrarProduto cadastraproduto){
		
		String sql = "SELECT * FROM produto WHERE patrimonio = '"+ CadastrarProduto.tfcadpatrimonio.getText() +"'";
		
		try {
			PreparedStatement prep = connection.prepareStatement(sql);// esse
																		// retornaConexao
																		// está
																		// tratando
																		// da
																		// conexão
																		// com o
																		// bd.
			ResultSet rs = prep.executeQuery();

			if (rs.next()) {

				JOptionPane.showMessageDialog(null, "PRODUTO JÁ CADASTRADO COM ESTE PATRIMÔNIO");
				CadastrarProduto.tfcadcategoria.setText("");
				CadastrarProduto.tfcadpatrimonio.setText("");
				CadastrarProduto.tfcadcod.setText("");
				CadastrarProduto.tfcaddesc.setText("");
				CadastrarProduto.tfcadmarca.setText("");
				CadastrarProduto.tfcadmodelo.setText("");
				CadastrarProduto.tfcadvalor.setText("");
				CadastrarProduto.tfcadlocal.setText("");
				CadastrarProduto.tfcadcategoria.requestFocus();				
			}else{
				String sql1 = "INSERT INTO produto (categoria,patrimonio,cod,descricao,marca,modelo,data,valor,local) VALUES (?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement ps = connection.prepareStatement(sql1);
					ps.setString(1,CadastrarProduto.tfcadcategoria.getText());
					ps.setString(2,CadastrarProduto.tfcadpatrimonio.getText());
					ps.setString(3,CadastrarProduto.tfcadcod.getText());
					ps.setString(4,CadastrarProduto.tfcaddesc.getText());
					ps.setString(5,CadastrarProduto.tfcadmarca.getText());
					ps.setString(6,CadastrarProduto.tfcadmodelo.getText());
					ps.setString(7,CadastrarProduto.tfcaddata.getText());
					ps.setDouble(8,Double.parseDouble(CadastrarProduto.tfcadvalor.getText()));
					ps.setString(9,CadastrarProduto.tfcadlocal.getText());
					ps.execute();
					ps.close();
					JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO");
					CadastrarProduto.tfcadcategoria.setText("");
					CadastrarProduto.tfcadpatrimonio.setText("");
					CadastrarProduto.tfcadcod.setText("");
					CadastrarProduto.tfcaddesc.setText("");
					CadastrarProduto.tfcadmarca.setText("");
					CadastrarProduto.tfcadmodelo.setText("");
					CadastrarProduto.tfcadvalor.setText("");
					CadastrarProduto.tfcadlocal.setText("");
					CadastrarProduto.tfcadcategoria.requestFocus();	
					
			
			} catch (SQLException erro) {
				throw new RuntimeException(erro);
			}
		}
	} catch (SQLException e) {
		throw new RuntimeException(e);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}