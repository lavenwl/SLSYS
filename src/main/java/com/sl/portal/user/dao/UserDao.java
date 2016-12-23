/** 
 * Project Name:slsys 
 * File Name:UserDao.java 
 * Package Name:com.sl.base.user.dao 
 * Date:2016年10月9日下午5:00:23 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.portal.user.dao;  

import com.sl.portal.entity.hibernate.User;
import com.sl.global.dao.BaseDao;

/** 
 * ClassName:UserDao <br/> 
 * Function: 用户持久层 <br/> 
 * Reason:   用户相关数据库访问具体逻辑 <br/>
 * Date:     2016年10月9日 下午5:00:23 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface UserDao extends BaseDao<User, Long> {

}
  