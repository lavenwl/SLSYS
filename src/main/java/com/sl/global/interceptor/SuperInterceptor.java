package com.sl.global.interceptor;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * ClassName: SuperInterceptor <br/> 
 * Function: 全局拦截器，分析路径. <br/> 
 * Reason: 处理路径，封装路径信息，方便处理日志，及页面显示功能. <br/> 
 * Date: 2016年12月17日 下午3:21:40 <br/> 
 * 
 * @author laven 
 * @version  
 * @since JDK 1.6
 */
public class SuperInterceptor extends AbstractInterceptor {   
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = invocation.getProxy().getActionName();
		Map session = invocation.getInvocationContext().getSession();
		if(StringUtils.isNotBlank(actionName)) {
			session.put("actionName", actionName);
		}
		
//        ActionContext actionContext = invocation.getInvocationContext();
//        HttpServletRequest request = ServletActionContext.getRequest();
//        Map session = actionContext.getSession();
//        if(null!=session){//处理session信息
//        	setURL(invocation);
//        }
        return invocation.invoke(); 
    }   
  
//   /**
//    * 
//    * setURL:解析请求URL. <br/> 
//    * 
//    * @author laven 
//    * @param invocation 
//    * @since JDK 1.6
//    */
//    @SuppressWarnings("unchecked")
//	private void setURL(ActionInvocation invocation) {   
//        StringBuffer url = new StringBuffer();
//        String namespace = invocation.getProxy().getNamespace();
//        if(StringUtils.isNotBlank(namespace) && !namespace.equals("/")) {
//            url.append(namespace);
//        }
//        String actionName = invocation.getProxy().getActionName();
//        if(StringUtils.isNotBlank(actionName)) {
//            url.append("/").append(actionName);
//        }
//        String method = invocation.getProxy().getMethod();
//        if(StringUtils.isNotBlank(method)) {
//            url.append("!").append(method);
//        }
//        Map map= invocation.getProxy().getInvocation().getInvocationContext().getParameters();
//        if(null==map){
//        	map=new HashMap();
//        }
//        url.append(".do");
//        map.put("actionEntity.actionName", new String[]{actionName});
//        map.put("actionEntity.methodName", new String[]{method});
//        map.put("actionEntity.actionUrl", new String[]{url.toString()});
//        map.put("actionEntity.namespace", new String[]{namespace});
//        invocation.getProxy().getInvocation().getInvocationContext().setParameters(map);
//    }
}
