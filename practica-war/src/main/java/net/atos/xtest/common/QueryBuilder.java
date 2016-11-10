package net.atos.xtest.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class QueryBuilder {
	
	private StringBuilder sb = new StringBuilder();
	private Map<String, Object> params = new HashMap<String, Object>();

	public QueryBuilder(String base) {
		super();
		sb.append(base);
	}
	
	public void addConditionalJPQLClause(String jpqlClause, String paramName, Object paramValue, boolean condition) {
		if(!condition) {
			sb.append(jpqlClause);
			params.put(paramName, paramValue);
		}
	}
	
	public List excecuteQuery (EntityManager em) {
		Query q = em.createQuery(sb.toString());
		for (String paramName : params.keySet()) {
			q.setParameter(paramName, params.get(paramName));
		}
		return q.getResultList();
	}

}
