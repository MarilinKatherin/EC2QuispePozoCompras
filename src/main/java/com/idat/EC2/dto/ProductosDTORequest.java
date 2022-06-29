package com.idat.EC2.dto;

public class ProductosDTORequest {
	private Integer idLucro;
	private String Lucro;
	private String descripcionLucro;
	private Double precioLucro;
	private Integer stockLucro;
	public Integer getIdLucro() {
		return idLucro;
	}
	public void setIdLucro(Integer idLucro) {
		this.idLucro = idLucro;
	}
	public String getLucro() {
		return Lucro;
	}
	public void setLucro(String lucro) {
		Lucro = lucro;
	}
	public String getDescripcionLucro() {
		return descripcionLucro;
	}
	public void setDescripcionLucro(String descripcionLucro) {
		this.descripcionLucro = descripcionLucro;
	}
	public Double getPrecioLucro() {
		return precioLucro;
	}
	public void setPrecioLucro(Double precioLucro) {
		this.precioLucro = precioLucro;
	}
	public Integer getStockLucro() {
		return stockLucro;
	}
	public void setStockLucro(Integer stockLucro) {
		this.stockLucro = stockLucro;
	}

	
}
