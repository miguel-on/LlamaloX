package net.atos.xtest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.atos.xtest.dto.FiltroRolDto;
import net.atos.xtest.entity.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional(propagation=Propagation.REQUIRED)
public class RolDAO {
	
	@Autowired
	@Qualifier("entityManager")
	public static EntityManager em;
	
	@SuppressWarnings("unchecked")
	public static List<Rol> leerRoles() {
		Query q = em.createQuery("select r from Rol r");
		return q.getResultList();
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Rol r) {
		em.persist(r);
		em.flush();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Rol actualizar(Rol r) {
		Rol merge = em.merge(r);
		return merge;
	}
	
	public void borrar(Rol r) {
		Rol ref = em.find(Rol.class, r.getNombre());
		em.remove(ref);
	}
	
	@SuppressWarnings("unchecked")
	public List<Rol> buscar(FiltroRolDto filtro) {
		
		QueryBuilder qb = new QueryBuilder("Select r from Rol r join fetch r.modulos m where 1=1");
		
		qb.addConditionalJPQLClause(" and upper(r.nombre) like :nombre", "nombre", "%"+filtro.getNombre().toUpperCase()+"%", Utils.isNullOrBlank(filtro.getNombre()));
		qb.addConditionalJPQLClause(" and upper(r.descripcion) like :descripcion", "descripcion", "%"+filtro.getDescripcion().toUpperCase()+"%", Utils.isNullOrBlank(filtro.getDescripcion()));
		qb.addConditionalJPQLClause(" and upper(r.baja) like :baja", "baja", "%"+filtro.getBaja().toString()+"%", Utils.isNullOrBlank(filtro.getBaja().toString()));
		qb.addConditionalJPQLClause(" and upper(r.modulos) like :modulos", "modulos", "%"+filtro.getModulo().toString()+"%", Utils.isNullOrBlank(filtro.getModulo().toString()));
		
				
		return qb.excecuteQuery(em);
		
		/*
		StringBuilder sb = new StringBuilder("Select r from Rol r left join fetch r.modulos m where 1=1 ");
		
		if (filtro.getNombre() != null && !"".equals(filtro.getNombre())) {
			sb.append("and upper(r.nombre) like :nombre");
		}
		if (filtro.getDescripcion() != null && !"".equals(filtro.getDescripcion())) {
			sb.append("and upper(r.descripcion) like :descripcion");
		}
		if (filtro.getBaja() != null && !"".equals(filtro.getBaja())) {
			sb.append("and upper(r.baja) like :baja");
		}
		if (filtro.getModulo() != null && !"".equals(filtro.getModulo())) {
			sb.append("and upper(m.nombre) like :nombre");
		}
		
		Query q = em.createQuery(sb.toString());
		if (filtro.getNombre() != null && !"".equals(filtro.getNombre())) {
			q.setParameter("nombre", "%" + filtro.getNombre().toUpperCase() + "%");
		}
		if (filtro.getDescripcion() != null && !"".equals(filtro.getDescripcion())) {
			q.setParameter("descripcion", "%" + filtro.getDescripcion().toUpperCase() + "%");
		}
		if (filtro.getBaja() != null && !"".equals(filtro.getBaja())) {
			q.setParameter("baja", "%" + filtro.getBaja() + "%");
		}
		if (filtro.getModulo() != null && !"".equals(filtro.getModulo())) {
			q.setParameter("nombre", "%" + filtro.getModulo() + "%");
		}
		
		return q.getResultList();
		*/
	}
	
	

}
