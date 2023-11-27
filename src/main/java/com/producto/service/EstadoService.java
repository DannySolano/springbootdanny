package com.producto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producto.model.Estado;
import com.producto.respository.EstadoRepository;

/**
 *
 * @author soporte
 */
@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> list() {
		return estadoRepository.findAll();
	}

	public Optional<Estado> listOne(Integer pId) {
		return estadoRepository.findById(pId);
	}

	public Estado create(Estado pEstado) {
		return estadoRepository.save(pEstado);
	}

	public Estado update(Estado pEstado) {
		return estadoRepository.save(pEstado);
	}

	public String delete(Integer pId) {
		String MsgRespuesta;
		try {
			estadoRepository.deleteById(pId);
			MsgRespuesta = "Eliminacion Correcta";
		} catch (Exception e) {
			MsgRespuesta = "Error en la eliminacion de " + pId + "\n" + e.getMessage();
		}
		return MsgRespuesta;
	}
}
