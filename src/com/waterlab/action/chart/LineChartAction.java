package com.waterlab.action.chart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.opensymphony.xwork2.ActionSupport;
import com.waterlab.bean.FinishedWater;
import com.waterlab.bean.Header;
import com.waterlab.bean.chart.ChartBean;
import com.waterlab.common.DateTools;
import com.waterlab.service.FinishedWaterService;
import com.waterlab.service.HeaderService;

public class LineChartAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	private FinishedWaterService finishedWaterService;
	private HeaderService headerService;
	
	public String moveForward(){
		String id = request.getParameter("id");
		if(id.equals("fihbar")){
			return "fihbar";
		}
		if(id.equals("fihline")){
			return "fihline";
		}
		
		return NONE;
	}
	
	public void getData(){
		response.setCharacterEncoding("utf-8");
		List<String> lables = new ArrayList<String>();
		String weekDay = "";
		Header header = headerService.findHeader();
		if(header != null){
			weekDay = DateTools.dataToWeek(header.getCheckTime());
		}		
		lables.add(weekDay);
				
		try {
			int size = lables.size();
			if(size <= 1){
				size = 7;
			}
			List<FinishedWater> finishedWaters = finishedWaterService.getFinishedWater(size, 0);
			ChartBean lineChartBean = new ChartBean();
			lineChartBean.setFinishedWaters(finishedWaters);
			lineChartBean.setLables(lables);
			
			SimplePropertyPreFilter filter = new SimplePropertyPreFilter(FinishedWater.class, "fihHico","fihNtu");
			String jsonString = JSON.toJSONString(lineChartBean,filter);
			
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public HeaderService getHeaderService() {
		return headerService;
	}

	public void setHeaderService(HeaderService headerService) {
		this.headerService = headerService;
	}
	
	public FinishedWaterService getFinishedWaterService() {
		return finishedWaterService;
	}

	public void setFinishedWaterService(FinishedWaterService finishedWaterService) {
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
