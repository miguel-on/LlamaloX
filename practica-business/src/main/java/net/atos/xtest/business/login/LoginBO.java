package net.atos.xtest.business.login;

import net.atos.xtest.dao.UsuarioDAO;
import net.atos.xtest.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class LoginBO {
	
	@Autowired
	UsuarioDAO usuarioDao;
	
	public Usuario validate(String usuario, String password) {
		Usuario u = usuarioDao.buscarUsuarioPorUsernameYPassword(usuario, password);
		return u;
	}


	public void logout() {
		
	}

}
