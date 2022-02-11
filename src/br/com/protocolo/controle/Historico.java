package br.com.protocolo.controle;

public class Historico {
	
	private int id_historico;
	private int id_produto;
	private String portador;
	private String movimentacaode;
	private String movimentacaopara;
	private String data;
	private String responsavel;
	private String local;	
	
	public int getId_historico() {
		return id_historico;
	}

	public void setId_historico(int id_historico) {
		this.id_historico = id_historico;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getPortador() {
		return portador;
	}

	public void setPortador(String portador) {
		this.portador = portador;
	}

	public String getMovimentacaode() {
		return movimentacaode;
	}

	public void setMovimentacaode(String movimentacaode) {
		this.movimentacaode = movimentacaode;
	}

	public String getMovimentacaopara() {
		return movimentacaopara;
	}

	public void setMovimentacaopara(String movimentacaopara) {
		this.movimentacaopara = movimentacaopara;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Historico(int id_historico, int id_produto, String portador, String movimentacaode, String movimentacaopara,
			String data, String responsavel, String local) {
		super();
		this.id_historico = id_historico;
		this.id_produto = id_produto;
		this.portador = portador;
		this.movimentacaode = movimentacaode;
		this.movimentacaopara = movimentacaopara;
		this.data = data;
		this.responsavel = responsavel;
		this.local = local;
	}

	public Historico() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Historico [id_historico=" + id_historico + ", id_produto=" + id_produto + ", portador=" + portador
				+ ", movimentacaode=" + movimentacaode + ", movimentacaopara=" + movimentacaopara + ", data=" + data
				+ ", responsavel=" + responsavel + ", local=" + local + "]";
	}	
}
