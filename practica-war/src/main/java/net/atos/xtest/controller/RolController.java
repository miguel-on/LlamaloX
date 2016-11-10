package net.atos.xtest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import net.atos.xtest.business.rol.RolBO;
import net.atos.xtest.dto.FiltroRolDto;
import net.atos.xtest.entity.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component
@Transactional
@Scope("view")
public class RolController {
	
	private FiltroRolDto filtro = new FiltroRolDto();
	private List<Rol> rol = new ArrayList<Rol>();	
	private Rol rolSeleccionado;
	
	@Autowired
	RolBO RolBO;
	
	@PostConstruct
	public void init() {
		leerRoles();
	}
	
	public void leerRoles() {
		setRol(RolBO.leerRoles());
	}
	
	public void nuevoRol() {
		rolSeleccionado = new Rol();
	}
	
	public void insertar() {
		RolBO.insertar(rolSeleccionado);
		buscar();
	}

	public Rol actualizar() {
		Rol updated = RolBO.actualizar(rolSeleccionado);
		buscar();
		return updated;
	}

	public void borrar() {
		RolBO.borrar(rolSeleccionado);
		buscar();
	}

	public void buscar() {
		rol = RolBO.buscar(filtro);
	}

	public FiltroRolDto getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroRolDto filtro) {
		this.filtro = filtro;
	}

	public List<Rol> getLista() {
		return rol;
	}

	public void setLista(List<Rol> rol) {
		this.rol = rol;
	}

	public Rol getRolSeleccionado() {
		return rolSeleccionado;
	}

	public void setRolSeleccionado(Rol rolSeleccionado) {
		this.rolSeleccionado = rolSeleccionado;
	}

	public List<Rol> getRol() {
		return rol;
	}

	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}
	
	

}
