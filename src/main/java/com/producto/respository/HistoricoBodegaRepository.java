package com.producto.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.producto.model.HistoricoBodega;

@Repository
public interface HistoricoBodegaRepository extends JpaRepository<HistoricoBodega, Integer> {}