package com.idat.EC2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2.dto.ClienteDTORequest;
import com.idat.EC2.dto.ClienteDTOResponse;
import com.idat.EC2.model.Cliente;
import com.idat.EC2.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public void guardarCliente(ClienteDTORequest clienteDTO) {
		// TODO Auto-generated method stub
		Cliente cliente=new Cliente();
		cliente.setNombre(clienteDTO.getNombreComprador());
		cliente.setDni(clienteDTO.getDocumentoComprador());
		cliente.setDireccion(clienteDTO.getDireccionComprador());		
		repository.save(cliente);	
	}

	@Override
	public void actualizarCliente(ClienteDTORequest clienteDTO) {
		// TODO Auto-generated method stub
		Cliente cliente=new Cliente();
		cliente.setIdCliente(clienteDTO.getIdComprador());
		cliente.setNombre(clienteDTO.getNombreComprador());
		cliente.setDni(clienteDTO.getDocumentoComprador());
		cliente.setDireccion(clienteDTO.getDireccionComprador());	
		repository.saveAndFlush(cliente);
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);	
	}

	@Override
	public List<ClienteDTOResponse> listarCliente() {
		// TODO Auto-generated method stub
		List<ClienteDTOResponse> listar=new ArrayList<>();
		ClienteDTOResponse dto=null;
		List<Cliente> p=repository.findAll();
		for(Cliente cliente:p) {
			dto=new ClienteDTOResponse();
			dto.setIdComprador(cliente.getIdCliente());
			dto.setNombreComprador(cliente.getNombre());
			dto.setDocumentoComprador(cliente.getDni());
			dto.setDireccionComprador(cliente.getDireccion());
			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		// TODO Auto-generated method stub
		Cliente cliente=repository.findById(id).orElse(null);
		ClienteDTOResponse dto=null;
		dto=new ClienteDTOResponse();
		dto.setIdComprador(cliente.getIdCliente());
		dto.setNombreComprador(cliente.getNombre());
		dto.setDocumentoComprador(cliente.getDni());
		dto.setDireccionComprador(cliente.getDireccion());
		
		return dto;
	}

}