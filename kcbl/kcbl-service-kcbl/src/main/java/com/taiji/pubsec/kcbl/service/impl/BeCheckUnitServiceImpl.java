package com.taiji.pubsec.kcbl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taiji.persistence.dao.Dao;
import com.taiji.pubsec.kcbl.model.BeCheckedUnit;
import com.taiji.pubsec.kcbl.service.BeCheckUnitService;

@Service("beCheckUnitServiceImpl")
public class BeCheckUnitServiceImpl implements BeCheckUnitService{
	@SuppressWarnings("rawtypes")
	@Resource
	private Dao dao;
	
	@Override
	public BeCheckedUnit findBeCheckedUnitServiceById(String id) {
		
	    return (BeCheckedUnit) this.dao.findById(BeCheckedUnit.class, id);
	}
   
}
