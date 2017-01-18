/** 
 * Project Name:slsys 
 * File Name:CompanyServiceImpl.java 
 * Package Name:com.sl.wholesale.company.service.impl 
 * Date:2016年12月19日下午3:15:09 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.userinfo.service.impl;  

import com.sl.global.service.impl.BaseServiceImpl;
import com.sl.portal.user.service.UserService;
import com.sl.wholesale.company.service.CompanyService;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.UserInfo;
import com.sl.wholesale.goods.dao.GoodsDao;
import com.sl.wholesale.goods.service.GoodsService;
import com.sl.wholesale.goodstype.service.GoodsTypeService;
import com.sl.wholesale.userinfo.dao.UserInfoDao;
import com.sl.wholesale.userinfo.service.UserInfoService;

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
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, UserInfoDao> implements
	UserInfoService {
	/**
	 * 
	 * Creates a new instance of GoodsServiceImpl. 
	 *
	 */
	public UserInfoServiceImpl() {
		super(UserInfo.class, UserInfoDao.class);
	}
	/**
	 * 物资类型的服务类
	 */
	private UserService userService;
	private CompanyService companyService;
	
	@Override
	public UserInfo save(UserInfo userInfo) {
		Long userId = userInfo.getUser().getId();
		Long companyId = userInfo.getCompany().getId();
		//处理内部bean对象
		userInfo.setUser(userService.queryById(userInfo.getUser().getId()));
		userInfo.setCompany(companyService.queryById(companyId));
		return super.save(userInfo);
	}

	@Override
	public int update(UserInfo userInfo) {
		Long userId = userInfo.getUser().getId();
		Long companyId = userInfo.getCompany().getId();
		//处理内部bean对象
		userInfo.setUser(userService.queryById(userInfo.getUser().getId()));
		userInfo.setCompany(companyService.queryById(companyId));
		super.update(userInfo);
		return 1;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}




	
}
  