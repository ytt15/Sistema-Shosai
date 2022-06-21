/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author YURLEY
 */
@Entity
@Table(name= "empleado")
public class Empleado {
    
    @Id
    private Integer id_empelado;
    private String cargo;
    
    @ManyToOne
    @JoinColumn(name="USUARIO_identificaion")
    private Usuario usuario;

	public Empleado() {
		super();
	}

	public Empleado(Integer id_empelado, String cargo, Usuario usuario) {
		super();
		this.id_empelado = id_empelado;
		this.cargo = cargo;
		this.usuario = usuario;
	}

	public Integer getId_empelado() {
		return id_empelado;
	}

	public void setId_empelado(Integer id_empelado) {
		this.id_empelado = id_empelado;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
    
    
    
    
}