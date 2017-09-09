package com.taiji.pubsec.kcbl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taiji.persistence.dao.Dao;
import com.taiji.pubsec.kcbl.model.CheckDetailResult;
import com.taiji.pubsec.kcbl.service.CheckDetailResultService;

@Service
public class CheckDetailResultServiceImpl implements CheckDetailResultService {
	
	@Resource
	private Dao<CheckDetailResult,String> dao;
	
	@Override
	public List<CheckDetailResult> findBlxxContentDescr() {
		return this.dao.findAll(CheckDetailResult.class);
	}

}
