package net.atos.xtest.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import net.atos.xtest.business.login.LoginBO;
import net.atos.xtest.common.identity.Identity;
import net.atos.xtest.entity.Usuario;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class LoginController {

	private static final Logger LOG = Logger.getLogger(LoginController.class);

	@Autowired
	LoginBO loginBO;

	@Autowired
	Identity identity;

	private String password;
	private String msg;
	private String rol;
	private String usuario;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String navega1() {
		return "pages/usuarios/crudUsuarios.xhtml";
	}

	public String doLogin() {
		Usuario u = loginBO.validate(usuario, password);
		if (u.getNombre() != "" || u.getNombre() != null) {
			identity.setLoggedIn(true);
			identity.setUsuario(usuario);
			identity.setRol(u.getRolBean().getNombre());
			LOG.info("==== Usuario logado: " + usuario);

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("identity", identity);

			return "home.xhtml";
		} else {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_WARN,
									"Usuario o contraseña incorrectos",
									"Por favor, introduzca usuario y/o contraseña válidos."));
			LOG.info("**** Usuario log incorrecto: " + usuario);
			return "false";
		}
	}

	public String logout() {
		loginBO.logout();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
		FacesMessage msg = new FacesMessage("Logout realizado.",
				identity.getUsuario());
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		identity.setLoggedIn(false);
		identity.setUsuario(null);
		identity.setRol(null);

		return "/login.xhtml";
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
