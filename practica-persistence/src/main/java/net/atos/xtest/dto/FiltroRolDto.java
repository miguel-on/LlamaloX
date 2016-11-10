package net.atos.xtest.dto;

import java.math.BigDecimal;

import net.atos.xtest.entity.Modulo;

public class FiltroRolDto {

	
	protected String nombre;
	protected String descripcion;
	protected BigDecimal baja;
	protected Modulo modulo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getBaja() {
		return baja;
	}
	public void setBaja(BigDecimal baja) {
		this.baja = baja;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	
	
	
}
