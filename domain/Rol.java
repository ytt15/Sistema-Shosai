package com.example.shosai.domain;

/**
 *
 * @author YURLEY
 */
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    private String idrol;
    private String nombrerol;
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;
    
	public Rol() {
		super();
	}

	public Rol(String idrol, String nombrerol, List<Usuario> usuarios) {
		super();
		this.idrol = idrol;
		this.nombrerol = nombrerol;
		this.usuarios = usuarios;
	}

	public String getIdrol() {
		return idrol;
	}

	public void setIdrol(String idrol) {
		this.idrol = idrol;
	}

	public String getNombrerol() {
		return nombrerol;
	}

	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
    
    
}