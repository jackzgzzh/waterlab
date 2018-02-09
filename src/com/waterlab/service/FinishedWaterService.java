package com.waterlab.service;

import java.util.List;
import java.util.Map;

import com.waterlab.bean.FinishedWater;

public interface FinishedWaterService {
	
	public void add(FinishedWater finishedWater);
	
	public FinishedWater getById(int id);
	
	public void update(FinishedWater finishedWater);
	
	public void delete(FinishedWater finishedWater);
	
	public void deleteById(int id);
	
	public Map<String,Object> queryPageInfo(int limit,int offset);
	
	public List<FinishedWater> getFinishedWater(int limit,int offset);
	
}
