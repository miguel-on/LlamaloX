package net.atos.xtest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the TEST database table.
 * 
 */
@Entity
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TEST")
	private String idTest;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_FIN")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;

	private String nombre;

	@Column(name="NUMERO_OPORTUNIDADES")
	private BigDecimal numeroOportunidades;

	//bi-directional many-to-many association to Pregunta
	@ManyToMany
	@JoinTable(
		name="TEST_PREGUNTA"
		, joinColumns={
			@JoinColumn(name="ID_TEST")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_PREGUNTA")
			}
		)
	private Set<Pregunta> preguntas;

	//bi-directional many-to-one association to UsuarioTest
	@OneToMany(mappedBy="test")
	private Set<UsuarioTest> usuarioTests;

	public Test() {
	}

	public String getIdTest() {
		return this.idTest;
	}

	public void setIdTest(String idTest) {
		this.idTest = idTest;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getNumeroOportunidades() {
		return this.numeroOportunidades;
	}

	public void setNumeroOportunidades(BigDecimal numeroOportunidades) {
		this.numeroOportunidades = numeroOportunidades;
	}

	public Set<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Set<UsuarioTest> getUsuarioTests() {
		return this.usuarioTests;
	}

	public void setUsuarioTests(Set<UsuarioTest> usuarioTests) {
		this.usuarioTests = usuarioTests;
	}

	public UsuarioTest addUsuarioTest(UsuarioTest usuarioTest) {
		getUsuarioTests().add(usuarioTest);
		usuarioTest.setTest(this);

		return usuarioTest;
	}

	public UsuarioTest removeUsuarioTest(UsuarioTest usuarioTest) {
		getUsuarioTests().remove(usuarioTest);
		usuarioTest.setTest(null);

		return usuarioTest;
	}

}