/** 
 * Project Name:slsys 
 * File Name:UserService.java 
 * Package Name:com.sl.base.user.service 
 * Date:2016年10月10日下午5:10:51 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.service;  

import java.util.List;

import com.sl.base.entity.hibernate.BaseUser;
import com.sl.global.entity.QueryBean;
import com.sl.global.service.BaseService;

/** 
 * ClassName:UserService <br/> 
 * Function: 用户服务层. <br/> 
 * Reason:   用户相关逻辑处理类. <br/> 
 * Date:     2016年10月10日 下午5:10:51 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface UserService {
	
	/**
	 * 
	 * list:查询所有的用户. <br/> 
	 * 
	 * @author laven 
	 * @return 所有用户
	 * @since JDK 1.6
	 */
	public List<BaseUser> list();
	
	/**
	 * 
	 * query:根据条件查询用户. <br/> 
	 * 
	 * @author laven 
	 * @param queryUserBean 查询条件
	 * @return 一定条件下查询到的用户
	 * @since JDK 1.6
	 */
	public List<BaseUser> query(QueryBean queryUserBean);
	
	/**
	 * 
	 * queryById:根据ID查询唯一对象. <br/> 
	 * 
	 * @author laven 
	 * @param id
	 * @return 
	 * @since JDK 1.6
	 */
	public BaseUser queryById(long id);
	
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
	public int save(BaseUser baseUser);

	/**
	 * 
	 * update:更新对象. <br/> 
	 * 
	 * @author laven 
	 * @param baseUser
	 * @return 
	 * @since JDK 1.6
	 */
	public int update(BaseUser baseUser);
}
  