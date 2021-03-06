package br.com.protocolo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import br.com.protocolo.controle.Historico;
import br.com.protocolo.controle.Produto;
import br.com.protocolo.model.ConnectionFactory;
import br.com.protocolo.view.Escolha;
import br.com.protocolo.view.Principal;
import br.com.protocolo.view.TelaHistorico;

public class ListarUltimoHistoricoDao {

	private Connection connection;

	public ListarUltimoHistoricoDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Historico> dados = new ArrayList<Historico>();
		
		DefaultTableModel tab = (DefaultTableModel) Escolha.tabelainformacao.getModel();
		
		int ind = Principal.tabelaproduto.getSelectedRow();

		String sql = "SELECT *  FROM historico WHERE id_produto = '"+ (Principal.tabelaproduto.getValueAt(ind, 0).toString()) +"'order by id_historico desc limit 1";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao est? tratando da conex?o com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Historico historico = new Historico();

				historico.setId_historico(rs.getInt("id_historico"));
				historico.setId_produto(rs.getInt("id_produto"));
				historico.setPortador(rs.getString("portador"));
				historico.setMovimentacaode(rs.getString("movimentacaode"));
				historico.setMovimentacaopara(rs.getString("movimentacaopara"));
				historico.setData(rs.getString("data"));
				historico.setResponsavel(rs.getString("responsavel"));
				historico.setLocal(rs.getString("local"));				

				dados.add(historico);
			
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	
		for (; tab.getRowCount() > 0;)
			tab.removeRow(0);

		for (Historico temp : dados) {
			Object[] linha = { temp.getData(), temp.getLocal() };
			tab.addRow(linha);
		}
	}
}
