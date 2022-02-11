package br.com.protocolo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import br.com.protocolo.controle.Produto;
import br.com.protocolo.model.ConnectionFactory;
import br.com.protocolo.view.Principal;

public class BuscarProdutoDao {

	private Connection connection;

	public BuscarProdutoDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Produto> dados = new ArrayList<Produto>();
		
		DefaultTableModel tab = (DefaultTableModel) Principal.tabelaproduto.getModel();

		String sql = "SELECT * FROM produto WHERE descricao LIKE '"+ Principal.tfprodutorelacao.getText() +"%' OR marca = '"+ Principal.tfprodutorelacao.getText() +"%' OR local = '"+ Principal.tfprodutorelacao.getText() +"%'order by id_produto";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Produto produto = new Produto();

				produto.setId_produto(rs.getInt("id_produto"));
				produto.setCategoria(rs.getString("categoria"));
				produto.setPatrimonio(rs.getString("patrimonio"));
				produto.setCod(rs.getString("cod"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setMarca(rs.getString("marca"));
				produto.setModelo(rs.getString("modelo"));
				produto.setAquisicao(rs.getString("data"));
				produto.setValor(rs.getDouble("valor"));
				produto.setLocal(rs.getString("local"));

				dados.add(produto);
			
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	
		for (; tab.getRowCount() > 0;)
			tab.removeRow(0);

		for (Produto temp : dados) {
			Object[] linha = { temp.getId_produto(), temp.getCategoria(), temp.getPatrimonio(), temp.getCod(),
					temp.getDescricao(), temp.getMarca(), temp.getModelo(), temp.getAquisicao(), temp.getValor(),
					temp.getLocal() };
			tab.addRow(linha);
		}
	}
}
