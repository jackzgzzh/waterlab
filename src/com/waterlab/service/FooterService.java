package com.waterlab.service;

import com.waterlab.bean.Footer;
import com.waterlab.dao.FooterDao;

public interface FooterService {
	
	public void add(Footer footer);
	
	public Footer find(int id);
	
	public void update(Footer footer);
	
	public void delete(Footer footer);
	
}
