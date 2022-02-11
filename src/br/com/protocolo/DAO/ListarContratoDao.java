package br.com.protocolo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import br.com.protocolo.controle.Contrato;
import br.com.protocolo.controle.Produto;
import br.com.protocolo.model.ConnectionFactory;
import br.com.protocolo.view.CadastrarContrato;
import br.com.protocolo.view.Principal;

public class ListarContratoDao {

	private Connection connection;

	public ListarContratoDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Contrato> dados = new ArrayList<Contrato>();
		
		DefaultTableModel tab = (DefaultTableModel) CadastrarContrato.tabelacontrato.getModel();

		String sql = "SELECT * FROM contrato order by contrato asc";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Contrato contrato = new Contrato();

				contrato.setId_contrato(rs.getInt("id_contrato"));
				contrato.setContrato(rs.getString("contrato"));
			

				dados.add(contrato);
			
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	
		for (; tab.getRowCount() > 0;)
			tab.removeRow(0);

		for (Contrato temp : dados) {
			Object[] linha = { temp.getContrato()};
			tab.addRow(linha);
		}
	}
}
