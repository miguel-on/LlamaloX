package net.atos.xtest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.atos.xtest.dto.FiltroTestsDto;
import net.atos.xtest.entity.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class TestDao {
	@Autowired
	@Qualifier("entityManager")
	public EntityManager em;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Test u) {
		em.persist(u);
		em.flush();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Test actualizar(Test u) {
		Test merge = em.merge(u);
		return merge;
	}
	
	public void borrar(Test u) {
		Test ref = em.find(Test.class, u.getIdTest());
		em.remove(ref);
	}
	
	@SuppressWarnings("unchecked")
	public List<Test> buscar(FiltroTestsDto filtro) {
		StringBuilder sb = new StringBuilder("Select u from Test u where 1=1 ");
		
		if (filtro.getNombre() != null && !"".equals(filtro.getNombre())) {
			sb.append("and upper(u.nombre) like :nombre");
		}
		if (filtro.getNumeroOportunidades() != null && !"".equals(filtro.getNumeroOportunidades())) {
			sb.append("and upper(u.numeroOportunidades) like :numeroOportunidades");
		}
		
		if (filtro.getFechaInicioDesde() != null && !"".equals(filtro.getFechaInicioDesde())) {
			sb.append("and upper(u.getFechaInicioDesde) >=  :fechaInicioDesde");
		}
		if (filtro.getFechaInicioHasta() != null && !"".equals(filtro.getFechaInicioHasta())) {
			sb.append("and upper(u.getFechaInicioHasta) <=  :fechaInicioHasta");
		}
		if (filtro.getFechaFinDesde() != null && !"".equals(filtro.getFechaFinDesde())) {
			sb.append("and upper(u.getFechaFinDesde) >=  :fechaFinDesde");
		}
		if (filtro.getFechaFinHasta() != null && !"".equals(filtro.getFechaFinHasta())) {
			sb.append("and upper(u.getFechaFinHasta) <=  :fechaFinHasta");
		}
		
		
		
		Query q = em.createQuery(sb.toString());
		if (filtro.getNombre() != null && !"".equals(filtro.getNombre())) {
			q.setParameter("nombre", "%" + filtro.getNombre().toUpperCase() + "%");
		}
		if (filtro.getNumeroOportunidades() != null && !"".equals(filtro.getNumeroOportunidades())) {
			q.setParameter("numeroOportunidades",  filtro.getNumeroOportunidades());
		}
		
		if (filtro.getFechaInicioDesde() != null && !"".equals(filtro.getFechaInicioDesde())) {
			q.setParameter("fechaInicioDesde", filtro.getFechaInicioDesde());
		}
		if (filtro.getFechaInicioHasta() != null && !"".equals(filtro.getFechaInicioHasta())) {
			q.setParameter("fechaInicioHasta", filtro.getFechaInicioHasta());
		}
		if (filtro.getFechaFinDesde() != null && !"".equals(filtro.getFechaFinDesde())) {
			q.setParameter("fechaFinDesde", filtro.getFechaFinDesde());
		}
		if (filtro.getFechaFinHasta() != null && !"".equals(filtro.getFechaFinHasta())) {
			q.setParameter("fechaFinHasta", filtro.getFechaFinHasta());
		}
		
		return q.getResultList();
		
	}
	
	/*public Test buscarTestPorUsernameYPassword(String username, String password) {
		Test u = em.find(Test.class, username);
		//TODO: VALIDAR EL PASSWORD
		return u;
	}*/
}