package net.atos.xtest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;





import net.atos.xtest.dto.FiltroPreguntasDto;
import net.atos.xtest.entity.Pregunta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class PreguntaDao {

	@Autowired
	@Qualifier("entityManager")
	public EntityManager em;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Pregunta u) {
		em.persist(u);
		em.flush();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Pregunta actualizar(Pregunta u) {
		Pregunta merge = em.merge(u);
		return merge;
	}
	
	public void borrar(Pregunta u) {
		Pregunta ref = em.find(Pregunta.class, u.getIdPregunta());
		em.remove(ref);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pregunta> buscar(FiltroPreguntasDto filtro) {
		StringBuilder sb = new StringBuilder("Select u from Pregunta u where 1=1 ");
		
		if (filtro.getIdPregunta() != null && !"".equals(filtro.getIdPregunta())) {
			sb.append("and upper(u.idPreg) like :idPreg");
		}
		if (filtro.getTexto() != null && !"".equals(filtro.getTexto())) {
			sb.append("and upper(u.texto) like :texto");
		}
		
		
		Query q = em.createQuery(sb.toString());
		if (filtro.getTexto() != null && !"".equals(filtro.getTexto())) {
			q.setParameter("texto", "%" + filtro.getTexto().toUpperCase() + "%");
		}
		if (filtro.getIdPregunta() != null && !"".equals(filtro.getIdPregunta())) {
			q.setParameter("idPregunta", filtro.getIdPregunta());
		}
		
		return q.getResultList();
		
	}
	
	public Pregunta buscarPreguntaPorUsernameYPassword(String username, String password) {
		Pregunta u = em.find(Pregunta.class, username);
		//TODO: VALIDAR EL PASSWORD
		return u;
	}
}

