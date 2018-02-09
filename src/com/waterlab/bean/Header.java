package com.waterlab.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Header {
	private Integer id;
	private String waterFrom;
	private Date checkTime;
	private String weather;
	private int temperature;
	
	//一对多
	//private Set<SourceWater> sourceWaters = new HashSet<SourceWater>();

//	public Set<SourceWater> getSourceWaters() {
//		return sourceWaters;
//	}
//
//	public void setSourceWaters(Set<SourceWater> sourceWaters) {
//		this.sourceWaters = sourceWaters;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWaterFrom() {
		return waterFrom;
	}

	public void setWaterFrom(String waterFrom) {
		this.waterFrom = waterFrom;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	@Override
	public String toString() {
		return "id:"+id+"waterFrom:"+waterFrom+"checkTime:"+checkTime+"weather:"+weather+"temperature:"+temperature;
	}
}
