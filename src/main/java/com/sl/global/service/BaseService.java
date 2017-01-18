/** 
 * Project Name:slsys 
 * File Name:BaseService.java 
 * Package Name:com.sl.global.service 
 * Date:2016年11月21日下午1:01:50 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.global.service;  

import java.util.List;

import com.sl.global.entity.QueryBean;

/** 
 * ClassName:BaseService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月21日 下午1:01:50 <br/> 
 * @author   laven 
 * @version   
 * @param <T>
 * @since    JDK 1.6 
 * @see       
 */
public interface BaseService<E, D> {

	
	/**
	 * 
	 * list:查询所有的用户. <br/> 
	 * 
	 * @author laven 
	 * @return 所有用户
	 * @since JDK 1.6
	 */
	public List<E> list();
	
	/**
	 * 
	 * query:根据条件查询用户. <br/> 
	 * 
	 * @author laven 
	 * @param queryBean 查询条件
	 * @return 一定条件下查询到的用户
	 * @since JDK 1.6
	 */
	public List<E> query(QueryBean queryBean);
	
	/**
	 * 
	 * queryById:根据ID查询唯一对象. <br/> 
	 * 
	 * @author laven 
	 * @param id
	 * @return 
	 * @since JDK 1.6
	 */
	public E queryById(long id);
	
	/**
	 * 
	 * deleteById:根据ID删除唯一对象. <br/> 
	 * 
	 * @author laven 
	 * @param id 
	 * @return 
	 * @since JDK 1.6
	 */
	public int deleteById(long id);
	/**
	 * 
	 * save:保存一个用户对象. <br/> 
	 * 
	 * @author laven 
	 * @param entity
	 * @return 
	 * @since JDK 1.6
	 */
	public E save(E entity);

	/**
	 * 
	 * update:更新对象. <br/> 
	 * 
	 * @author laven 
	 * @param entity
	 * @return 
	 * @since JDK 1.6
	 */
	public int update(E entity);

	public int update(String contentStr);

}
  