package com.producto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Autor: Danny Solano Descripcion: Entidad TEstado que permita el CRUD de
 * estados hacia la DB
 */

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Getter
@Setter
@Data
@Table(name = "TProducto")
public class Producto {

	@Id
	@Column(name = "PRO_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer PRO_Id;
	@Column(name = "PRO_Nombre")
	private String PRO_Nombre;
	@Column(name = "PRO_Descripcion")
	private String PRO_Descripcion;
	@Column(name = "PRO_Precio")
	private Double PRO_Precio;
	@Column(name = "PRO_ExcentoIva")
	private Double PRO_ExcentoIva;
	@Column(name = "PRO_FechaCreacion")
	private Date PRO_FechaCreacion;
	@Column(name = "PRO_Estado")
	private String PRO_Estado;
}
