package br.com.protocolo.controle;

public class Contrato {
	
	 private Integer id_contrato;
	 private String contrato;
	 
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	
	public Contrato() {
		super();
		this.id_contrato = id_contrato;
		this.contrato = contrato;
	}
	
	@Override
	public String toString() {
		return "Contrato [id_contrato=" + id_contrato + ", contrato=" + contrato + "]";
	}
}
