/**
 * 
 */
package com.buenmaestro.tiendaMusicalweb.utils;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author Kevin Clase generada para crear funciones globales o comunes entre
 *         clases del proyecto
 *
 */
public class CommonUtils {
	public static void mostrarMensaje(Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	/**
	 * Metodo que permit redireccionar entre pantallas del aplicativo
	 * 
	 * @param url {@String} direccion o pantalla a cambiar
	 * @throws IOException
	 */
	public static void redireccionar(String url) throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String contextPath = externalContext.getRequestContextPath();
		externalContext.redirect(contextPath + url);
	}

}
