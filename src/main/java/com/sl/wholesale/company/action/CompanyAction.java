/** 
 * Project Name:slsys 
 * File Name:CompanyAction.java 
 * Package Name:com.sl.wholesale.company.action 
 * Date:2016年11月18日下午7:43:55 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.company.action;  

import com.sl.global.action.BaseAction;
import com.sl.wholesale.company.service.CompanyService;
import com.sl.wholesale.entity.hibernate.Company;

/** 
 * ClassName:CompanyAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月18日 下午7:43:55 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class CompanyAction extends BaseAction<Company,CompanyService>{

	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = 4425982496856503423L;
	/**
	 * 
	 * Creates a new instance of CompanyAction. 
	 * 
	 * @throws ClassNotFoundException
	 */
	public CompanyAction() throws ClassNotFoundException{
		super(Company.class, CompanyService.class);
	}
	/**
	 * 新增数据时接收页面传来的数据
	 */
	private Company company = new Company();
	
	public String update(){
		return super.update(company);
	}
	
	public String save(){
		return super.save(company);
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
  