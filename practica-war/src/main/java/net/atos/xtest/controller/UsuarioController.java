package net.atos.xtest.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import net.atos.xtest.business.usuario.UsuarioBO;
import net.atos.xtest.dto.FiltroUsuariosDto;
import net.atos.xtest.entity.Rol;
import net.atos.xtest.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@Scope("view")
public class UsuarioController {

	protected FiltroUsuariosDto filtro = new FiltroUsuariosDto();
	protected List<Usuario> usuarios = new ArrayList<Usuario>();
	protected Usuario usuarioSeleccionado = new Usuario();
	protected List<Rol> roles = new ArrayList<Rol>();

	@Autowired
	UsuarioBO usuarioBO;

	@PostConstruct
	public void init() {
		leerRoles();
		// WebApplicationContext ctx =
		// FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		// usuarioBO = ctx.getBean(UsuarioBO.class);
	}
	
	public void leerRoles() {
		roles = usuarioBO.leerRoles();
	}

	public void nuevoUsuario() {
		usuarioSeleccionado = new Usuario();
	}

	public void insertar() {
		usuarioBO.insertar(usuarioSeleccionado);
		buscar();
	}
	
	public void resetForm() {
		filtro.setNombre(null);
		filtro.setEmail(null);
		filtro.setTelefono(null);
		filtro.setFechaAlta(null);
		filtro.setFechaBaja(null);
		filtro.setIdUsuario(null);
		filtro.setRol(null);
		filtro.setNif(null);
		filtro.setSegundoApellido(null);
		filtro.setPrimerApellido(null);
	}

	public Usuario actualizar() {
		Usuario updated = usuarioBO.actualizar(usuarioSeleccionado);
		buscar();
		return updated;
	}

	public void borrar() {
		usuarioBO.borrar(usuarioSeleccionado);
		buscar();
	}

	public void buscar() {
		usuarios = usuarioBO.buscar(filtro);
	}

	public FiltroUsuariosDto getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroUsuariosDto filtro) {
		this.filtro = filtro;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

}