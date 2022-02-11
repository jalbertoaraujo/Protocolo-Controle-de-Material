package br.com.protocolo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.protocolo.model.ConnectionFactory;
import br.com.protocolo.view.CadastrarContrato;
import br.com.protocolo.view.CadastrarProduto;

public class CadastrarContratoDao {
	
	private Connection connection;

	public CadastrarContratoDao() {

		this.connection = new ConnectionFactory().getConnection();

	}

	public void cadastrarproduto(CadastrarProduto cadastraproduto){
		
		String sql = "SELECT * FROM contrato WHERE contrato = '"+ CadastrarContrato.tfcaddepartamento.getText() +"'";
		
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

				JOptionPane.showMessageDialog(null, "CONTRATO JÁ CADASTRADO");
				CadastrarContrato.tfcaddepartamento.setText("");
				CadastrarContrato.tfcaddepartamento.requestFocus();				
			}else{
				String sql1 = "INSERT INTO contrato (id_contrato,contrato) VALUES (?,?)";
				try {
					PreparedStatement ps = connection.prepareStatement(sql1);
					ps.setInt(1,Integer.parseInt(CadastrarContrato.tfidcadcontrato.getText()));	
					ps.setString(2,CadastrarContrato.tfcaddepartamento.getText());				
					ps.execute();
					ps.close();
					JOptionPane.showMessageDialog(null, "CONTRATO CADASTRADO COM SUCESSO");
					CadastrarContrato.tfcaddepartamento.setText("");
					CadastrarContrato.tfcaddepartamento.requestFocus();		
					
			
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