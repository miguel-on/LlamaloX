package net.atos.xtest.business.test;


import java.util.List;


import net.atos.xtest.dao.TestDao;
import net.atos.xtest.dto.FiltroTestsDto;
import net.atos.xtest.entity.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class TestBO {

	@Autowired
	TestDao testDao;

	public void insertar(Test u) {
		testDao.insertar(u);
	}

	public Test actualizar(Test u) {
		return testDao.actualizar(u);
	}

	public void borrar(Test u) {
		testDao.borrar(u);
	}

	public List<Test> buscar(FiltroTestsDto filtro) {
		return testDao.buscar(filtro);
	}
	
	

}
