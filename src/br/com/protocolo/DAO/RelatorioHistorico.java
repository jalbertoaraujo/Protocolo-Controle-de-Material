package br.com.protocolo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.protocolo.controle.Historico;
import br.com.protocolo.controle.Produto;
import br.com.protocolo.model.ConnectionFactory;
import br.com.protocolo.view.TelaHistorico;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;



public class RelatorioHistorico {
	
	private Connection connection;
	
	public RelatorioHistorico() {
		
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void  RelatorioHistorico(){
		
		List<Historico> dados = new ArrayList<Historico>();	
		
		String sql = "SELECT * FROM historico WHERE descricao = '"+ TelaHistorico.tfhistdescricao.getText() +"' order by id_historico";
		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();
			
			JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
			JasperPrint jp = JasperFillManager.fillReport("RelAtivos/RelatorioMovimentacao.jasper", new HashMap(), jrrs);
			JasperViewer.viewReport(jp,false);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}