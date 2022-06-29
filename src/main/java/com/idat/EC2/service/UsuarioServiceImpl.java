package com.idat.EC2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2.dto.UsuarioDTORequest;
import com.idat.EC2.dto.UsuarioDTOResponse;
import com.idat.EC2.model.Usuario;
import com.idat.EC2.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void guardarUsuario(UsuarioDTORequest usuarioDTO) {
		// TODO Auto-generated method stub
		Usuario usuario=new Usuario();
		usuario.setUsuario(usuarioDTO.getConsumidor());
		usuario.setPassword(usuarioDTO.getPasswordConsumidor());
		usuario.setRol(usuarioDTO.getRolConsumidor());
		repository.save(usuario);	
	}

	@Override
	public void actualizarUsuario(UsuarioDTORequest usuarioDTO) {
		// TODO Auto-generated method stub
		Usuario usuario=new Usuario();
		usuario.setIdUsuarios(usuarioDTO.getIdConsumidor());
		usuario.setUsuario(usuarioDTO.getConsumidor());
		usuario.setPassword(usuarioDTO.getPasswordConsumidor());
		usuario.setRol(usuarioDTO.getRolConsumidor());
		repository.saveAndFlush(usuario);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<UsuarioDTOResponse> listarUsuario() {
		// TODO Auto-generated method stub
		List<UsuarioDTOResponse> listar=new ArrayList<>();
		UsuarioDTOResponse dto=null;
		List<Usuario> u=repository.findAll();		
		for(Usuario usuario:u) {
			dto=new UsuarioDTOResponse();
			dto.setIdConsumidor(usuario.getIdUsuarios());
			dto.setConsumidor(usuario.getUsuario());
			dto.setPasswordConsumidor(usuario.getPassword());
			dto.setRolConsumidor(usuario.getRol());			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public UsuarioDTOResponse obtenerUsuarioId(Integer id) {
		// TODO Auto-generated method stub
		Usuario usuario=repository.findById(id).orElse(null);
		UsuarioDTOResponse dto=null;
		dto=new UsuarioDTOResponse();
		dto.setIdConsumidor(usuario.getIdUsuarios());
		dto.setConsumidor(usuario.getUsuario());
		dto.setPasswordConsumidor(usuario.getPassword());
		dto.setRolConsumidor(usuario.getRol());	
		
		return dto;
	}

}
