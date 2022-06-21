package com.example.shosai.domain;

import com.example.shosai.domain.Rol;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author YURLEY
 */
@Entity
@Data
@Table(name="usuario")
public class DatosUsuario {
    @Id
    private Integer identificaion;
    private String telefono;
    private String nombres;
    private String apellidos;
    private String correo;
    @DateTimeFormat (pattern = "yyy-mm-dd")
    @Temporal (TemporalType.DATE)
    private Date fecha_nacimiento;
 
    private String clave;
    
    @ManyToMany
    @JoinTable(name="rol_has_usuario",
            joinColumns = {@JoinColumn(name="usuario_identificaion")},
            inverseJoinColumns = {@JoinColumn(name="rol_idrol") })
     private List<Rol> roles;
      
}
