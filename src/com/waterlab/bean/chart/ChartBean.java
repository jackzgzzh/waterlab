package com.waterlab.bean.chart;

import java.util.List;
import com.waterlab.bean.FinishedWater;

public class ChartBean {

	private List<FinishedWater> finishedWaters;
	private List<String> lables;

	public List<String> getLables() {
		return lables;
	}

	public void setLables(List<String> lables) {
		this.lables = lables;
	}

	public List<FinishedWater> getFinishedWaters() {
		return finishedWaters;
	}

	public void setFinishedWaters(List<FinishedWater> finishedWaters) {
		this.finishedWaters = finishedWaters;
	}

}
