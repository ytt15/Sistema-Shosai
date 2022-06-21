package com.example.shosai.Dao;

import com.example.shosai.domain.Empleado;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author YURLEY
 */
public interface EmpleadoDao extends CrudRepository <Empleado, Integer>{
    
}