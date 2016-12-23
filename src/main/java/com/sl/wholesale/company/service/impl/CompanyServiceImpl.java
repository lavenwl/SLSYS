/** 
 * Project Name:slsys 
 * File Name:CompanyServiceImpl.java 
 * Package Name:com.sl.wholesale.company.service.impl 
 * Date:2016年12月19日下午3:15:09 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.company.service.impl;  

import com.sl.global.service.impl.BaseServiceImpl;
import com.sl.wholesale.company.dao.CompanyDao;
import com.sl.wholesale.company.service.CompanyService;
import com.sl.wholesale.entity.hibernate.Company;

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
public class CompanyServiceImpl extends BaseServiceImpl<Company, CompanyDao> implements
		CompanyService {
	/**
	 * 
	 * Creates a new instance of CompanyServiceImpl. 
	 *
	 */
	public CompanyServiceImpl() {
		super(Company.class, CompanyDao.class);
	}
}
  