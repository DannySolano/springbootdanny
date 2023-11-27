package com.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producto.model.HistoricoBodega;
import com.producto.service.HistoricoBodegaService;

@RestController
public class HistoricoBodegaController {
	@Autowired
	private HistoricoBodegaService historicoBodegaService;

	@GetMapping("/historico")
	public List<HistoricoBodega> listAllEstados() {
		return historicoBodegaService.list();
	}
}
