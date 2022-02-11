package br.com.protocolo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.protocolo.model.ConnectionFactory;
import br.com.protocolo.view.CadastrarContrato;

public class RetornaNumeroIdDao {
	
	private Connection connection;

	public RetornaNumeroIdDao(){
		
		this.connection = new ConnectionFactory().getConnection();

	}

	public void RetornaNumeroIdDao(){		
		
		String  sql = "select id_contrato from contrato order by id_contrato desc limit 1";
		
		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				
				int ult = rs.getInt("id_contrato") + 1;
				CadastrarContrato.tfidcadcontrato.setText("" + ult);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
