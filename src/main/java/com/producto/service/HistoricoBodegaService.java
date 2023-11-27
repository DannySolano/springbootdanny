package com.producto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producto.model.HistoricoBodega;
import com.producto.respository.HistoricoBodegaRepository;

@Service
public class HistoricoBodegaService {
	@Autowired
	private HistoricoBodegaRepository historicoBodegaRepository;

	public List<HistoricoBodega> list() {
		return historicoBodegaRepository.findAll();
	}

}
