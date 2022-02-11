package br.com.protocolo.uteis;

import br.com.protocolo.DAO.ListarHistoricoDao;
import br.com.protocolo.DAO.ListarProdutoDao;
import br.com.protocolo.view.AlterarProduto;
import br.com.protocolo.view.Principal;
import br.com.protocolo.view.TelaHistorico;

public class AbreTelaAlterarProduto {
	
	public void AbreTelaHistorico(){
	
	AlterarProduto ap = new AlterarProduto();
	ap.setVisible(true);
	
	int ind = Principal.tabelaproduto.getSelectedRow();
	
	ap.tfidprodutoalt.setText(Principal.tabelaproduto.getValueAt(ind, 0).toString());
	ap.tfcadcategoriaalt.setText(Principal.tabelaproduto.getValueAt(ind, 1).toString());
	ap.tfcadpatrimonioalt.setText(Principal.tabelaproduto.getValueAt(ind, 2).toString());
	ap.tfcadcodalt.setText(Principal.tabelaproduto.getValueAt(ind, 3).toString());
	ap.tfcaddescalt.setText(Principal.tabelaproduto.getValueAt(ind, 4).toString());
	ap.tfcadmarcaalt.setText(Principal.tabelaproduto.getValueAt(ind, 5).toString());
	ap.tfcadmodeloalt.setText(Principal.tabelaproduto.getValueAt(ind, 6).toString());	
	ap.tfcadvaloralt.setText(Principal.tabelaproduto.getValueAt(ind, 8).toString());
	ap.tfcadlocalalt.setText(Principal.tabelaproduto.getValueAt(ind, 9).toString());
	
	ListarProdutoDao lpd = new ListarProdutoDao();
	lpd.listar();
	}
}
