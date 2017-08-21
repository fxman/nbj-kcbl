package com.taiji.pubsec.kcbl.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "bdcdw")
public class BeCheckedUnit implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Column(name="becheckedunit", length=100)
	private String bdcdwmc; //被调查单位名称
	
	@OneToMany(mappedBy = "becheckedunit")
	private Set<BlxxModel> blxxSet = new HashSet<BlxxModel>();
	
	@Column(name="iscoreunit", length=2)
	private String isCoreUnit; //是否核心单位【1:是 0:否】
	
	@Column(name="detailaddress", length=100)
	private String detailAddress; //详细地址
	
	@Column(name="belongindustry", length=100)
	private String belongIndustry; //所属行业
	
	@Column(name="location", length=60)
	private String location;  //所在区县
	
	@Column(name="belongpolicy", length=60)
	private String belongpolicy; //属地派出所
	
	@Column(name="charge_security_person_telephone", length=20)
	private String chargeSecurityPersonTelephone; //主管安保人员电话
	
	@Column(name="charge_security", length=10)
	private String chargeSecurity; //主管安保人员

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

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getBelongIndustry() {
		return belongIndustry;
	}

	public void setBelongIndustry(String belongIndustry) {
		this.belongIndustry = belongIndustry;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBelongpolicy() {
		return belongpolicy;
	}

	public void setBelongpolicy(String belongpolicy) {
		this.belongpolicy = belongpolicy;
	}

	public String getChargeSecurityPersonTelephone() {
		return chargeSecurityPersonTelephone;
	}

	public void setChargeSecurityPersonTelephone(
			String chargeSecurityPersonTelephone) {
		this.chargeSecurityPersonTelephone = chargeSecurityPersonTelephone;
	}

	public String getChargeSecurity() {
		return chargeSecurity;
	}

	public void setChargeSecurity(String chargeSecurity) {
		this.chargeSecurity = chargeSecurity;
	}
}
