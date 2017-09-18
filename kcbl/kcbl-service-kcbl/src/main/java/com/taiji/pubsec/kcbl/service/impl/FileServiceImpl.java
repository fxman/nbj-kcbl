package com.taiji.pubsec.kcbl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taiji.persistence.dao.Dao;
import com.taiji.pubsec.kcbl.model.FileInfo;
import com.taiji.pubsec.kcbl.service.FileService;

@Service("fileServiceImpl")
@SuppressWarnings("unchecked")
public class FileServiceImpl implements FileService{

	@Resource
	private Dao<FileInfo, Integer> hibernateDao;
	
	@Override
	public void saveFileInformation(FileInfo attachment) {
		hibernateDao.save(attachment);
		
	}

	@Override
	public FileInfo findFileById(String id) {
		String sql = "from FileInfo where id =? ";
		FileInfo fileInfo = hibernateDao.findByParams(FileInfo.class, sql, new Object[]{id});
		return fileInfo;
	}

	@Override
	public FileInfo findFileByResourceId(String id,String resourceType) {
		String sql = "from FileInfo where resourceId =? and resourceType=?";
		FileInfo fileInfo = hibernateDao.findByParams(FileInfo.class, sql, new Object[]{id,resourceType});
		return fileInfo;
	}
}
