package com.sl.global.interceptor;


import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * ClassName: CheckInterceptor <br/> 
 * Function: 检查用户权限及判断是否被攻击. <br/> 
 * Reason: 通过对比用户路径检查请求是否被修改. <br/> 
 * Date: 2016年12月17日 下午3:16:49 <br/> 
 * 
 * @author laven 
 * @version  
 * @since JDK 1.6
 */
public class CheckInterceptor extends AbstractInterceptor {   

	private static final long serialVersionUID = 1L;
//	private PermissionFacade permissionFacade;

	public String intercept(ActionInvocation invocation) throws Exception {
//        ActionContext actionContext = invocation.getInvocationContext();   
//        Map session = actionContext.getSession();
//        String actionName = invocation.getProxy().getActionName();
//        String method = invocation.getProxy().getMethod();
//        int i=checkPopedom(session,actionName,method);
//        if(1==i) {
//        	return invocation.invoke(); 
//        } else if(0==i){//0 需要登录
//        	return "relogin";
//        }else{//-1 没有权限
//        	return "noauth";
//        }
		return invocation.invoke();
    }   
//	/**
//	 * 
//	 * 检查用户权限. 
//	 * 检查用户权限。
//	 * @param session
//	 * @param actionName
//	 * @param method
//	 * @return int 是否有权限
//	 */
//	private int checkPopedom(Map session, String actionName, String method) {
//		UserSession user = null != session.get(SuperConstants.USER_SESSION_KEY) ? (UserSession) session
//				.get(SuperConstants.USER_SESSION_KEY) : null;
//		return permissionFacade.checkAuth(user, actionName, method);
//	}
//
//	public void setPermissionFacade(PermissionFacade permissionFacade) {
//		this.permissionFacade = permissionFacade;
//	}

}
