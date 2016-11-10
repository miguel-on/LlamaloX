package net.atos.xtest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the PREGUNTA database table.
 * 
 */
@Entity
@NamedQuery(name="Pregunta.findAll", query="SELECT p FROM Pregunta p")
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PREGUNTA")
	private String idPregunta;

	@Lob
	private byte[] imagen;

	private String texto;

	//bi-directional many-to-one association to Respuesta
	@OneToMany(mappedBy="pregunta")
	private Set<Respuesta> respuestas;

	//bi-directional many-to-many association to Test
	@ManyToMany(mappedBy="preguntas")
	private Set<Test> tests;

	public Pregunta() {
	}

	public String getIdPregunta() {
		return this.idPregunta;
	}

	public void setIdPregunta(String idPregunta) {
		this.idPregunta = idPregunta;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Set<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Respuesta addRespuesta(Respuesta respuesta) {
		getRespuestas().add(respuesta);
		respuesta.setPregunta(this);

		return respuesta;
	}

	public Respuesta removeRespuesta(Respuesta respuesta) {
		getRespuestas().remove(respuesta);
		respuesta.setPregunta(null);

		return respuesta;
	}

	public Set<Test> getTests() {
		return this.tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

}