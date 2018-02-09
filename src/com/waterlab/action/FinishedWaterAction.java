package com.waterlab.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.waterlab.bean.FinishedWater;
import com.waterlab.common.MessageFor;
import com.waterlab.service.FinishedWaterService;

public class FinishedWaterAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private FinishedWaterService finishedWaterService;

	public String moveForward() {
		String id = request.getParameter("id");
		if (id.equals("finishedwater")) {
			return "fih";
		}
		if (id.equals("finishedwater_admin")) {
			return "fih_admin";
		}

		return NONE;
	}

	public void add() {
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();
		message.setSuccess(true);
		try {
			String finishedWaterStr = request.getParameter("finishedWaterStr");
			FinishedWater finishedWater = JSON.parseObject(finishedWaterStr,
					FinishedWater.class);
			finishedWaterService.add(finishedWater);

			String json = JSON.toJSONString(message);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void getPageInfo() {
		response.setCharacterEncoding("utf-8");

		try {
			int limit = Integer.parseInt(request.getParameter("limit")); // 页面大小
			int offset = Integer.parseInt(request.getParameter("offset")); // 页码
			Map<String, Object> map = finishedWaterService.queryPageInfo(limit,
					offset);
			int total = (Integer) map.get("total");

			List<FinishedWater> finishedWaterList = (List<FinishedWater>) map
					.get("rows");
			String finishedWaterData = JSON.toJSONString(finishedWaterList);

			String json = "{\"total\":" + total + ",\"rows\":"
					+ finishedWaterData + "}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();
		message.setSuccess(true);
		try {
			String finishedModal = request.getParameter("finishedModal");
			FinishedWater finishedWater = JSON.parseObject(finishedModal,
					FinishedWater.class);
			finishedWaterService.update(finishedWater);

			String json = JSON.toJSONString(message);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteByList() {
		response.setCharacterEncoding("utf-8");
		MessageFor message = new MessageFor();
		message.setSuccess(true);
		try {
			String[] finishedWaterIdList = request.getParameterValues("idList");
			for (int i = 0; i < finishedWaterIdList.length; i++) {
				int id = Integer.parseInt(finishedWaterIdList[i]);
				finishedWaterService.deleteById(id);
			}
			String json = JSON.toJSONString(message);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FinishedWaterService getFinishedWaterService() {
		return finishedWaterService;
	}

	public void setFinishedWaterService(
			FinishedWaterService finishedWaterService) {
		this.finishedWaterService = finishedWaterService;
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
