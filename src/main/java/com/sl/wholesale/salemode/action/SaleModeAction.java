/** 
 * Project Name:slsys 
 * File Name:SaleModeAction.java 
 * Package Name:com.sl.wholesale.salemode.action 
 * Date:2016年11月18日下午7:45:15 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.salemode.action;  

import com.sl.global.action.BaseAction;
import com.sl.global.entity.BaseEntity;
import com.sl.global.service.BaseService;

/** 
 * ClassName:SaleModeAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月18日 下午7:45:15 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class SaleModeAction extends BaseAction<BaseEntity,BaseService> {
	public SaleModeAction() throws ClassNotFoundException{
		super(BaseEntity.class, BaseService.class);
	}
}
  