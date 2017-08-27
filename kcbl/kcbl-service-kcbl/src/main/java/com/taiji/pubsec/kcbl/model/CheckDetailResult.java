package com.taiji.pubsec.kcbl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="jcnrms")
public class CheckDetailResult implements Serializable {
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid2")
	private String id;//id
	
	@Temporal(TemporalType.DATE)
	@Column(name="updatetime")
	private Date updatetime;//更新时间
	
	@Column(name="usecount")
	private String usecount;//使用次数
	
	@Column(name="content")
	private String content;//内容

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getUsecount() {
		return usecount;
	}

	public void setUsecount(String usecount) {
		this.usecount = usecount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
