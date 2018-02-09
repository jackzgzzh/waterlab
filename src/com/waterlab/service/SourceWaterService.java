package com.waterlab.service;

import java.util.Map;

import com.waterlab.bean.SourceWater;

public interface SourceWaterService {
	
	public void add(SourceWater sourceWater);
	
	public SourceWater getById(int id);
	
	public void update(SourceWater sourceWater);
	
	public void delete(SourceWater sourceWater);
	
	public void deleteById(int id);
	
	public Map<String,Object> queryPageInfo(int limit,int offset);
	
}
