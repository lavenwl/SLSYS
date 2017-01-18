/** 
 * Project Name:slsys 
 * File Name:ItemAction.java 
 * Package Name:com.sl.wholesale.item.action 
 * Date:2016年11月18日下午7:43:02 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.price.action;  

import com.sl.global.action.BaseAction;
import com.sl.wholesale.entity.hibernate.Price;
import com.sl.wholesale.price.service.PriceService;

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
public class PriceAction extends BaseAction<Price,PriceService> {
	public PriceAction() throws ClassNotFoundException{
		super(Price.class, PriceService.class);
	}
	
	/**
	 * 新增数据时，接收页面传过来的数据
	 */
	private Price price = new Price();
	
	public String update(){
		return super.update(price);
	}
	
	public String save(){
		return super.save(price);
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
	
}
  