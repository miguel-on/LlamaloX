package net.atos.xtest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the MODULO database table.
 * 
 */
@Entity
@NamedQuery(name="Modulo.findAll", query="SELECT m FROM Modulo m")
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;

	private BigDecimal baja;

	//bi-directional many-to-many association to Rol
	@ManyToMany(mappedBy="modulos")
	private Set<Rol> rols;

	public Modulo() {
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

	public Set<Rol> getRols() {
		return this.rols;
	}

	public void setRols(Set<Rol> rols) {
		this.rols = rols;
	}

}