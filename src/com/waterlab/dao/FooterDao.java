package com.waterlab.dao;

import com.waterlab.bean.Footer;

public interface FooterDao {
	
	public void add(Footer footer);
	
	public Footer getById(int id);
	
	public void update(Footer footer);
	
	public void delete(Footer footer);
	
}
