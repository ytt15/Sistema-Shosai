/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.Dao;


import com.example.shosai.domain.Rol;
import org.springframework.data.repository.CrudRepository;

public interface RolDao extends CrudRepository<Rol, String> {

    Rol findByNombrerol(String nombrerol);

}
