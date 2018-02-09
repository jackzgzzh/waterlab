package com.waterlab.service;

import java.util.Map;

import com.waterlab.bean.ProcessWater;


public interface ProcessWaterService {
	public void add(ProcessWater processWater);
	
	public ProcessWater getById(int id);
	
	public void update(ProcessWater processWater);
	
	public void delete(ProcessWater processWater);
	
	public void deleteById(int id);
	
	public Map<String,Object> queryPageInfo(int limit,int offset);
}
