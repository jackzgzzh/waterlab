package com.waterlab.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.waterlab.bean.User;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("----LoginInterceptor----");
		//String name = invocation.getInvocationContext().getName();
		String name = invocation.getProxy().getMethod();
		System.out.println("请求方法: "+name);
				
		ActionContext ac = invocation.getInvocationContext();
		Map<String, Object> session = ac.getSession();
		
		User user = (User) session.get("userInfo");
		
		if(user != null){
			return invocation.invoke();
		}else{
			return "login";
		}
	}


}
