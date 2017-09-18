package com.taiji.pubsec.kcbl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taiji.persistence.dao.Dao;
import com.taiji.pubsec.businesscomponent.organization.model.Person;
import com.taiji.pubsec.kcbl.service.PersonReplenService;

@Service
public class PersonReplenServiceImpl implements PersonReplenService{
	@Resource
	private Dao<Person,String> dao;

	@Override
	public List<Person> findCheckManbyUnitIds(List<String> unitIds) {
		String sql="from Person where organization.id in (:unitIds)";
		Map<String ,Object> hasMap =  new HashMap<String ,Object>(0);
		hasMap.put("unitIds", unitIds);
		return this.dao.findAllByParams(Person.class, sql, hasMap);
	}
}
