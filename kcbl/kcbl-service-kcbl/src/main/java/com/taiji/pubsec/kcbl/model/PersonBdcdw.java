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
@Table(name="person_bdcdw")
public class PersonBdcdw implements Serializable{
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid2")
	private String id;//id
	
	@Column(name = "personid")
	private String personid;//检查人
	
	@Column(name="becheckedunitid",length=36)
	private String bdcdwid;//被检查单位id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String getPersonid() {
		return personid;
	}
	public void setPersonid(String personid) {
		this.personid = personid;
	}
	public String getBdcdwid() {
		return bdcdwid;
	}
	public void setBdcdwid(String bdcdwid) {
		this.bdcdwid = bdcdwid;
	}
	
}
