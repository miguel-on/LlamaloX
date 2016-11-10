package net.atos.xtest.dto;

import java.math.BigDecimal;
import java.util.Date;

public class FiltroTestsDto {


	protected Date fechaFinDesde;
	protected Date fechaFinHasta;
	protected Date fechaInicioDesde;
	protected Date fechaInicioHasta;
	protected String nombre;
	protected BigDecimal numeroOportunidades;
	
	public Date getFechaFinDesde() {
		return fechaFinDesde;
	}
	public void setFechaFinDesde(Date fechaFinDesde) {
		this.fechaFinDesde = fechaFinDesde;
	}
	public Date getFechaFinHasta() {
		return fechaFinHasta;
	}
	public void setFechaFinHasta(Date fechaFinHasta) {
		this.fechaFinHasta = fechaFinHasta;
	}
	public Date getFechaInicioDesde() {
		return fechaInicioDesde;
	}
	public void setFechaInicioDesde(Date fechaInicioDesde) {
		this.fechaInicioDesde = fechaInicioDesde;
	}
	public Date getFechaInicioHasta() {
		return fechaInicioHasta;
	}
	public void setFechaInicioHasta(Date fechaInicioHasta) {
		this.fechaInicioHasta = fechaInicioHasta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getNumeroOportunidades() {
		return numeroOportunidades;
	}
	public void setNumeroOportunidades(BigDecimal numeroOportunidades) {
		this.numeroOportunidades = numeroOportunidades;
	}
}
