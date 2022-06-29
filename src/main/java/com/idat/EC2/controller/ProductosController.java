package com.idat.EC2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.EC2.dto.ProductosDTORequest;
import com.idat.EC2.dto.ProductosDTOResponse;
import com.idat.EC2.service.ProductosService;

@Controller
@RequestMapping("/productos/v1")
public class ProductosController {
	@Autowired
	private ProductosService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<ProductosDTOResponse>> listar() {
		return new ResponseEntity<List<ProductosDTOResponse>>( service.listarProductos(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProductosDTORequest productos) {
		service.guardarProductos(productos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		ProductosDTOResponse p=service.obtenerProductosId(id);
		if(p != null) {
			service.eliminarProductos(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody ProductosDTORequest producto) {
		ProductosDTOResponse p=service.obtenerProductosId(producto.getIdLucro());
		
		if(p != null) {
			service.actualizarProductos(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductosDTOResponse> obtenerID(@PathVariable Integer id) {
		ProductosDTOResponse p=service.obtenerProductosId(id);
		
		if(p != null) {			
			return new ResponseEntity<ProductosDTOResponse>(service.obtenerProductosId(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<ProductosDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
