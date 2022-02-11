package br.com.protocolo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.protocolo.model.ConnectionFactory;
import br.com.protocolo.view.TelaHistorico;

public class CadastrarHistoricoDao {

	private Connection connection;

	public CadastrarHistoricoDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void cadastrarhistorico(TelaHistorico telahistorico) {

		String sql = "INSERT INTO historico (id_produto,portador,movimentacaode,movimentacaopara,data,responsavel,local,descricao,patrimonio) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(TelaHistorico.tfhistid.getText()));
			ps.setString(2, TelaHistorico.tfhistportador.getText());
			ps.setString(3, TelaHistorico.cbmovimentacaode.getSelectedItem().toString());
			ps.setString(4, TelaHistorico.cbmovimentacaopara.getSelectedItem().toString());
			ps.setString(5, TelaHistorico.tfhistdatahist.getText());
			ps.setString(6, TelaHistorico.tfhistresp.getText());
			ps.setString(7, TelaHistorico.tfhistlocalhist.getText());
			ps.setString(8, TelaHistorico.tfhistdescricao.getText());
			ps.setString(9, TelaHistorico.tfhistpatrimonio.getText());
			ps.execute();
			ps.close();
			JOptionPane.showMessageDialog(null, "MOVIMENTAÇÂO CADASTRADA COM SUCESSO");
			TelaHistorico.tfhistportador.setText("");		
			TelaHistorico.tfhistdatahist.setText("");
			TelaHistorico.tfhistresp.setText("");
			TelaHistorico.tfhistlocalhist.setText("");
			TelaHistorico.tfhistportador.requestFocus();
		} catch (SQLException erro) {
			throw new RuntimeException(erro);
		}
	}
}
