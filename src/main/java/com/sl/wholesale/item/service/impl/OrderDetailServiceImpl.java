/** 
 * Project Name:slsys 
 * File Name:CompanyServiceImpl.java 
 * Package Name:com.sl.wholesale.company.service.impl 
 * Date:2016年12月19日下午3:15:09 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.item.service.impl;  

import com.sl.global.service.impl.BaseServiceImpl;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.Item;
import com.sl.wholesale.goods.dao.GoodsDao;
import com.sl.wholesale.goods.service.GoodsService;
import com.sl.wholesale.goodstype.service.GoodsTypeService;
import com.sl.wholesale.item.dao.ItemDao;
import com.sl.wholesale.item.service.ItemService;
import com.sl.wholesale.order.service.OrderService;
import com.sl.wholesale.salemode.service.SaleModeService;

/** 
 * ClassName:CompanyServiceImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年12月19日 下午3:15:09 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class ItemServiceImpl extends BaseServiceImpl<Item, ItemDao> implements
		ItemService {
	/**
	 * 
	 * Creates a new instance of GoodsServiceImpl. 
	 *
	 */
	public ItemServiceImpl() {
		super(Item.class, ItemDao.class);
	}
	/**
	 * 物资类型的服务类
	 */
	private OrderService orderService;
	private GoodsService goodsService;
	private SaleModeService saleModeService;
	
	@Override
	public int save(Item item) {
		Long orderId = item.getOrder().getId();
		Long goodsId = item.getGoods().getId();
		Long saleModeId = item.getSaleMode().getId();
		//处理内部bean对象
		item.setOrder(orderService.queryById(item.getOrder().getId()));
		item.setGoods(goodsService.queryById(goodsId));
		item.setSaleMode(saleModeService.queryById(saleModeId));
		super.save(item);
		return 1;
	}

	@Override
	public int update(Item item) {
		Long orderId = item.getOrder().getId();
		Long goodsId = item.getGoods().getId();
		Long saleModeId = item.getSaleMode().getId();
		//处理内部bean对象
		item.setOrder(orderService.queryById(item.getOrder().getId()));
		item.setGoods(goodsService.queryById(goodsId));
		item.setSaleMode(saleModeService.queryById(saleModeId));
		super.update(item);
		return 1;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public SaleModeService getSaleModeService() {
		return saleModeService;
	}

	public void setSaleModeService(SaleModeService saleModeService) {
		this.saleModeService = saleModeService;
	}

	
}
  