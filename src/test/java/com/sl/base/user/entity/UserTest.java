/** 
 * Project Name:slsys 
 * File Name:UserTest.java 
 * Package Name:com.sl.base.user.entity 
 * Date:2016年10月9日下午4:23:20 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.entity;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

/** 
 * ClassName:UserTest <br/> 
 * Function: 测试User实体类的Spring获取 <br/> 
 * Reason:   初次配置Spring框架，测试配置后是否可以获取对象 <br/> 
 * Date:     2016年10月9日 下午4:23:20 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class UserTest {
	Logger log = LoggerFactory.getLogger(UserTest.class);

	
	@Test
	public void testLogger(){
		log.debug("this is log {}", "first debug log");
	}

}
  