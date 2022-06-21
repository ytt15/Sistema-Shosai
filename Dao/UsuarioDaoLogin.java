package com.example.shosai.Dao;

import com.example.shosai.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author YURLEY
 */
public interface UsuarioDaoLogin extends CrudRepository<Usuario, Integer>{

    public Usuario findByIdentificaionAndClave(Integer identificaion, String clave);
    
    
}
