/** 
 * Project Name:slsys 
 * File Name:BaseUtil.java 
 * Package Name:com.sl.base.util 
 * Date:2016年12月19日下午2:08:39 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.global.util;  

import java.util.HashMap;
import java.util.Map;

import com.sl.global.util.StringUtil;

/** 
 * ClassName:GlobalUtil <br/> 
 * Function: 基础层工具类. <br/> 
 * Date:     2016年12月19日 下午2:08:39 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class GlobalUtil {
	public static String getService(String classString){
		return getServiceMap().get(StringUtil.lowerCase(classString));
	}
	
	private static Map<String, String> getServiceMap(){
		Map<String , String> map = new HashMap<String , String>();
		//用户角色
		map.put("role", "roleService");
		//商品类型
		map.put("goodstype", "goodsTypeService");
		//用户
		map.put("user", "userService");
		//用户详情
		map.put("userinfobypurchase", "userInfoService");
		map.put("userinfobysale", "userInfoService");
		//商家
		map.put("company", "companyService");
		//订单
		map.put("order", "orderService");
		//商品
		map.put("goods", "goodsService");
		//销售模式
		map.put("salemode", "saleModeService");
		return map;
	}
}
  