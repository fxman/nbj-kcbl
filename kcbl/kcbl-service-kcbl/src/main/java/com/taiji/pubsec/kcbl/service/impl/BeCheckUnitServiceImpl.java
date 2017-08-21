package com.taiji.pubsec.kcbl.service.impl;

import java.util.List;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public BeCheckedUnit findBeCheckedUnitServiceById(String id) {
		
	    return (BeCheckedUnit) this.dao.findById(BeCheckedUnit.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BeCheckedUnit> findBecheckedUnitServiceBySshy(String sshy) {
		String str="from BeCheckedUnit bjdw where  bjdw.belongIndustry=?";
		return  this.dao.findAllByParams(BeCheckedUnit.class, str, new Object[]{sshy});
	}

   
}
