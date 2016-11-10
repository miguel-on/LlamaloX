package net.atos.xtest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;

	private BigDecimal baja;

	private String descripcion;

	//bi-directional many-to-many association to Modulo
	@ManyToMany
	@JoinTable(
		name="ROL_MODULO"
		, joinColumns={
			@JoinColumn(name="NOMBRE_ROL")
			}
		, inverseJoinColumns={
			@JoinColumn(name="NOMBRE_MODULO")
			}
		)
	private Set<Modulo> modulos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rolBean")
	private Set<Usuario> usuarios;

	public Rol() {
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getBaja() {
		return this.baja;
	}

	public void setBaja(BigDecimal baja) {
		this.baja = baja;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Modulo> getModulos() {
		return this.modulos;
	}

	public void setModulos(Set<Modulo> modulos) {
		this.modulos = modulos;
	}

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRolBean(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRolBean(null);

		return usuario;
	}

}