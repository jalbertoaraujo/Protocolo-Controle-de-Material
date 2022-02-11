package br.com.protocolo.controle;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.protocolo.model.ConnectionFactory;

public class Teste {

	public static void main(String[] args) {

		Connection connection = new ConnectionFactory().getConnection();
		JOptionPane.showMessageDialog(null, "Conexão estabelecida com Sucesso");

	}

}
