package com.waterlab.bean;

public class SourceWater {
	private Integer id;
	private float srcTemperature;
	private float srcPh;
	private int srcChroma;
	private boolean srcLookable;
	private boolean srcSmell;
	private float srcNtu;
	private int srcCfu;
	private int srcTotalColiforms;
	private int srcHeatResistant;
	private float srcCod;
	private float srcAmmonia;
	
	public SourceWater(){
		
	}
	
	// 多对一
	private Header srcHeader;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getSrcTemperature() {
		return srcTemperature;
	}

	public void setSrcTemperature(float srcTemperature) {
		this.srcTemperature = srcTemperature;
	}

	public float getSrcPh() {
		return srcPh;
	}

	public void setSrcPh(float srcPh) {
		this.srcPh = srcPh;
	}

	public int getSrcChroma() {
		return srcChroma;
	}

	public void setSrcChroma(int srcChroma) {
		this.srcChroma = srcChroma;
	}

	public boolean isSrcLookable() {
		return srcLookable;
	}

	public void setSrcLookable(boolean srcLookable) {
		this.srcLookable = srcLookable;
	}

	public boolean isSrcSmell() {
		return srcSmell;
	}

	public void setSrcSmell(boolean srcSmell) {
		this.srcSmell = srcSmell;
	}

	public float getSrcNtu() {
		return srcNtu;
	}

	public void setSrcNtu(float srcNtu) {
		this.srcNtu = srcNtu;
	}

	public int getSrcCfu() {
		return srcCfu;
	}

	public void setSrcCfu(int srcCfu) {
		this.srcCfu = srcCfu;
	}

	public int getSrcTotalColiforms() {
		return srcTotalColiforms;
	}

	public void setSrcTotalColiforms(int srcTotalColiforms) {
		this.srcTotalColiforms = srcTotalColiforms;
	}

	public int getSrcHeatResistant() {
		return srcHeatResistant;
	}

	public void setSrcHeatResistant(int srcHeatResistant) {
		this.srcHeatResistant = srcHeatResistant;
	}

	public float getSrcCod() {
		return srcCod;
	}

	public void setSrcCod(float srcCod) {
		this.srcCod = srcCod;
	}

	public float getSrcAmmonia() {
		return srcAmmonia;
	}

	public void setSrcAmmonia(float srcAmmonia) {
		this.srcAmmonia = srcAmmonia;
	}

	public Header getSrcHeader() {
		return srcHeader;
	}

	public void setSrcHeader(Header srcHeader) {
		this.srcHeader = srcHeader;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
