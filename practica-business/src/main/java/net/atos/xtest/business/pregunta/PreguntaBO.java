package net.atos.xtest.business.pregunta;

import java.util.List;

import net.atos.xtest.dao.PreguntaDao;
import net.atos.xtest.dto.FiltroPreguntasDto;
import net.atos.xtest.entity.Pregunta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class PreguntaBO {
	@Autowired
	PreguntaDao preguntaDao;
	
	public void insertar(Pregunta u) {
		preguntaDao.insertar(u);
	}
	
	public Pregunta actualizar(Pregunta u) {
		return preguntaDao.actualizar(u);
	}
	
	public void borrar(Pregunta u) {
		preguntaDao.borrar(u);
	}
	
	public List<Pregunta> buscar(FiltroPreguntasDto filtro) {
		return preguntaDao.buscar(filtro);
	}
	
}
