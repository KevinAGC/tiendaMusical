/**
 * 
 */
package com.buenmaestro.tiendaMusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.buenmaestro.tiendaMusicalentities.entities.Persona;
import com.buenmaestro.tiendaMusicalservices.service.LoginService;
import com.buenmaestro.tiendaMusicalweb.session.SessionBean;
import com.buenmaestro.tiendaMusicalweb.utils.CommonUtils;

/**
 * @author Kevin controlador que se encarga del flujo de la pantalla de login.xhtml
 *
 */
@ManagedBean
@ViewScoped
public class LoginController {
	/**
	 * Usuario capturado por la persona
	 */
	private String usuario;

	/**
	 * Contraseña capturada por la persona
	 */
	private String password;

	/**
	 * Propiedad de la logica de negocio inyectada con JSF y spring
	 */
	@ManagedProperty("#{loginServiceImpl}")
	private LoginService loginServiceImpl;

	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	@PostConstruct
	public void init() {
		System.out.println("Inicializando login.....");
	}

	public void entrar() {
		Persona personaConsultada = this.loginServiceImpl.consultarUsuarioLogin(this.usuario, this.password);

		if (personaConsultada != null) {
			try {
				this.sessionBean.setPersona(personaConsultada);
				CommonUtils.redireccionar("/pages/commons/dashboard.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
				CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "ERROR!",
						"Formato Incorrecto en el cual se ingresa a la pantalla deseada");
			}
		} else {

			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "¡LO SIENTO!",
					"El usuario y/o contraseña son incorrectos");
		}

	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the loginServiceImpl
	 */
	public LoginService getLoginServiceImpl() {
		return loginServiceImpl;
	}

	/**
	 * @param loginServiceImpl the loginServiceImpl to set
	 */
	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}

}
