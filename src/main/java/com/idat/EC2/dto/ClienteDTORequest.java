package com.idat.EC2.dto;

public class ClienteDTORequest {
	private Integer idComprador;
	private String nombreComprador;
	private String direccionComprador;
	private String documentoComprador;
	public Integer getIdComprador() {
		return idComprador;
	}
	public void setIdComprador(Integer idComprador) {
		this.idComprador = idComprador;
	}
	public String getNombreComprador() {
		return nombreComprador;
	}
	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}
	public String getDireccionComprador() {
		return direccionComprador;
	}
	public void setDireccionComprador(String direccionComprador) {
		this.direccionComprador = direccionComprador;
	}
	public String getDocumentoComprador() {
		return documentoComprador;
	}
	public void setDocumentoComprador(String documentoComprador) {
		this.documentoComprador = documentoComprador;
	}
	
	

}
