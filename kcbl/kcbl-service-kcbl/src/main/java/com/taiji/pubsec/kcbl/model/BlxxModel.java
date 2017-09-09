package com.taiji.pubsec.kcbl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 笔录信息model
 * @author zhx
 *
 */

@Entity
@Table(name="blxx")
public class BlxxModel implements Serializable{  	
   @Id
   @GeneratedValue(generator="uuid")
   @GenericGenerator(name="uuid",strategy="uuid2")
   private String id;//id
   
   @Temporal(TemporalType.DATE)
   @Column(name="starttime")
   private Date starttime;//开始时间
   
   @Temporal(TemporalType.DATE)
   @Column(name="endtime")
   private Date endtime;//结束时间
   
   @Column(name="detailaddress",length=100)
   private String detailaddress;//被调查单位地址
   
   @Column(name="checkunitcode",length=30)
   private String checkunitcode;//检查单位代码
   
   @Column(name="checkpersoncode",length=30)
   private String checkpersoncode;//检查人代码
   
   @ManyToOne
   @JoinColumn(name = "becheckedunitcode")
   private BeCheckedUnit becheckedunit;//被检查单位代码
   
   @Column(name="partyname",length=30)
   private String partyname;//当事人
   
   @Column(name="witness",length=30)
   private String witness;//见证人
   
   @Column(name="issafety",length=2)
   private String issafety;//是否安全
   
   @Column(name="reasonsandpurpose",length=255)
   private String reasonsandpurpose;//事由和目的
   
   @Column(name="checkcontents",length=255)
   private String checkcontents;//结果
   
   @Column(name="checkprocess",length=60)
   private String checkprocess;//过程
   
   @Column(name="checkstyle",length=20)
   private String checkstyle;//检查方式
   
   @Column(name="checkmethod",length=20)
   private String checkmethod;//检查方法
   @Column(name="checkBasis")//检查依据
   private String checkBasis;
   @OneToOne
   @JoinColumn(name = "checkdetailresultId")
   private CheckDetailResult checkResult;//检查结果的内容描述
   
   @Column(length=20)
   private String status;// 检查状态  暂存 完成
   
   @Column(name="blh",length=20)
   private String blCode;
   
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Date getStarttime() {
	return starttime;
}
public void setStarttime(Date starttime) {
	this.starttime = starttime;
}
public Date getEndtime() {
	return endtime;
}
public void setEndtime(Date endtime) {
	this.endtime = endtime;
}
public String getDetailaddress() {
	return detailaddress;
}
public void setDetailaddress(String detailaddress) {
	this.detailaddress = detailaddress;
}
public String getCheckunitcode() {
	return checkunitcode;
}
public void setCheckunitcode(String checkunitcode) {
	this.checkunitcode = checkunitcode;
}


public String getCheckpersoncode() {
	return checkpersoncode;
}
public void setCheckpersoncode(String checkpersoncode) {
	this.checkpersoncode = checkpersoncode;
}
public BeCheckedUnit getBecheckedunit() {
	return becheckedunit;
}
public void setBecheckedunit(BeCheckedUnit becheckedunit) {
	this.becheckedunit = becheckedunit;
}
public String getPartyname() {
	return partyname;
}
public void setPartyname(String partyname) {
	this.partyname = partyname;
}
public String getWitness() {
	return witness;
}
public void setWitness(String witness) {
	this.witness = witness;
}
public String getIssafety() {
	return issafety;
}
public void setIssafety(String issafety) {
	this.issafety = issafety;
}
public String getReasonsandpurpose() {
	return reasonsandpurpose;
}
public void setReasonsandpurpose(String reasonsandpurpose) {
	this.reasonsandpurpose = reasonsandpurpose;
}
public String getCheckcontents() {
	return checkcontents;
}
public void setCheckcontents(String checkcontents) {
	this.checkcontents = checkcontents;
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
public CheckDetailResult getCheckResult() {
	return checkResult;
}
public void setCheckResult(CheckDetailResult checkResult) {
	this.checkResult = checkResult;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getBlCode() {
	return blCode;
}
public void setBlCode(String blCode) {
	this.blCode = blCode;
}
public String getCheckBasis() {
	return checkBasis;
}
public void setCheckBasis(String checkBasis) {
	this.checkBasis = checkBasis;
}
}
