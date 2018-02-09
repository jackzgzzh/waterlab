package com.waterlab.interceptors;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.waterlab.bean.User;

public class MethodInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("------MethodInterceptor-------");
		
		String method = invocation.getProxy().getMethod();
		System.out.println("请求方法: "+method);
		
		ActionContext ac = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
		User user =  (User) ac.getSession().get("userInfo");		
		String id = request.getParameter("id");
		System.out.println(id);
		int userRole = user.getUserRole();
		
		//普通用户在操作
		if(userRole == 1 && !id.endsWith("admin")){
			return invocation.invoke();
		}else{
			//管理用户在操作
			if(userRole == 2){
				return invocation.invoke();
			}
			return "error";
		}
	}

}
