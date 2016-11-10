package net.atos.xtest.business.rol;

import java.util.List;

import net.atos.xtest.dao.RolDAO;
import net.atos.xtest.dto.FiltroRolDto;
import net.atos.xtest.entity.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional(propagation = Propagation.REQUIRED)
public class RolBO {
	
	@Autowired
	RolDAO rolDao;
	
	public List<Rol> leerRoles() {
		return RolDAO.leerRoles();
	}

	public void insertar(Rol r) {
		rolDao.insertar(r);
	}

	public Rol actualizar(Rol r) {
		return rolDao.actualizar(r);
	}

	public void borrar(Rol r) {
		rolDao.borrar(r);
	}

	public List<Rol> buscar(FiltroRolDto filtro) {
		return rolDao.buscar(filtro);
	}

}
