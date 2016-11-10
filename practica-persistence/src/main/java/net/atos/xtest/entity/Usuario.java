package net.atos.xtest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name = "USUARIOS")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_USUARIO")
	private String idUsuario;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_ALTA")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_BAJA")
	private Date fechaBaja;

	private String nif;

	private String nombre;

	@Column(name = "PRIMER_APELLIDO")
	private String primerApellido;

	@Column(name = "SEGUNDO_APELLIDO")
	private String segundoApellido;

	private BigDecimal telefono;

	// bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name = "ROL")
	private Rol rolBean;

	// bi-directional many-to-one association to UsuarioTest
	@OneToMany(mappedBy = "usuario")
	private Set<UsuarioTest> usuarioTests;

	public Usuario() {
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public BigDecimal getTelefono() {
		return this.telefono;
	}

	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}

	public Rol getRolBean() {
		return this.rolBean;
	}

	public void setRolBean(Rol rolBean) {
		this.rolBean = rolBean;
	}

	public Set<UsuarioTest> getUsuarioTests() {
		return this.usuarioTests;
	}

	public void setUsuarioTests(Set<UsuarioTest> usuarioTests) {
		this.usuarioTests = usuarioTests;
	}

	public UsuarioTest addUsuarioTest(UsuarioTest usuarioTest) {
		getUsuarioTests().add(usuarioTest);
		usuarioTest.setUsuario(this);

		return usuarioTest;
	}

	public UsuarioTest removeUsuarioTest(UsuarioTest usuarioTest) {
		getUsuarioTests().remove(usuarioTest);
		usuarioTest.setUsuario(null);

		return usuarioTest;
	}

}