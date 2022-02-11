package br.com.protocolo.uteis;

import br.com.protocolo.DAO.ListarHistoricoDao;
import br.com.protocolo.view.Principal;
import br.com.protocolo.view.TelaHistorico;

public class AbreTelaHistorico {
	
	public void AbreTelaHistorico(){
	
	TelaHistorico th = new TelaHistorico();
	th.setVisible(true);
	
	int ind = Principal.tabelaproduto.getSelectedRow();
	
	th.tfhistid.setText(Principal.tabelaproduto.getValueAt(ind, 0).toString());
	th.tfhistcategoria.setText(Principal.tabelaproduto.getValueAt(ind, 1).toString());
	th.tfhistpatrimonio.setText(Principal.tabelaproduto.getValueAt(ind, 2).toString());
	th.tfhistcod.setText(Principal.tabelaproduto.getValueAt(ind, 3).toString());
	th.tfhistdescricao.setText(Principal.tabelaproduto.getValueAt(ind, 4).toString());
	th.tfhistmarca.setText(Principal.tabelaproduto.getValueAt(ind, 5).toString());
	th.tfhistmodelo.setText(Principal.tabelaproduto.getValueAt(ind, 6).toString());
	th.tfhistdata.setText(Principal.tabelaproduto.getValueAt(ind, 7).toString());
	th.tfhistvalor.setText(Principal.tabelaproduto.getValueAt(ind, 8).toString());
	th.tfhistlocal.setText(Principal.tabelaproduto.getValueAt(ind, 9).toString());
	
	ListarHistoricoDao lhd = new ListarHistoricoDao();
	lhd.listar();
	}
}
