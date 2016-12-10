/** 
 * Project Name:slsys 
 * File Name:RoleService.java 
 * Package Name:com.sl.base.role.service 
 * Date:2016年12月10日上午11:37:00 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.role.service;  

import java.util.List;

import com.sl.base.entity.hibernate.BaseRole;
import com.sl.global.entity.QueryBean;

/** 
 * ClassName:RoleService <br/> 
 * Function: 用户角色服务层接口. <br/> 
 * Date:     2016年12月10日 上午11:37:00 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface RoleService {
	
	/**
	 * 
	 * list:查询所有的用户. <br/> 
	 * 
	 * @author laven 
	 * @return 所有用户
	 * @since JDK 1.6
	 */
	public List<BaseRole> list();
	
	/**
	 * 
	 * query:根据条件查询用户. <br/> 
	 * 
	 * @author laven 
	 * @param queryUserBean 查询条件
	 * @return 一定条件下查询到的用户
	 * @since JDK 1.6
	 */
	public List<BaseRole> query(QueryBean queryRoleBean);
	
	/**
	 * 
	 * queryById:根据ID查询唯一对象. <br/> 
	 * 
	 * @author laven 
	 * @param id
	 * @return 
	 * @since JDK 1.6
	 */
	public BaseRole queryById(long id);
	
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
	 * @param baseUser
	 * @return 
	 * @since JDK 1.6
	 */
	public int save(BaseRole baseRole);
}
  