package com.idat.EC2.service;

import java.util.List;

import com.idat.EC2.dto.BodegaDTORequest;
import com.idat.EC2.dto.BodegaDTOResponse;


public interface BodegaService {
	
	
	void guardarBodega(BodegaDTORequest bodega);
	void actualizarBodega(BodegaDTORequest bodega);
	void eliminarBodega(Integer id);	
	List<BodegaDTOResponse>listarBodega();
	BodegaDTOResponse obtenerBodegaId(Integer id);

}
