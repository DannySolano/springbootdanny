package com.producto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Autor: Danny Solano Descripcion: Entidad TEstado que permita el CRUD de
 * estados hacia la DB
 */

@Entity(name = "TEstado")
@Getter
@Setter
@Data
@Table(name = "TEstado")
public class Estado {
	@Id
	@Column(name = "EST_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer estId;
	@Column(name = "EST_Nombre")
	private String estNombre;
	@Column(name = "EST_Descripcion")
	private String estDescripcion;
	@Column(name = "EST_Activo")
	private Integer estActivo;
}
