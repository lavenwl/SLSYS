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
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.SaleMode;
import com.sl.wholesale.salemode.service.SaleModeService;

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
public class SaleModeAction extends BaseAction<SaleMode,SaleModeService> {
	public SaleModeAction() throws ClassNotFoundException{
		super(SaleMode.class, SaleModeService.class);
	}
	/**
	 * 新增数据时，接收页面传过来的数据
	 */
	private SaleMode saleMode = new SaleMode();
	
	public String update(){
		return super.update(saleMode);
	}
	
	public String save(){
		return super.save(saleMode);
	}

	public SaleMode getSaleMode() {
		return saleMode;
	}

	public void setSaleMode(SaleMode saleMode) {
		this.saleMode = saleMode;
	}
	
}
  