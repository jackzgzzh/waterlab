package com.waterlab.service.impl;

import java.util.Map;

import com.waterlab.bean.ProcessWater;
import com.waterlab.dao.ProcessWaterDao;
import com.waterlab.service.ProcessWaterService;

public class ProcessWaterServiceImpl implements ProcessWaterService {
	
	private ProcessWaterDao processWaterDao;	
	
	public ProcessWaterDao getProcessWaterDao() {
		return processWaterDao;
	}

	public void setProcessWaterDao(ProcessWaterDao processWaterDao) {
		this.processWaterDao = processWaterDao;
	}

	@Override
	public void add(ProcessWater processWater) {
		processWaterDao.add(processWater);
	}

	@Override
	public ProcessWater getById(int id) {
		ProcessWater processWater = processWaterDao.getById(id);
		return processWater;
	}

	@Override
	public void update(ProcessWater processWater) {
		processWaterDao.update(processWater);
	}

	@Override
	public void delete(ProcessWater processWater) {
		processWaterDao.delete(processWater);
	}

	@Override
	public void deleteById(int id) {
		processWaterDao.deleteById(id);
	}

	@Override
	public Map<String, Object> queryPageInfo(int limit, int offset) {
		return processWaterDao.queryPageInfo(limit, offset);
	}

}
