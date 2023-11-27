package com.producto.service;

import com.producto.model.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.producto.respository.ProductoRepository;
import com.producto.utils.Movimiento;

import java.util.Optional;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.CallableStatement;
import java.sql.Types;

/**
 *
 * @author soporte
 */
@Service
public class ProductoService {
	

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private JdbcTemplate jdbc;
	
	
	public List<Map<String, Object>> listStockProducts(){
		List<Map<String, Object>> results = jdbc.queryForList("EXEC [DBO].[SPListarProductos]");
		return results; 
	}
	
	public String sellProduct(Movimiento objVenta) {
        try {
            List<SqlParameter> params = Arrays.asList(
                    new SqlParameter("ProductoID", Types.INTEGER),
                    new SqlParameter("Venta", Types.DOUBLE),
                    new SqlParameter("Estado", Types.INTEGER)
            );

            jdbc.call(con -> {
                CallableStatement cs = con.prepareCall("{call SPHistoricoBodegaVender(?, ?, ?)}");
                cs.setInt("ProductoID", objVenta.getProductID());
                cs.setDouble("Venta", objVenta.getCantidad());
                cs.setInt("Estado", objVenta.getEstado());
                return cs;
            }, params);

            return "success";
        } catch (Exception e) {
            e.printStackTrace(); 
            return "error";
        }
    }

	
	public String buyProducto(Movimiento objCompra) {
	        try {
	            List<SqlParameter> params = Arrays.asList(
	                    new SqlParameter("ProductoID", Types.INTEGER),
	                    new SqlParameter("Cantidad", Types.DECIMAL),
	                    new SqlParameter("Estado", Types.INTEGER)
	            );
	            
	            List<SqlParameter> product = Arrays.asList(
	                    new SqlParameter("ProductoID", Types.INTEGER),
	                    new SqlParameter("Estado", Types.INTEGER)
	            );
	            
	            jdbc.call(con -> {
	            	   CallableStatement cs = con.prepareCall("{call SPBodegaInsert(?, ?)}");
		                cs.setInt("ProductoID", objCompra.getProductID());
		                cs.setInt("Estado", objCompra.getEstado());
		                return cs;
	            }, product);

	            jdbc.call(con -> {
	                CallableStatement cs = con.prepareCall("{call SPHistoricoBodegaComprar(?, ?, ?)}");
	                cs.setInt("ProductoID", objCompra.getProductID());
	                cs.setDouble("Cantidad", objCompra.getCantidad());
	                cs.setInt("Estado", objCompra.getEstado());
	                return cs;
	            }, params);

	            return "success";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "error";
	        }
	    }

	public String anularVenta(Integer historicoId) {
	        try {
	            List<SqlParameter> params = Arrays.asList(
	                    new SqlParameter("HistoricoId", Types.INTEGER)
	            );

	            jdbc.call(con -> {
	                CallableStatement cs = con.prepareCall("{call SPHistoricoBodegaAnular(?)}");
	                cs.setInt("HistoricoId", historicoId);
	                return cs;
	            }, params);

	            return "success";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "error";
	        }
	    }
	
	public List<Producto> list() {
		return productoRepository.findAll();
	}

	public Optional<Producto> listOne(Integer pId) {
		return productoRepository.findById(pId);
	}

	public Producto create(Producto pEstado) {
		return productoRepository.save(pEstado);
	}

	public Producto update(Producto pEstado) {
		return productoRepository.save(pEstado);
	}

	public String delete(Integer pId) {
		String MsgRespuesta;
		try {
			productoRepository.deleteById(pId);
			MsgRespuesta = "Eliminacion Correcta";
		} catch (Exception e) {
			MsgRespuesta = "Error en la eliminacion de " + pId + "\n" + e.getMessage();
		}
		return MsgRespuesta;
	}
}
