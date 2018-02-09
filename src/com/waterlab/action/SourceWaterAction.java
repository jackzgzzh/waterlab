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
import com.waterlab.bean.Footer;
import com.waterlab.bean.Header;
import com.waterlab.bean.SourceWater;
import com.waterlab.common.MessageFor;
import com.waterlab.service.FooterService;
import com.waterlab.service.HeaderService;
import com.waterlab.service.SourceWaterService;

public class SourceWaterAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private FooterService footerService;
	private HeaderService headerService;
	private SourceWaterService sourceWaterService;
	
	//private static Header header;
	
	public String moveForward(){
		String id = request.getParameter("id");
		if(id.equals("sourcewater")){
			return "sor";
		}
		if(id.equals("sourcewater_admin")){
			return "sor_admin";
		}
		return NONE;
	}
	
	/*
	 * 向数据库添加数据
	 */
	public void add() {
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();
		message.setSuccess(true);
		
		try {
			String headerObjStr = request.getParameter("headerObjStr");
			String footerObjStr = request.getParameter("footerObjStr");
			String sourceWaterObjStr = request.getParameter("sourceWaterObjStr");
			
			Header header = JSON.parseObject(headerObjStr, Header.class);
			SourceWater sourceWater = JSON.parseObject(sourceWaterObjStr, SourceWater.class);			
			Footer footer = JSON.parseObject(footerObjStr, Footer.class);			
						
			headerService.add(header);//调用Dao层的save方法后，Hibernate会自动向数据库添加id
			sourceWater.setSrcHeader(header);
			footerService.add(footer);
			sourceWaterService.add(sourceWater);
			
			String jsonString = JSON.toJSONString(message);
			response.getWriter().write(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 分页
	 */
	public void getPageInfo() {
		response.setCharacterEncoding("utf-8");
		try {
			int limit = Integer.parseInt(request.getParameter("limit")); // 页面大小
			int offset = Integer.parseInt(request.getParameter("offset")); // 页码

			Map<String, Object> pageInfoMap = sourceWaterService.queryPageInfo(limit, offset);
			int total = (Integer) pageInfoMap.get("total");

			List<SourceWater> sourceWaterList = (List<SourceWater>) pageInfoMap.get("rows");
			String sourceWaterData = JSON.toJSONString(sourceWaterList);

			String json = "{\"total\":" + total + ",\"rows\":" + sourceWaterData
					+ "}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/*
	 * 更新选中行的数据
	 */
	public void update(){
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();
		message.setSuccess(true);
		try {
			String sourceModal = request.getParameter("sourceModal");
			SourceWater sourceWater = JSON.parseObject(sourceModal,SourceWater.class);		
			//sourceWater.setSrcHeader(header);
			sourceWaterService.update(sourceWater);
			
			String jsonString = JSON.toJSONString(message);
			response.getWriter().write(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 批量删除所选择的数据行
	 */
	public void deleteByList() {
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();
		message.setSuccess(true);

		try {
			String[] sourceWaterIdList = request.getParameterValues("idList");
			for (int i = 0; i < sourceWaterIdList.length; i++) {
				int id = Integer.parseInt(sourceWaterIdList[i]);
				sourceWaterService.deleteById(id);
			}
			String jsonString = JSON.toJSONString(message);
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public SourceWaterService getSourceWaterService() {
		return sourceWaterService;
	}

	public void setSourceWaterService(SourceWaterService sourceWaterService) {
		this.sourceWaterService = sourceWaterService;
	}

	public HeaderService getHeaderService() {
		return headerService;
	}

	public void setHeaderService(HeaderService headerService) {
		this.headerService = headerService;
	}

	public FooterService getFooterService() {
		return footerService;
	}

	public void setFooterService(FooterService footerService) {
		this.footerService = footerService;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


}
