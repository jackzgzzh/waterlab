package com.waterlab.dao;

import com.waterlab.bean.Header;

public interface HeaderDao {
	
	public void add(Header header);
	
	public Header getById(int id);
	
	public void update(Header header);
	
	public void delete(Header header);
	
	public Header findHeader();
	
}
