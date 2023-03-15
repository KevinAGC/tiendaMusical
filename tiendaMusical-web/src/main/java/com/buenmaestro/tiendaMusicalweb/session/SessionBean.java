package com.buenmaestro.tiendaMusicalweb.session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.buenmaestro.tiendaMusicalentities.entities.Persona;

/**
 * 
 * @author kevin
 * Class que mantendra la informacion en la sesion del usuario
 */
@ManagedBean
@SessionScoped
public class SessionBean {
	private Persona persona;
	public void init() {
		System.out.println("Creando sesion..........");
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
