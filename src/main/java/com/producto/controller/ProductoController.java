package com.producto.controller;

import com.producto.model.Producto;
import com.producto.service.ProductoService;
import com.producto.utils.Movimiento;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author soporte
 */
@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/productos/stock")
	public List<Map<String, Object>> listAllProductsStocks() {
		return productoService.listStockProducts();
	}
	
	@GetMapping("/productos")
	public List<Producto> listAllProducts() {
		return productoService.list();
	}

	@GetMapping("/productos/{id}")
	public Optional<Producto> listAllProducts(@PathVariable("id") Integer pId) {
		return productoService.listOne(pId);
	}

	@PostMapping("/productos")
	public Producto createProduct(@RequestBody Producto objProducto) {
		return productoService.create(objProducto);
	}
	
	
	@PostMapping("/productos/vender")
	public String buyProduct(@RequestBody Movimiento objVenta) {
		return productoService.sellProduct(objVenta);
	}
	
	
	@PutMapping("/productos/comprar")
	public String sellProduct(@RequestBody Movimiento objCompra) {
		return productoService.buyProducto(objCompra);
	}

	@PutMapping("/productos")
	public Producto updateProduct(@RequestBody Producto objProducto) {
		return productoService.update(objProducto);
	}

	@DeleteMapping("/productos/{id}")
	public String deleteProduct(@PathVariable("id") Integer pId) {
		return productoService.delete(pId);
	}
	
	@DeleteMapping("/productos/anular/{id}")
	public String anularProduct(@PathVariable("id") Integer pId) {
		return productoService.anularVenta(pId);
	}
}
