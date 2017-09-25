package com.taiji.pubsec.kcbl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taiji.persistence.dao.Dao;
import com.taiji.pubsec.kcbl.model.BelongIndustry;
import com.taiji.pubsec.kcbl.service.BelongIndustyService;

@Service
public class BelongIndustryServiceImpl implements BelongIndustyService{
	
	@Resource
	private Dao<BelongIndustry,String> dao;
	@Override
	public List<BelongIndustry> findAll() {
		return dao.findAll(BelongIndustry.class);
	}

}
