/** 
 * Project Name:slsys 
 * File Name:RoleService.java 
 * Package Name:com.sl.base.role.service 
 * Date:2016年12月10日上午11:37:00 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.portal.role.service;  

import com.sl.portal.entity.hibernate.Role;
import com.sl.portal.role.dao.RoleDao;
import com.sl.global.service.BaseService;

/** 
 * ClassName:RoleService <br/> 
 * Function: 用户角色服务层接口. <br/> 
 * Date:     2016年12月10日 上午11:37:00 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface RoleService extends BaseService<Role, RoleDao>{}
  