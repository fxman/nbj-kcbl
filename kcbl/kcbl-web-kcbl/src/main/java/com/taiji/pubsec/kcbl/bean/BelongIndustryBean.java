package com.taiji.pubsec.kcbl.bean;

import java.util.List;

import com.taiji.pubsec.kcbl.model.BeCheckedUnit;

public class BelongIndustryBean {
   
	private String name;
	
	private String id;
	
	private List<BeCheckUnitBean> beCheckUnits;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BeCheckUnitBean> getBeCheckUnits() {
		return beCheckUnits;
	}

	public void setBeCheckUnits(List<BeCheckUnitBean> beCheckUnits) {
		this.beCheckUnits = beCheckUnits;
	}

}
