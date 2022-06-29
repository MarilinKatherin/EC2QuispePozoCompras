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

import com.idat.EC2.dto.UsuarioDTORequest;
import com.idat.EC2.dto.UsuarioDTOResponse;
import com.idat.EC2.service.UsuarioService;

@Controller
@RequestMapping("/usuario/v1")
public class UsuarioController {
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(path="/crearToken",method = RequestMethod.POST)
	public ResponseEntity<?> crearToken(@RequestBody UsuarioDTORequest request){
		return ResponseEntity.ok(new UsuarioDTOResponse());
	}
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<UsuarioDTOResponse>> listar() {
		return new ResponseEntity<List<UsuarioDTOResponse>>( service.listarUsuario(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioDTORequest usuario) {
		service.guardarUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		UsuarioDTOResponse p=service.obtenerUsuarioId(id);
		if(p != null) {
			service.eliminarUsuario(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody UsuarioDTORequest usuario) {
		UsuarioDTOResponse p=service.obtenerUsuarioId(usuario.getIdConsumidor());
		
		if(p != null) {
			service.actualizarUsuario(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTOResponse> obtenerID(@PathVariable Integer id) {
		UsuarioDTOResponse p=service.obtenerUsuarioId(id);
		
		if(p != null) {			
			return new ResponseEntity<UsuarioDTOResponse>(service.obtenerUsuarioId(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<UsuarioDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
