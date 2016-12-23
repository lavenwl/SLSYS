/** 
 * Project Name:slsys 
 * File Name:GoodsAction.java 
 * Package Name:com.sl.wholesale.goods.action 
 * Date:2016年11月18日下午7:36:50 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.goods.action;  

import com.sl.global.action.BaseAction;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.goods.service.GoodsService;

/** 
 * ClassName:GoodsAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月18日 下午7:36:50 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class GoodsAction extends BaseAction<Goods,GoodsService>{
	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = -4431445486861351032L;
	/**
	 * 
	 * Creates a new instance of GoodsAction. 
	 * 
	 * @throws ClassNotFoundException
	 */
	public GoodsAction() throws ClassNotFoundException{
		super(Goods.class, GoodsService.class);
	}
	/**
	 * 新增数据时，接收页面传过来的数据
	 */
	private Goods goods = new Goods();
	
	public String update(){
		return super.update(goods);
	}
	
	public String save(){
		return super.save(goods);
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
}
  