package br.com.protocolo.controle;

public class Produto {
	
	private int	id_produto;
	private String categoria;
	private String patrimonio;
	private String cod;
	private String descricao;
	private String marca;
	private String modelo;
	private String aquisicao;
	private Double valor;
	private String local;	

	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAquisicao() {
		return aquisicao;
	}
	public void setAquisicao(String aquisicao) {
		this.aquisicao = aquisicao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	public Produto(int id_produto, String categoria, String patrimonio, String cod, String descricao, String marca,
			String modelo, String aquisicao, Double valor, String local) {
		super();
		this.id_produto = id_produto;
		this.categoria = categoria;
		this.patrimonio = patrimonio;
		this.cod = cod;
		this.descricao = descricao;
		this.marca = marca;
		this.modelo = modelo;
		this.aquisicao = aquisicao;
		this.valor = valor;
		this.local = local;
	}
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Produto [id_produto=" + id_produto + ", categoria=" + categoria + ", patrimonio=" + patrimonio
				+ ", cod=" + cod + ", descricao=" + descricao + ", marca=" + marca + ", modelo=" + modelo
				+ ", aquisicao=" + aquisicao + ", valor=" + valor + ", local=" + local + "]";
	}
}
