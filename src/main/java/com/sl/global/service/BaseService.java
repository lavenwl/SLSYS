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
public interface BaseService<T> {
	public List<T> list();
}
  