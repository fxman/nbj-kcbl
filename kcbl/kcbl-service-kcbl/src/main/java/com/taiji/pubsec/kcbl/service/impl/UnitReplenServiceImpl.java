package com.taiji.pubsec.kcbl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taiji.persistence.dao.Dao;
import com.taiji.pubsec.businesscomponent.organization.model.Unit;
import com.taiji.pubsec.kcbl.service.UnitReplenService;

@Service
public class UnitReplenServiceImpl implements UnitReplenService{
    @Resource
    private Dao<Unit,String> dao;
	@Override
	public Unit findUnitbyName(String name) {
		String sql = "from Unit t where t.name =? ";
		return dao.findByParams(Unit.class, sql, new Object[]{name});
	}

}
