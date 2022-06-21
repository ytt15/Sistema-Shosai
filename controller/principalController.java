package com.example.shosai.controller;

import com.example.shosai.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.shosai.Dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class principalController {

    @Autowired
    UsuarioDao usuarioDao;

    private Usuario usuario;
    private String identificaion;
    
    @GetMapping("/")
    public String index() {
        return "pagprincipal";
    }

    @GetMapping("/productos")
    public String productos() {
        return "productos";
    }

    @GetMapping("/cliente")
    public String cliente() {
        return "cliente";
    }

    @GetMapping("/empleado")
    public String empleado() {
        return "empleado";
    }
    
    @GetMapping("/cambiarContrseña")
    public String cambiarContrseña(){
        return "cambiarContrseña";
    }
    
    @GetMapping("/formularioCambioContraseña")
    public String formularioCambioContraseña(Model model, @RequestParam(name = "identificaion") String identificaion){
        model.addAttribute("identificaion", identificaion);
        this.identificaion = identificaion;
        return "formularioCambioContraseña";
    }

    
    
    @PostMapping("/ModificarContraseña")
    public String ModificarContra(Model model, @RequestBody MultiValueMap<String, String> formData) {
        String clave = formData.get("contrasena_usuario").get(0);
        String identificaion = this.identificaion;
        Usuario usuario = usuarioDao.findById(Integer.parseInt(identificaion)).orElse(null);
        usuario.setClave(clave);
        //usuario.setContrasena_usuario(usuario.getContrasena_usuario());
        usuarioDao.save(usuario);
        model.addAttribute("usuario", usuario);
        return "redirect:/";
    }
}
