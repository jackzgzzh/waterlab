package com.waterlab.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.waterlab.bean.FinishedWater;
import com.waterlab.bean.Header;
import com.waterlab.bean.ProcessWater;
import com.waterlab.bean.SourceWater;
import com.waterlab.bean.User;
import com.waterlab.bean.chart.ChartBean;
import com.waterlab.common.DateTools;
import com.waterlab.common.XMLUtil;
import com.waterlab.dao.FinishedWaterDao;
import com.waterlab.dao.HeaderDao;
import com.waterlab.dao.ProcessWaterDao;
import com.waterlab.dao.SourceWaterDao;
import com.waterlab.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-hibernate.xml","classpath:applicationContext-spring.xml"})
public class DaoTest {
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="sourceWaterDao")
	private SourceWaterDao sourceWaterDao;
	@Resource(name="processWaterDao")
	private ProcessWaterDao processWaterDao;
	@Resource(name="finishedWaterDao")
	private FinishedWaterDao finishedWaterDao;
	@Resource(name="headerDao")
	private HeaderDao headerDao;
	
	//@Test
	public void testUserDao(){
		User user = new User();
		user.setUserName("张涛");
		user.setPassword("123");
		user.setUserRole(1);
		
		//user.setUserName("zhangtao");
		//userDao.update(user);
		//userDao.add(user);
		//userDao.getById(1);
		userDao.getByNP(user);
	}
	//@Test
	public void testSourceWaterDao(){
		//Map<String, Object> map = sourceWaterDao.queryPageInfo(10, 0);
		//System.out.println(map.get("total"));
//		List<SourceWater> list = (List<SourceWater>) map.get("rows");
//		System.out.println(list.get(0).getSrcAmmonia());
		sourceWaterDao.deleteById(5);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testProcessWaterDao() throws Exception{
//		Map<String, Object> map = processWaterDao.queryPageInfo(2, 0);
//		List checkTimeList = (List) map.get("checktime");
//		for(int i = 0;i < checkTimeList.size();i++){
//			System.out.println(checkTimeList.get(i).getClass());
//			System.out.println(checkTimeList.get(i));
//		}
		//从数据查询
		ProcessWater processWater = processWaterDao.getProcessWater();
		//新建一个processwater
		ProcessWater otherWater = new ProcessWater();
		otherWater.setFinishedWaterNfu(processWater.getFinishedWaterNfu());
		otherWater.setFinishedWaterHico(processWater.getFinishedWaterHico());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String checkTime = format.format(processWater.getCheckTimeProcess());
		
		
		ChartBean chartBean = new ChartBean();
		//chartBean.setProcessWater(otherWater);
		//chartBean.setLable(checkTime);
		
		String path = "processWaterChart.xml";
		XMLUtil.convertToXml(chartBean, path);
		
//		ProcessWater water= (ProcessWater) XMLUtil.convertXmlStrToObject(ProcessWater.class, str);
//		ChartBean chartBean = new ChartBean();
//		chartBean.setProcessWater(water);
//
//		String stringDate = JSON.toJSONStringWithDateFormat(chartBean, "yyyy-MM-dd");
//		System.out.println(stringDate);
		
	}
	
	//@Test
	public void testFinishedWaterDao(){

		
	}
	//@Test
	public void testHeaderDao(){
		//Header header = headerDao.getById(15);
		//System.out.println(DateTools.dataToWeek(header.getCheckTime()));

	}
	
}
