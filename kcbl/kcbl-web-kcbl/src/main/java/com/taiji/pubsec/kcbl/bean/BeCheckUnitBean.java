package com.taiji.pubsec.kcbl.bean;


public class BeCheckUnitBean {
	private String id;
	private String bdcdwmc; //被调查单位名称
	private String isCoreUnit; //是否核心单位【1:是 0:否】
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBdcdwmc() {
		return bdcdwmc;
	}
	public void setBdcdwmc(String bdcdwmc) {
		this.bdcdwmc = bdcdwmc;
	}
	public String getIsCoreUnit() {
		return isCoreUnit;
	}
	public void setIsCoreUnit(String isCoreUnit) {
		this.isCoreUnit = isCoreUnit;
	}
}
