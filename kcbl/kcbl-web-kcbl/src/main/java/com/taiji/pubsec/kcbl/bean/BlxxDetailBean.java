package com.taiji.pubsec.kcbl.bean;

import java.io.Serializable;

public class BlxxDetailBean implements Serializable {
	private String checkMan;
	private String partyMan;
	private String beCheckedUnit;
	private String startTime;
	private String endTime;
	private String pocessAndResult;
	private String reasonsAndPurpose;
	private String witness;
	private String checkUnit;
	private String detailAddress;
	
	public String getPocessAndResult() {
		return pocessAndResult;
	}
	public void setPocessAndResult(String pocessAndResult) {
		this.pocessAndResult = pocessAndResult;
	}
	public String getReasonsAndPurpose() {
		return reasonsAndPurpose;
	}
	public void setReasonsAndPurpose(String reasonsAndPurpose) {
		this.reasonsAndPurpose = reasonsAndPurpose;
	}
	public String getWitness() {
		return witness;
	}
	public void setWitness(String witness) {
		this.witness = witness;
	}
	public String getCheckUnit() {
		return checkUnit;
	}
	public void setCheckUnit(String checkUnit) {
		this.checkUnit = checkUnit;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
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
