package com.example.shosai.controller;

import com.example.shosai.Dao.EmpleadoDao;
import com.example.shosai.Dao.RolDao;
import com.example.shosai.Dao.UsuarioDao;
import com.example.shosai.domain.Rol;
import com.example.shosai.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author YURLEY
 */
@Controller
public class empleadosController {

    @Autowired
    private UsuarioDao UsuarioDao;

    @Autowired
    private EmpleadoDao EmpleadoDao;

    @Autowired
    private RolDao RolDao;

    @GetMapping("/registroEmpleados")
    public String registroEmpleados(Model model) {
        List<Usuario> lstUsuario = new ArrayList<>();
        List<Usuario> lstUsuarioModificar = new ArrayList<>();

        lstUsuario = (List<Usuario>) UsuarioDao.listarUsuarioEliminar();
        lstUsuarioModificar = (List<Usuario>) UsuarioDao.listarUsuario();

        model.addAttribute("lstUsuarioModificar", lstUsuarioModificar);
        model.addAttribute("lstUsuario", lstUsuario);
        model.addAttribute("usuario", new Usuario());
        
        return "registroEmpleados";

    }
    public String VerUsuarios(Model model){
        Usuario obj = new Usuario();
        Usuario aux;
        List<Usuario> lstUsuario = new ArrayList<>();
        
        lstUsuario = (List<Usuario>) UsuarioDao.findAll();
        
        model.addAttribute("lstUsuario", lstUsuario);
        model.addAttribute("usuario", obj);
        return "registroEmpleados";
    }
    
  
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(Usuario usuario){
       
        Rol rol = RolDao.findByNombrerol("ADMINISTRADOR");
        List<Rol> roles = new ArrayList<Rol>();
        roles.add(rol);
        usuario.setRoles(roles);
        UsuarioDao.save(usuario);
        return "redirect:registroEmpleados";
    }
    
    @RequestMapping("/modificarUsuario")
    public String modificarUsuario(@RequestParam(name = "identificaion", defaultValue
            = "0") Integer identificaion, Model model) {
        Usuario usuario = UsuarioDao.findById(identificaion).orElse(null);
        model.addAttribute("usuario",usuario);
        return "modificarUsuario";
    }
    
    
    

}