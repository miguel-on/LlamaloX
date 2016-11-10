package net.atos.xtest.business.usuario;


import java.util.List;

import net.atos.xtest.dao.UsuarioDAO;
import net.atos.xtest.dto.FiltroUsuariosDto;
import net.atos.xtest.entity.Rol;
import net.atos.xtest.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioBO {

	@Autowired
	UsuarioDAO usuarioDAO;

	public void insertar(Usuario u) {
		usuarioDAO.insertar(u);
	}

	public Usuario actualizar(Usuario u) {
		return usuarioDAO.actualizar(u);
	}
	
	public List<Rol> leerRoles() {
		return usuarioDAO.leerRoles();
	}

	public void borrar(Usuario u) {
		usuarioDAO.borrar(u);
	}

	public List<Usuario> buscar(FiltroUsuariosDto filtro) {
		return usuarioDAO.buscar(filtro);
	}
	
	

}
