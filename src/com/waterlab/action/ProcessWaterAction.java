package com.waterlab.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.waterlab.bean.ProcessWater;
import com.waterlab.common.MessageFor;
import com.waterlab.service.ProcessWaterService;

public class ProcessWaterAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ProcessWaterService processWaterService;
	
	public String moveForward(){
		String id = request.getParameter("id");
		if(id.equals("processwater")){
			return "pro";
		}
		if(id.equals("processwater_admin")){
			return "pro_admin";
		}
		
		return NONE;
	}
	
	public void add(){
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();
		message.setSuccess(true);
		
		try {
			String[] processWaterValues = request.getParameterValues("processWaterList");
			for(int i = 0;i < processWaterValues.length;i++){
				ProcessWater processWater = JSON.parseObject(processWaterValues[i],ProcessWater.class);
				//System.out.println(processWater.getCheckTimeProcess());
				processWaterService.add(processWater);
			}
			
			String json = JSON.toJSONString(message);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getPageInfo(){
		response.setCharacterEncoding("utf-8");
		try {
			int limit = Integer.parseInt(request.getParameter("limit"));
			int offset = Integer.parseInt(request.getParameter("offset"));
			
			Map<String, Object> map = processWaterService.queryPageInfo(limit, offset);
			int total = (Integer) map.get("total");
			
			List<ProcessWater> processWaters =  (List<ProcessWater>) map.get("rows");
			//String processWaterStr = JSON.toJSONString(processWaters);
			String processWaterStr = JSON.toJSONStringWithDateFormat(processWaters, "yyyy-MM-dd HH:mm:ss");
			
			String json = "{\"total\":" + total + ",\"rows\":" + processWaterStr
					+ "}";
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteByList(){
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();
		message.setSuccess(true);
		
		try {
			String[] processWaterIdList = request.getParameterValues("idList");
			for(int i = 0;i < processWaterIdList.length;i++){
				int id = Integer.parseInt(processWaterIdList[i]);
				processWaterService.deleteById(id);
			}
			
			String json = JSON.toJSONString(message);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update(){
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();
		message.setSuccess(true);
		
		try {
			String processModal = request.getParameter("processModal");
			ProcessWater processWater = JSON.parseObject(processModal,ProcessWater.class);
			processWaterService.update(processWater);
			
			String json = JSON.toJSONString(message);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ProcessWaterService getProcessWaterService() {
		return processWaterService;
	}

	public void setProcessWaterService(ProcessWaterService processWaterService) {
		this.processWaterService = processWaterService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request =request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

}
