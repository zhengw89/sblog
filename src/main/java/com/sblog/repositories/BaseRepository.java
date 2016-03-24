package com.sblog.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public abstract class BaseRepository<T> extends HibernateDaoSupport {

	private Class entityClass;

	protected BaseRepository(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
		
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		entityClass = (Class)params[0];
	}
	
	protected T getByKey(Serializable key){
		return (T)getHibernateTemplate().get(entityClass, key);
	}
	
	public boolean create(T obj){
		getHibernateTemplate().save(obj);
		return true;
	}
	
	public boolean update(T obj) {
		getHibernateTemplate().update(obj);
		return true;
	}
	
	public boolean delete(String id) {
		return this.delete(this.getByKey(id));
	}
	
	public boolean delete(T obj){
		getHibernateTemplate().delete(obj);
		return true;
	}
	
	protected Query createHibernateQuery(String queryString) {
		return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
	}
	
}
