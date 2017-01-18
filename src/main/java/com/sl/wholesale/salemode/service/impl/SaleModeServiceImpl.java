/** 
 * Project Name:slsys 
 * File Name:CompanyServiceImpl.java 
 * Package Name:com.sl.wholesale.company.service.impl 
 * Date:2016年12月19日下午3:15:09 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.salemode.service.impl;  

import com.sl.global.service.impl.BaseServiceImpl;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.SaleMode;
import com.sl.wholesale.goods.dao.GoodsDao;
import com.sl.wholesale.goods.service.GoodsService;
import com.sl.wholesale.goodstype.service.GoodsTypeService;
import com.sl.wholesale.salemode.dao.SaleModeDao;
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
public class SaleModeServiceImpl extends BaseServiceImpl<SaleMode, SaleModeDao> implements
		SaleModeService {
	/**
	 * 
	 * Creates a new instance of GoodsServiceImpl. 
	 *
	 */
	public SaleModeServiceImpl() {
		super(SaleMode.class, SaleModeDao.class);
	}
	
}
  