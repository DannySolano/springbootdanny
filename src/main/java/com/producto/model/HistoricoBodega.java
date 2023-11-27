package com.producto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Autor: Danny Solano Descripcion: Entidad TEstado que permita el CRUD de
 * estados hacia la DB
 */

@Entity
@Getter
@Setter
@Data
@Table(name = "THistoricoBodega")
public class HistoricoBodega {

	@Id
	@Column(name = "HBOD_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hbodId;
	@Column(name = "HBOD_IdProducto")
	private Integer hbodIdProducto;
	@Column(name = "HBOD_Movimiento")
	private String hbodMovimiento;
	@Column(name = "HBOD_Cantidad")
	private Double hbodCantidad;
	@Column(name = "HBOD_FechaMovimiento")
	private Date   hbodFechaMovimiento;
	@Column(name = "HBOD_Descripcion")
	private String  hbodDescripcion;
	@Column(name = "HBOD_Estado")
	private Integer hbodEstado;
}
