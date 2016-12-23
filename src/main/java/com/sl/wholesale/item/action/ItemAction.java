/** 
 * Project Name:slsys 
 * File Name:ItemAction.java 
 * Package Name:com.sl.wholesale.item.action 
 * Date:2016年11月18日下午7:43:02 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.item.action;  

import com.sl.global.action.BaseAction;
import com.sl.global.entity.BaseEntity;
import com.sl.global.service.BaseService;

/** 
 * ClassName:ItemAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月18日 下午7:43:02 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class ItemAction extends BaseAction<BaseEntity,BaseService> {
	public ItemAction() throws ClassNotFoundException{
		super(BaseEntity.class, BaseService.class);
	}
}
  