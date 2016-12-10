/** 
 * Project Name:slsys 
 * File Name:BaseDao.java 
 * Package Name:com.sl.global.dao 
 * Date:2016年11月15日下午1:52:44 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.global.dao;  

import java.io.Serializable;
import java.util.List;

import com.sl.base.entity.hibernate.BaseUser;
import com.sl.global.entity.QueryBean;

/** 
 * InterfaceName:BaseDao <br/> 
 * Function: Dao层基础类. <br/> 
 * Reason:   Dao层基础操作类. <br/> 
 * Date:     2016年11月15日 下午1:52:44 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface BaseDao<T, PK extends Serializable> {
	
	/**
	 * 保存对象
	 * @param object
	 * @return object
	 */
	public T save(T object);

	/**
	 * 通过ID删除对象
	 * @param id
	 */
	public void deleteById(PK id);
	
	/**
	 * 更新对象
	 * 
	 * @param object
	 */
	public void update(T object);
	
	/**
	 * 保存或更新对象
	 * @param object
	 */
	public void saveOrUpdate(T object);
	
	/**
	 * 获取当前对象里的所有记录
	 * @return List-T
	 */
	public List<T> queryAll();
	
	/**
	 * 通过ID获取对象
	 * @param id
	 * @return T
	 */
	public T queryById(PK id);
	
	/**
	 * 
	 * queryUsingAll:查询正在使用的数据（查询有效的数据，过滤删除标记的数据）. <br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public List<T> queryUsingAll();
	
	/**
	 * 
	 * queryByHql:根据HQL及条件进行查询. <br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public List<T> queryByHql(String hql, Object... args);
	
	/**
	 * 
	 * queryByQueryBean:根据查询条件查询对象列表. <br/> 
	 * 
	 * @author laven 
	 * @param queryBean 查询条件
	 * @return 查询列表
	 * @since JDK 1.6
	 */
	public List<T> queryByQueryBean(QueryBean queryBean);

}
  