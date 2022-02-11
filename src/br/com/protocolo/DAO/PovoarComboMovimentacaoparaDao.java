package br.com.protocolo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.protocolo.controle.Contrato;
import br.com.protocolo.model.ConnectionFactory;
import br.com.protocolo.view.TelaHistorico;



public class PovoarComboMovimentacaoparaDao {
	
	private Connection connection;
	
	public PovoarComboMovimentacaoparaDao(){
		
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void listar() {
		
		List<Contrato> dados = new ArrayList<Contrato>();
		
		String sql = "SELECT contrato FROM contrato ORDER BY id_contrato";
		
		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				
				TelaHistorico.cbmovimentacaopara.addItem(rs.getString("contrato"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
