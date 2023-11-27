package com.producto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.producto.model.Estado;
import com.producto.service.EstadoService;

/**
 *
 * @author soporte
 */
@RestController
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	@GetMapping("/estados")
	public List<Estado> listAllEstados() {
		return estadoService.list();
	}

	@GetMapping("/estados/{id}")
	public Optional<Estado> listProduct(@PathVariable("id") Integer pId) {
		return estadoService.listOne(pId);
	}

	@PostMapping("/estados")
	public Estado createProduct(@RequestBody Estado objEstado) {
		return estadoService.create(objEstado);
	}

	@PutMapping("/estados")
	public Estado updateProduct(@RequestBody Estado objEstado) {
		return estadoService.update(objEstado);
	}

	@DeleteMapping("/estados/{id}")
	public String deleteProduct(@PathVariable("id") Integer pId) {
		return estadoService.delete(pId);
	}
}
