package net.atos.xtest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.atos.xtest.dto.FiltroUsuariosDto;
import net.atos.xtest.entity.Rol;
import net.atos.xtest.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioDAO {

	@Autowired
	@Qualifier("entityManager")
	public EntityManager em;

	@Transactional(propagation = Propagation.REQUIRED)
	public void insertar(Usuario u) {
		em.persist(u);
		em.flush();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Usuario actualizar(Usuario u) {
		Usuario merge = em.merge(u);
		return merge;
	}
	
	public List<Rol> leerRoles() {
		Query q = em.createQuery("select r from Rol r");
		return q.getResultList();
	}

	public void borrar(Usuario u) {
		Usuario ref = em.find(Usuario.class, u.getIdUsuario());
		em.remove(ref);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscar(FiltroUsuariosDto filtro) {

		QueryBuilder qb = new QueryBuilder("Select u from Usuario u join fetch u.rolBean r where 1=1");
		
		qb.addConditionalJPQLClause(" and upper(u.nombre) like :nombre", "nombre", "%"+filtro.getNombre().toUpperCase()+"%", Utils.isNullOrBlank(filtro.getNombre()));
		qb.addConditionalJPQLClause(" and upper(u.primerApellido) like :primerApellido", "primerApellido", "%"+filtro.getPrimerApellido().toUpperCase()+"%", Utils.isNullOrBlank(filtro.getPrimerApellido()));
		qb.addConditionalJPQLClause(" and upper(u.segundoApellido) like :segundoApellido", "segundoApellido", "%"+filtro.getSegundoApellido().toUpperCase()+"%", Utils.isNullOrBlank(filtro.getSegundoApellido()));
		qb.addConditionalJPQLClause(" and upper(u.idUsuario) like :idUsuario", "idUsuario", "%"+filtro.getIdUsuario().toUpperCase()+"%", Utils.isNullOrBlank(filtro.getIdUsuario()));
		qb.addConditionalJPQLClause(" and upper(u.email) like :email", "email", "%"+filtro.getEmail().toUpperCase()+"%", Utils.isNullOrBlank(filtro.getEmail()));
		qb.addConditionalJPQLClause(" and upper(u.telefono) like :telefono", "telefono", "%"+filtro.getTelefono().toUpperCase()+"%", Utils.isNullOrBlank(filtro.getTelefono()));
		qb.addConditionalJPQLClause(" and upper(u.fechaAlta) like :fechaAlta", "fechaAlta", "%"+filtro.getFechaAlta().toUpperCase()+"%", Utils.isNullOrBlank(filtro.getFechaAlta()));
		qb.addConditionalJPQLClause(" and upper(u.fechaBaja) like :fechaBaja", "fechaBaja", "%"+filtro.getFechaBaja().toUpperCase()+"%", Utils.isNullOrBlank(filtro.getFechaBaja()));
		qb.addConditionalJPQLClause(" and upper(u.nif) like :nif", "nif", "%"+filtro.getNif().toUpperCase()+"%", Utils.isNullOrBlank(filtro.getNif()));
				
		return qb.excecuteQuery(em);

	}

	public Usuario buscarUsuarioPorUsernameYPassword(String username,
			String password) {
		Usuario u = em.find(Usuario.class, username);
		// TODO: VALIDAR EL PASSWORD
		return u;
	}

}
