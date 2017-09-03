package com.taiji.pubsec.kcbl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="FileInfo")
public class FileInfo {
	private String id;
	//原始文件名（不包括后缀名）
	private String originalName;
	//保存文件名（不包括后缀名）
	private String saveName;
	//文件后缀（不包含.）
	private String fileSuffix;
	//文件大小
	private long fileSize;
	//保存路径(绝对路径，不包括文件名)
	private String filePath;
	//更新时间
	private String fileUpdateTime;
	//指向资源ID
	private String resourceId;
	//报告期
	private String bgq;
	
	@Id
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	@GeneratedValue(generator="system-uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public String getFileSuffix() {
		return fileSuffix;
	}
	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFileUpdateTime() {
		return fileUpdateTime;
	}
	public void setFileUpdateTime(String fileUpdateTime) {
		this.fileUpdateTime = fileUpdateTime;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getBgq() {
		return bgq;
	}
	public void setBgq(String bgq) {
		this.bgq = bgq;
	}
}