package net.atos.xtest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the RESPUESTA database table.
 * 
 */
@Entity
@NamedQuery(name="Respuesta.findAll", query="SELECT r FROM Respuesta r")
public class Respuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_RESPUESTA")
	private String idRespuesta;

	private BigDecimal correcta;

	private String texto;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne
	@JoinColumn(name="ID_PREGUNTA")
	private Pregunta pregunta;

	public Respuesta() {
	}

	public String getIdRespuesta() {
		return this.idRespuesta;
	}

	public void setIdRespuesta(String idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public BigDecimal getCorrecta() {
		return this.correcta;
	}

	public void setCorrecta(BigDecimal correcta) {
		this.correcta = correcta;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

}