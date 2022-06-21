package com.example.shosai.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.shosai.domain.Producto;

public interface ProductosRepository extends CrudRepository<Producto, Integer> {

    Producto findFirstByCodigo(String codigo);
}
