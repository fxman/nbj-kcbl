package com.taiji.pubsec.kcbl.service;

import com.taiji.pubsec.kcbl.model.FileInfo;

public interface FileService {
    /**
     * 保存文件
     * @param attachment
     */
	public void saveFileInformation(FileInfo attachment);
	
	/**
     * 根据文件ID查找文件
     * @return
     */
	public FileInfo findFileById(String id);
	
	public FileInfo findFileByResourceId(String id,String resourceType);
	
}
