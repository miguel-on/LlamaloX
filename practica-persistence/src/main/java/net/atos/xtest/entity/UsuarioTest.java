package net.atos.xtest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the USUARIO_TEST database table.
 * 
 */
@Entity
@Table(name="USUARIO_TEST")
@NamedQuery(name="UsuarioTest.findAll", query="SELECT u FROM UsuarioTest u")
public class UsuarioTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioTestPK id;

	private BigDecimal aciertos;

	private BigDecimal fallos;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="ID_TEST", insertable=false, updatable=false)
	private Test test;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO", insertable=false, updatable=false)
	private Usuario usuario;

	public UsuarioTest() {
	}

	public UsuarioTestPK getId() {
		return this.id;
	}

	public void setId(UsuarioTestPK id) {
		this.id = id;
	}

	public BigDecimal getAciertos() {
		return this.aciertos;
	}

	public void setAciertos(BigDecimal aciertos) {
		this.aciertos = aciertos;
	}

	public BigDecimal getFallos() {
		return this.fallos;
	}

	public void setFallos(BigDecimal fallos) {
		this.fallos = fallos;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}