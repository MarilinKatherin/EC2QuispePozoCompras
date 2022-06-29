package com.idat.EC2.service;

import java.util.List;

import com.idat.EC2.dto.ProductosDTORequest;
import com.idat.EC2.dto.ProductosDTOResponse;



public interface ProductosService {
	
	
	
	void guardarProductos(ProductosDTORequest productos);
	void actualizarProductos(ProductosDTORequest productos);
	void eliminarProductos(Integer id);	
	List<ProductosDTOResponse>listarProductos();
	ProductosDTOResponse obtenerProductosId(Integer id);

}
