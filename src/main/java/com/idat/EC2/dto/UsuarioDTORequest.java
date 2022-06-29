package com.idat.EC2.dto;

public class UsuarioDTORequest {
	private Integer idConsumidor;
	private String Consumidor;
	private String passwordConsumidor;
	private String rolConsumidor;
	public Integer getIdConsumidor() {
		return idConsumidor;
	}
	public void setIdConsumidor(Integer idConsumidor) {
		this.idConsumidor = idConsumidor;
	}
	public String getConsumidor() {
		return Consumidor;
	}
	public void setConsumidor(String consumidor) {
		Consumidor = consumidor;
	}
	public String getPasswordConsumidor() {
		return passwordConsumidor;
	}
	public void setPasswordConsumidor(String passwordConsumidor) {
		this.passwordConsumidor = passwordConsumidor;
	}
	public String getRolConsumidor() {
		return rolConsumidor;
	}
	public void setRolConsumidor(String rolConsumidor) {
		this.rolConsumidor = rolConsumidor;
	}
	
	
	
}
