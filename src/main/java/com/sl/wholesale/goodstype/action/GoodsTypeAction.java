/** 
 * Project Name:slsys 
 * File Name:GoodsTypeAction.java 
 * Package Name:com.sl.wholesale.goodstype.action 
 * Date:2016年11月18日下午7:38:47 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.goodstype.action;  

import com.sl.global.action.BaseAction;
import com.sl.wholesale.entity.hibernate.GoodsType;
import com.sl.wholesale.goodstype.service.GoodsTypeService;

/** 
 * ClassName:GoodsTypeAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月18日 下午7:38:47 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class GoodsTypeAction extends BaseAction<GoodsType,GoodsTypeService> {
	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = -390780281560026383L;
	/**
	 * 
	 * Creates a new instance of GoodsTypeAction. 
	 * 
	 * @throws ClassNotFoundException
	 */
	public GoodsTypeAction() throws ClassNotFoundException{
		super(GoodsType.class, GoodsTypeService.class);
	}
	/**
	 * 新增数据时，接收页面传递过来的值
	 */
	private GoodsType goodsType = new GoodsType();
	
	public String update(){
		return super.update(goodsType);
	}
	
	public String save(){
		return super.save(goodsType);
	}
	
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

}
  