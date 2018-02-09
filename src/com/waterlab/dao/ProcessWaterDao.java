package com.waterlab.dao;

import java.util.List;
import java.util.Map;

import com.waterlab.bean.ProcessWater;

public interface ProcessWaterDao {
	
	public void add(ProcessWater processWater);
	
	public ProcessWater getById(int id);
	
	public void update(ProcessWater processWater);
	
	public void delete(ProcessWater processWater);
	
	public void deleteById(int id);
	
	public Map<String,Object> queryPageInfo(int limit,int offset);
	
	public ProcessWater getProcessWater();
}
