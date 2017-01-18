/** 
 * Project Name:slsys 
 * File Name:CompanyServiceImpl.java 
 * Package Name:com.sl.wholesale.company.service.impl 
 * Date:2016年12月19日下午3:15:09 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.goods.service.impl;  

import com.sl.global.service.impl.BaseServiceImpl;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.goods.dao.GoodsDao;
import com.sl.wholesale.goods.service.GoodsService;
import com.sl.wholesale.goodstype.service.GoodsTypeService;

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
public class GoodsServiceImpl extends BaseServiceImpl<Goods, GoodsDao> implements
		GoodsService {
	/**
	 * 
	 * Creates a new instance of GoodsServiceImpl. 
	 *
	 */
	public GoodsServiceImpl() {
		super(Goods.class, GoodsDao.class);
	}
	/**
	 * 物资类型的服务类
	 */
	private GoodsTypeService goodsTypeService;
	
	@Override
	public Goods save(Goods goods) {
		Long id = goods.getGoodsType().getId();
		//处理内部bean对象
		goods.setGoodsType(goodsTypeService.queryById(goods.getGoodsType().getId()));
		return super.save(goods);
	}

	@Override
	public int update(Goods goods) {
		Long id = goods.getGoodsType().getId();
		//处理内部bean对象
		goods.setGoodsType(goodsTypeService.queryById(goods.getGoodsType().getId()));
		super.update(goods);
		return 1;
	}

	public GoodsTypeService getGoodsTypeService() {
		return goodsTypeService;
	}

	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}
	
}
  