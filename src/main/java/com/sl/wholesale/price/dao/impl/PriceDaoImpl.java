/** 
 * Project Name:slsys 
 * File Name:CompanyDaoImpl.java 
 * Package Name:com.sl.wholesale.company.dao.impl 
 * Date:2016年12月19日下午3:11:05 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.price.dao.impl;  

import java.util.List;

import com.sl.global.dao.HibernateDao;
import com.sl.wholesale.entity.hibernate.Price;
import com.sl.wholesale.price.dao.PriceDao;

/** 
 * ClassName:CompanyDaoImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年12月19日 下午3:11:05 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class PriceDaoImpl extends HibernateDao<Price, Long> implements PriceDao {

	public PriceDaoImpl() {
		super(Price.class);
	}

	@Override
	public double getPrice(Long goodsId, Long saleModeId) {
		String hql = " from  Price a where a.goods.id=" + goodsId + " and a.saleMode.id=" + saleModeId + " and a.state=1";
		List<Price> list = queryByHql(hql, null);
		if(list != null && list.size() > 0){
			return list.get(0).getMoney();
		}else{
			//抛出异常，（提醒店长维护价格）
			return -1;
		}
	}

}
  