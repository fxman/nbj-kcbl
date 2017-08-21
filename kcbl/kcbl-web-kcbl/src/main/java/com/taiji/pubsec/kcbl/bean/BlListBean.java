package com.taiji.pubsec.kcbl.bean;
/**
 * 查询列表笔录Bean
 */
import java.io.Serializable;


public class BlListBean implements Serializable {
	private String checkMan;
	private String partyMan;
	private String beCheckedUnit;
	private String startTime;
	private String endTime;
	public String getCheckMan() {
		return checkMan;
	}
	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}
	public String getPartyMan() {
		return partyMan;
	}
	public void setPartyMan(String partyMan) {
		this.partyMan = partyMan;
	}
	public String getBeCheckedUnit() {
		return beCheckedUnit;
	}
	public void setBeCheckedUnit(String beCheckedUnit) {
		this.beCheckedUnit = beCheckedUnit;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
