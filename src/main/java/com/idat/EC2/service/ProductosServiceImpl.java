package com.idat.EC2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2.dto.ProductosDTORequest;
import com.idat.EC2.dto.ProductosDTOResponse;
import com.idat.EC2.model.Productos;
import com.idat.EC2.repository.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService{
	
	@Autowired
	private ProductosRepository repository;
	
	@Override
	public void guardarProductos(ProductosDTORequest productosDTO) {
		// TODO Auto-generated method stub
		Productos productos=new Productos();
		productos.setProducto(productosDTO.getLucro());
		productos.setDescripcion(productosDTO.getDescripcionLucro());
		productos.setPrecio(productosDTO.getPrecioLucro());
		productos.setStock(productosDTO.getStockLucro());
		repository.save(productos);
	}

	@Override
	public void actualizarProductos(ProductosDTORequest productosDTO) {
		// TODO Auto-generated method stub
		Productos productos=new Productos();
		productos.setIdProducto(productosDTO.getIdLucro());
		productos.setProducto(productosDTO.getLucro());
		productos.setDescripcion(productosDTO.getDescripcionLucro());
		productos.setPrecio(productosDTO.getPrecioLucro());
		productos.setStock(productosDTO.getStockLucro());
		repository.saveAndFlush(productos);
	}

	@Override
	public void eliminarProductos(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<ProductosDTOResponse> listarProductos() {
		// TODO Auto-generated method stub
		List<ProductosDTOResponse> listar=new ArrayList<>();
		ProductosDTOResponse dto=null;
		List<Productos> p=repository.findAll();
		
		for(Productos producto:p) {
			dto=new ProductosDTOResponse();
			dto.setIdLucro(producto.getIdProducto());
			dto.setLucro(producto.getProducto());
			dto.setDescripcionLucro(producto.getDescripcion());
			dto.setPrecioLucro(producto.getPrecio());
			dto.setStockLucro(producto.getStock());
			listar.add(dto);
			
		}
		
		return listar;
	}

	@Override
	public ProductosDTOResponse obtenerProductosId(Integer id) {
		// TODO Auto-generated method stub
		Productos producto=repository.findById(id).orElse(null);
		ProductosDTOResponse dto=null;
		dto=new ProductosDTOResponse();
		dto.setIdLucro(producto.getIdProducto());
		dto.setLucro(producto.getProducto());
		dto.setDescripcionLucro(producto.getDescripcion());
		dto.setPrecioLucro(producto.getPrecio());
		dto.setStockLucro(producto.getStock());
				
		return dto;
	}

}
