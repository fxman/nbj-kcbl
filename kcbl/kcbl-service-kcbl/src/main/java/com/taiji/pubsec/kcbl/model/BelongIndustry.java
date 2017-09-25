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
@Table(name = "sshy")
public class BelongIndustry implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Column(name="hymc")
	private String name;
	
	@OneToMany(mappedBy = "belongIndustry")
	private Set<BeCheckedUnit> units = new HashSet<BeCheckedUnit>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BeCheckedUnit> getUnits() {
		return units;
	}

	public void setUnits(Set<BeCheckedUnit> units) {
		this.units = units;
	}
}
