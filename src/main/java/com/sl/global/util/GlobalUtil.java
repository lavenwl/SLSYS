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
		//用户类型
		map.put("goodstype", "goodsTypeService");
		return map;
	}
}
  