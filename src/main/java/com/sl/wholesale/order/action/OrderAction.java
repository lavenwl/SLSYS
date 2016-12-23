/** 
 * Project Name:slsys 
 * File Name:OrderAction.java 
 * Package Name:com.sl.wholesale.order.action 
 * Date:2016年11月18日下午7:41:36 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.order.action;  

import com.sl.global.action.BaseAction;
import com.sl.global.entity.BaseEntity;
import com.sl.global.service.BaseService;

/** 
 * ClassName:OrderAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月18日 下午7:41:36 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class OrderAction extends BaseAction<BaseEntity,BaseService> {
	public OrderAction() throws ClassNotFoundException{
		super(BaseEntity.class, BaseService.class);
	}
}
  