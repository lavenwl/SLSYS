/** 
 * Project Name:slsys 
 * File Name:CompanyServiceImpl.java 
 * Package Name:com.sl.wholesale.company.service.impl 
 * Date:2016年12月19日下午3:15:09 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.price.service.impl;  

import com.sl.global.service.impl.BaseServiceImpl;
import com.sl.wholesale.entity.hibernate.Price;
import com.sl.wholesale.goods.service.GoodsService;
import com.sl.wholesale.price.dao.PriceDao;
import com.sl.wholesale.price.service.PriceService;
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
public class PriceServiceImpl extends BaseServiceImpl<Price, PriceDao> implements
	PriceService {
	/**
	 * 
	 * Creates a new instance of GoodsServiceImpl. 
	 *
	 */
	public PriceServiceImpl() {
		super(Price.class, PriceDao.class);
	}
	/**
	 * 物资类型的服务类
	 */
	private GoodsService goodsService;
	private SaleModeService saleModeService;
	private PriceDao priceDao;
	@Override
	public Price save(Price price) {
		Long goodsId = price.getGoods().getId();
		Long saleModeId = price.getSaleMode().getId();
		//处理内部bean对象
		price.setGoods(goodsService.queryById(goodsId));
		price.setSaleMode(saleModeService.queryById(saleModeId));
		
		return super.save(price);
	}

	@Override
	public int update(Price price) {
		Long goodsId = price.getGoods().getId();
		Long saleModeId = price.getSaleMode().getId();
		//处理内部bean对象
		price.setGoods(goodsService.queryById(goodsId));
		price.setSaleMode(saleModeService.queryById(saleModeId));
		super.update(price);
		return 1;
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

	@Override
	public double getPrice(Long goodsId, Long saleModeId) {
		double price = priceDao.getPrice(goodsId, saleModeId);
		return price;
	}

	public PriceDao getPriceDao() {
		return priceDao;
	}

	public void setPriceDao(PriceDao priceDao) {
		this.priceDao = priceDao;
	}

	
}
  