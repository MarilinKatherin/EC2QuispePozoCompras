package com.idat.EC2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2.dto.BodegaDTORequest;
import com.idat.EC2.dto.BodegaDTOResponse;
import com.idat.EC2.model.Bodega;
import com.idat.EC2.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService{
	@Autowired
	private BodegaRepository repository;

	@Override
	public void guardarBodega(BodegaDTORequest bodegaDTO) {
		// TODO Auto-generated method stub
		Bodega bodega=new Bodega();
		bodega.setNombre(bodegaDTO.getNombreNegocio());
		bodega.setDireccion(bodegaDTO.getDirNegocio());
		repository.save(bodega);
	}

	@Override
	public void actualizarBodega(BodegaDTORequest bodegaDTO) {
		// TODO Auto-generated method stub
		Bodega bodega=new Bodega();
		bodega.setIdBodega(bodegaDTO.getIdNegocio());
		bodega.setNombre(bodegaDTO.getNombreNegocio());
		bodega.setDireccion(bodegaDTO.getDirNegocio());
		repository.saveAndFlush(bodega);
	}

	@Override
	public void eliminarBodega(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<BodegaDTOResponse> listarBodega() {
		// TODO Auto-generated method stub
		List<BodegaDTOResponse> listar=new ArrayList<>();
		BodegaDTOResponse dto=null;
		List<Bodega> b=repository.findAll();
		
		for(Bodega bodega:b) {
			dto=new BodegaDTOResponse();
			dto.setIdNegocio(bodega.getIdBodega());
			dto.setNombreNegocio(bodega.getNombre());
			dto.setDirNegocio(bodega.getDireccion());

			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public BodegaDTOResponse obtenerBodegaId(Integer id) {
		// TODO Auto-generated method stub
		Bodega bodega=repository.findById(id).orElse(null);
		BodegaDTOResponse dto=null;
		dto=new BodegaDTOResponse();
		dto.setIdNegocio(bodega.getIdBodega());
		dto.setNombreNegocio(bodega.getNombre());
		dto.setDirNegocio(bodega.getDireccion());
		return dto;
	}
}
