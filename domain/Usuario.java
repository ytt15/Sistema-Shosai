package com.example.shosai.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity


@Table(name="usuario")
public class Usuario{
    @Id
    private Integer identificaion;
    private String telefono;
    private String nombres;
    private String apellidos;
    private String correo;
    @DateTimeFormat (pattern = "yyy-mm-dd")
    @Temporal (TemporalType.DATE)
    private Date fecha_nacimiento;
    private Integer edad;
    private String clave;
    
    @ManyToMany
    @JoinTable(name="rol_has_usuario",
            joinColumns = {@JoinColumn(name="usuario_identificaion")},
            inverseJoinColumns = {@JoinColumn(name="rol_idrol") })
    private List<Rol> roles;

    
	public Usuario() {
		super();
	}

	public Usuario(Integer identificaion, String telefono, String nombres, String apellidos, String correo,
			Date fecha_nacimiento, Integer edad, String clave, List<Rol> roles) {
		super();
		this.identificaion = identificaion;
		this.telefono = telefono;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.edad = edad;
		this.clave = clave;
		this.roles = roles;
	}

	public Integer getIdentificaion() {
		return identificaion;
	}

	public void setIdentificaion(Integer identificaion) {
		this.identificaion = identificaion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
      
}