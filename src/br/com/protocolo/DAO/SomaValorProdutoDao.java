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

public class SomaValorProdutoDao {

	private Connection connection;

	public SomaValorProdutoDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Produto> dados = new ArrayList<Produto>();
		
		DefaultTableModel tab = (DefaultTableModel) Principal.tabelaproduto.getModel();

		String sql = "SELECT SUM (valor) as total FROM produto";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Principal.tfvalorativos.setText(rs.getString("total"));
			
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
}
