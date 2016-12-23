package com.sl.global.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 
 * ClassName: SpringContextUtil <br/> 
 * Function: spring生成对象的工具类. <br/> 
 * Date: 2016年12月16日 下午5:23:50 <br/> 
 * 
 * @author laven 
 * @version  
 * @since JDK 1.6
 */
public class SpringContextUtil implements ApplicationContextAware{
	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;  
	}
	 
	public static Object getBean(String name) throws BeansException {  
        return applicationContext.getBean(name);  
    } 
	
	@SuppressWarnings("unchecked")
	public static Object getBean(String name, Class arg1) throws BeansException {  
	        return applicationContext.getBean(name, arg1);  
	} 

	
}
