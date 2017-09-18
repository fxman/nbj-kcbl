package com.taiji.pubsec.kcbl.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.taiji.pubsec.kcbl.model.CheckDetailResult;

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
	private String issafety; //是否存在安全隐患
	private String checkprocess;//过程
	private String checkstyle;//检查方式
	private String checkmethod;//检查方法
	private String checkBasis; //检查依据
	private String checkResult;//检查结果的内容描述
	private String blcode;
	private String isCoreUnit;//是否核心单位
	private String blxxId;
	private String signPictureUrl;
	private String belongUnit;
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
	public String getIssafety() {
		return issafety;
	}
	public void setIssafety(String issafety) {
		this.issafety = issafety;
	}
	public String getCheckprocess() {
		return checkprocess;
	}
	public void setCheckprocess(String checkprocess) {
		this.checkprocess = checkprocess;
	}
	public String getCheckstyle() {
		return checkstyle;
	}
	public void setCheckstyle(String checkstyle) {
		this.checkstyle = checkstyle;
	}
	public String getCheckmethod() {
		return checkmethod;
	}
	public void setCheckmethod(String checkmethod) {
		this.checkmethod = checkmethod;
	}
	public String getCheckBasis() {
		return checkBasis;
	}
	public void setCheckBasis(String checkBasis) {
		this.checkBasis = checkBasis;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public String getBlcode() {
		return blcode;
	}
	public void setBlcode(String blcode) {
		this.blcode = blcode;
	}
	public String getBlxxId() {
		return blxxId;
	}
	public void setBlxxId(String blxxId) {
		this.blxxId = blxxId;
	}
	public String getSignPictureUrl() {
		return signPictureUrl;
	}
	public void setSignPictureUrl(String signPictureUrl) {
		this.signPictureUrl = signPictureUrl;
	}
	public String getIsCoreUnit() {
		return isCoreUnit;
	}
	public void setIsCoreUnit(String isCoreUnit) {
		this.isCoreUnit = isCoreUnit;
	}
	public String getBelongUnit() {
		return belongUnit;
	}
	public void setBelongUnit(String belongUnit) {
		this.belongUnit = belongUnit;
	}
}
