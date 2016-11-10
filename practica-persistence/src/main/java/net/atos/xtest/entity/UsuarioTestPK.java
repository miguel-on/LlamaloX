package net.atos.xtest.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USUARIO_TEST database table.
 * 
 */
@Embeddable
public class UsuarioTestPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private String idUsuario;

	@Column(name="ID_TEST", insertable=false, updatable=false)
	private String idTest;

	public UsuarioTestPK() {
	}
	public String getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdTest() {
		return this.idTest;
	}
	public void setIdTest(String idTest) {
		this.idTest = idTest;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioTestPK)) {
			return false;
		}
		UsuarioTestPK castOther = (UsuarioTestPK)other;
		return 
			this.idUsuario.equals(castOther.idUsuario)
			&& this.idTest.equals(castOther.idTest);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario.hashCode();
		hash = hash * prime + this.idTest.hashCode();
		
		return hash;
	}
}