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
public class HibernateDao<T, PK extends Serializable> extends HibernateDaoSupport implements BaseDao<T, PK> {
	private Class<T> persistentClass;
	
	/**
	 * 构造
	 * @param persistentClass 泛型类参数
	 */
	public HibernateDao(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T save(T object) {
		Object reobj = super.getHibernateTemplate().save(object);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
		return (T) reobj;
	}

	@Override
	public void deleteById(PK id) {
		super.getHibernateTemplate().delete(this.queryById(id));
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

	@Override
	public void update(T object) {
		super.getHibernateTemplate().update(object);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

	@Override
	public void saveOrUpdate(T object) {
		this.getHibernateTemplate().saveOrUpdate(object);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

	@Override
	public List<T> queryAll() {
		List<T> list = super.getHibernateTemplate().loadAll(this.persistentClass);
		this.getHibernateTemplate().clear();
		return list;
	}

	@Override
	public T queryById(PK id) {
		T entity = (T) super.getHibernateTemplate().get(this.persistentClass, id);
		
		if (entity == null) {
			throw new ObjectRetrievalFailureException(this.persistentClass, id);
		}
		return entity;
	}

	@Override
	public List<T> queryUsingAll() {
		String hql = " from " + this.persistentClass.getName() + " a where a.state=?";
		return queryByHql(hql, 1);
	}

	@Override
	public List<T> queryByHql(String hql, Object... args) {
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

	@Override
	public List<T> queryByQueryBean(QueryBean queryBean) {
		// TODO Auto-generated method stub
		return null;
	}


}
  