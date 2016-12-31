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
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.Item;
import com.sl.wholesale.item.service.ItemService;

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
public class ItemAction extends BaseAction<Item,ItemService> {
	public ItemAction() throws ClassNotFoundException{
		super(Item.class, ItemService.class);
	}
	
	/**
	 * 新增数据时，接收页面传过来的数据
	 */
	private Item item = new Item();
	
	public String update(){
		return super.update(item);
	}
	
	public String save(){
		return super.save(item);
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
  