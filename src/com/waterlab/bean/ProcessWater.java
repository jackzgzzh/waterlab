package com.waterlab.bean;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ProcessWater")
@XmlType(propOrder = {
		"id",
		"checkTimeProcess",
		"sourceWaterNfu",
		"precipitableWaterNfu",
		"savedWaterNfu",
		"filteredWaterNfu",
		"finishedWaterNfu",
		"finishedWaterHico"
})
public class ProcessWater implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date checkTimeProcess;
	private Float sourceWaterNfu;
	private Float precipitableWaterNfu;
	private Float savedWaterNfu;
	private Float filteredWaterNfu;
	private Float finishedWaterNfu;
	private Float finishedWaterHico;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCheckTimeProcess() {
		return checkTimeProcess;
	}

	public void setCheckTimeProcess(Date checkTimeProcess) {
		this.checkTimeProcess = checkTimeProcess;
	}

	public Float getSourceWaterNfu() {
		return sourceWaterNfu;
	}

	public void setSourceWaterNfu(Float sourceWaterNfu) {
		this.sourceWaterNfu = sourceWaterNfu;
	}

	public Float getPrecipitableWaterNfu() {
		return precipitableWaterNfu;
	}

	public void setPrecipitableWaterNfu(Float precipitableWaterNfu) {
		this.precipitableWaterNfu = precipitableWaterNfu;
	}

	public Float getSavedWaterNfu() {
		return savedWaterNfu;
	}

	public void setSavedWaterNfu(Float savedWaterNfu) {
		this.savedWaterNfu = savedWaterNfu;
	}

	public Float getFilteredWaterNfu() {
		return filteredWaterNfu;
	}

	public void setFilteredWaterNfu(Float filteredWaterNfu) {
		this.filteredWaterNfu = filteredWaterNfu;
	}

	public Float getFinishedWaterNfu() {
		return finishedWaterNfu;
	}

	public void setFinishedWaterNfu(Float finishedWaterNfu) {
		this.finishedWaterNfu = finishedWaterNfu;
	}

	public Float getFinishedWaterHico() {
		return finishedWaterHico;
	}

	public void setFinishedWaterHico(Float finishedWaterHico) {
		this.finishedWaterHico = finishedWaterHico;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
