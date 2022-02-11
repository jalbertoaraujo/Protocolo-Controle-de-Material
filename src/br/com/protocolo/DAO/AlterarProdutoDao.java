package br.com.protocolo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.protocolo.controle.Produto;
import br.com.protocolo.model.ConnectionFactory;
import br.com.protocolo.view.AlterarProduto;

public class AlterarProdutoDao {

	private Connection connection;

	public AlterarProdutoDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void AlterarProdutoDao() {

		List<Produto> dados = new ArrayList<Produto>();

		String sql = "UPDATE produto SET categoria = '" + AlterarProduto.tfcadcategoriaalt.getText()
				+ "', patrimonio = '" + AlterarProduto.tfcadpatrimonioalt.getText() + "', cod = '"
				+ AlterarProduto.tfcadcodalt.getText() + "', descricao = '" + AlterarProduto.tfcaddescalt.getText()
				+ "', marca = '" + AlterarProduto.tfcadmarcaalt.getText() + "', modelo = '"
				+ AlterarProduto.tfcadmodeloalt.getText() + "', valor = '" + AlterarProduto.tfcadvaloralt.getText()
				+ "', local = '" + AlterarProduto.tfcadlocalalt.getText() + "' WHERE id_produto = '"+ AlterarProduto.tfidprodutoalt.getText() +"'";
		
		try {
			PreparedStatement prep = connection.prepareStatement(sql);// esse retorna Conexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

		} catch (SQLException e) {
			
			AlterarProduto.tfcadcategoriaalt.setText("");
			AlterarProduto.tfcadpatrimonioalt.setText(""); 
			AlterarProduto.tfcadcodalt.setText("");
			AlterarProduto.tfcaddescalt.setText("");
			AlterarProduto.tfcadmarcaalt.setText("");
			AlterarProduto.tfcadmodeloalt.setText("");
			AlterarProduto.tfcadvaloralt.setText("");
			AlterarProduto.tfcadlocalalt.setText("");
			AlterarProduto.tfcadcategoriaalt.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}