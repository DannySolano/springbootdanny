
package com.producto.respository;

import com.producto.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Autor: Danny Solano Descripcion: Comunicacion con el Entity Framework con el
 * CRUD
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
