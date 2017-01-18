/** 
 * Project Name:slsys 
 * File Name:HibernateDao.java 
 * Package Name:com.sl.global.dao 
 * Date:2016年11月15日下午2:07:10 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.global.dao;  

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import com.sl.global.entity.QueryBean;

/** 
 * ClassName:HibernateDao <br/> 
 * Function: 持久层hibernate实现基类. <br/> 
 * Reason:   持久层hibernate实现基类. <br/> 
 * Date:     2016年11月15日 下午2:07:10 <br/> 
 * @author   laven 
 * @version   
 * @param <T>
 * @param <PK>
 * @since    JDK 1.6 
 * @see       
 */
public class HibernateDao<E, PK extends Serializable> extends HibernateDaoSupport implements BaseDao<E, PK> {
	private Class<E> persistentClass;
	
	/**
	 * 构造
	 * @param persistentClass 泛型类参数
	 */
	public HibernateDao(final Class<E> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E save(E object) {
		Object reobj = super.getHibernateTemplate().save(object);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
		return queryById((PK) reobj);
	}

	@Override
	public void deleteById(PK id) {
		super.getHibernateTemplate().delete(this.queryById(id));
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

	@Override
	public void update(E object) {
		super.getHibernateTemplate().update(object);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

	@Override
	public void saveOrUpdate(E object) {
		this.getHibernateTemplate().saveOrUpdate(object);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

	@Override
	public List<E> queryAll() {
		List<E> list = super.getHibernateTemplate().loadAll(this.persistentClass);
		this.getHibernateTemplate().clear();
		return list;
	}

	@Override
	public E queryById(PK id) {
		E entity = (E) super.getHibernateTemplate().get(this.persistentClass, id);
		
		if (entity == null) {
			throw new ObjectRetrievalFailureException(this.persistentClass, id);
		}
		return entity;
	}

	@Override
	public List<E> queryUsingAll() {
		String hql = " from " + this.persistentClass.getName() + " a where a.state<>0";
		return queryByHql(hql, null);
	}

	@Override
	public List<E> queryByHql(String hql, Object... args) {
		Session s = currentSession();
		Query q = s.createQuery(hql);
		if(hql.trim().startsWith("select")){
			q.setResultTransformer(Transformers.aliasToBean(this.persistentClass));
		}
		if(null != args){
			for(int i = 0; i < args.length; i++){
				q.setParameter(i, args[i]);
			}
		}
		List list = q.list();
		s.clear();
		return list;
	}

	public int queryCountByHql(String hql, Object... args){
		Query q = currentSession().createQuery(hql);
		if(null != args){
			for(int i = 0; i < args.length; i++){
				q.setParameter(i, args[i]);
			}
		}
		Long sum = (Long) q.uniqueResult();
		
		return Integer.parseInt(String.valueOf(Long.valueOf(sum)));
	}
	@Override
	public List<E> queryByQueryBean(QueryBean queryBean) {
		// TODO Auto-generated method stub
		return null;
	}


}
  