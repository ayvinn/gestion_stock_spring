package com.stock.mvc.DAO.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.stock.mvc.DAO.IGenericDAO;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;
@SuppressWarnings("unchecked")
public class GenericDaoImp<E> implements IGenericDAO<E> {
	@PersistenceContext
	EntityManager em;
	
	private Class<E> type;
	
	
	
	public Class<E> getType() {
		return type;
	}

	public GenericDaoImp() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt= (ParameterizedType) t;
		type =(Class<E>) pt.getActualTypeArguments()[0];
	}

	@Override
	public E save(E entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public E update(E entity) {
		return em.merge(entity);
		 
	}

	@Override
	public List<E> selectAll() {
		Query query = em.createQuery("select t from"+ type.getSimpleName() + "t");
		
		return query.getResultList();
	}

	@Override
	public List<E> selectAll(String sortField, String sort) {
		
		Query query = em.createQuery("select t from"+ type.getSimpleName() + "t oder by "+ sortField + " " + sort);
		
		return query.getResultList();
	}

	@Override
	public E getById(Long id) {
		return em.find(type, id);
	}

	@Override
	public void remove(Long id) {
		E tab = em.getReference(type, id);
		em.remove(tab);
	}

	@Override
	public E findOne(String paramName, Object paramValue) {
		
		Query query = em.createQuery("select t from"+ type.getSimpleName() + "t where" + paramName +"= :x ");
		query.setParameter(paramName, paramValue);
		if (query.getResultList().size()> 0) {
			return (E) query.getResultList().get(0);
		}
		return null;
		//return query.getResultList().size() > 0 ? (E) query.getResultList().get(0) :null; 
	}

	@Override
	public E findOne(String[] paraName, Object[] parmvalue) {
		
		if(paraName.length != parmvalue.length)
		return null;
		
		String queryString = "select e from"+type.getSimpleName()+"e where";
		int len = paraName.length;
		for (int i = 0 ; i < len ; i++) {
			queryString += "e." + paraName[i] + "= :x" +i;
			if((i+1)< len ) {
				queryString += "and";
			}
		}
		Query query=  em.createQuery(queryString);
		for(int i=0; i< parmvalue.length;i++) {
			query.setParameter("x"+ i, parmvalue[i] );
		
		}
		return query.getResultList().size() > 0 ? (E) query.getResultList().get(0) :null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		Query query = em.createQuery("select t from"+ type.getSimpleName() + "t where" + paramName +"= :x ");
		query.setParameter(paramName, paramValue);
		if (query.getResultList().size()> 0) {
			return ((Long) query.getSingleResult()).intValue();
		}
		return 0;
	}

}
