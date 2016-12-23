/** 
 * Project Name:slsys 
 * File Name:CompanyDaoImpl.java 
 * Package Name:com.sl.wholesale.company.dao.impl 
 * Date:2016年12月19日下午3:11:05 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.goods.dao.impl;  

import com.sl.global.dao.HibernateDao;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.goods.dao.GoodsDao;

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
public class GoodsDaoImpl extends HibernateDao<Goods, Long> implements GoodsDao {

	public GoodsDaoImpl() {
		super(Goods.class);
	}

}
  