package com.taiji.pubsec.kcbl.service.impl;

import java.util.List;

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
	public List<Person> findCheckManbyUnitIds(String[] unitIds) {
		String sql="from Person where id in (?)";
		return this.dao.findAllByParams(Person.class, sql, new Object[]{unitIds});
	}
}
