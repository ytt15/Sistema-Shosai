package com.example.shosai.Dao;

import com.example.shosai.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Integer>{

    public Usuario findByCorreoAndClave(String correo, String clave);
    
    @Query(value = "select * from usuario inner join rol_has_usuario on usuario.identificaion = rol_has_usuario.usuario_identificaion order by nombres", nativeQuery = true)
    public List<Usuario> listarUsuarioEliminar();
    
    @Query(value = "select * from usuario inner join rol_has_usuario on usuario.identificaion = rol_has_usuario.usuario_identificaion order by nombres", nativeQuery = true)
    public List<Usuario> listarUsuario();

    @Query(value="select * from usuario where correo=?1", nativeQuery= true)
    public Usuario findByCorreo(String Correo);
  }