package com.restfullPractica.restfullPractica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfullPractica.restfullPractica.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	List<Producto> findByOrderByPrecioDesc();
}
