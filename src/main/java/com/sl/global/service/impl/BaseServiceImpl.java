/** 
 * Project Name:slsys 
 * File Name:BaseServiceImpl.java 
 * Package Name:com.sl.global.service.impl 
 * Date:2016年11月21日下午1:03:25 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.global.service.impl;  

import java.util.List;

import com.sl.global.dao.BaseDao;
import com.sl.global.entity.BaseEntity;
import com.sl.global.entity.QueryBean;
import com.sl.global.service.BaseService;
import com.sl.global.util.SpringContextUtil;
import com.sl.global.util.StringUtil;
import com.sl.wholesale.entity.hibernate.Order;

/** 
 * ClassName:BaseServiceImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月21日 下午1:03:25 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class BaseServiceImpl<E extends BaseEntity, D extends BaseDao<E, Long>> implements BaseService<E, D> {

	private D baseDao;
	private Class<E> baseEntityClass;
	private Class<D> baseDaoClass;
	public BaseServiceImpl(Class<E> baseEntityClass, Class<D> baseDaoClass){
			this.baseEntityClass = baseEntityClass;
			this.baseDaoClass = baseDaoClass;
	}

	@Override
	public List<E> list() {
		return getBaseDao().queryUsingAll();
	}
	
	@Override
	public List<E> query(QueryBean queryBean) {
		return getBaseDao().queryByQueryBean(queryBean);
	}

	@Override
	public E queryById(long id) {
		return getBaseDao().queryById(id);
	}

	@Override
	public int deleteById(long id) {
		E entity = queryById(id);
		entity.setState(0);
		getBaseDao().update(entity);
		return 1;
	}

	@Override
	public E save(E entity) {
		return getBaseDao().save(entity);
	}

	@Override
	public int update(E entity) {
		getBaseDao().update(entity);
		return 1;
	}

	public int update(String contentStr){
		return 1;
	}

	public D getBaseDao(){
		if(baseDao == null){
			baseDao = (D) SpringContextUtil.getBean(StringUtil.lowerFirstChar(baseDaoClass.getSimpleName()));
		}
		return baseDao;
	}
	
}
  