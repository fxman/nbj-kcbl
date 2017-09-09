package com.taiji.pubsec.kcbl.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.taiji.persistence.dao.Dao;
import com.taiji.pubsec.businesscomponent.dictionary.model.DictionaryItem;
import com.taiji.pubsec.businesscomponent.organization.model.Person;
import com.taiji.pubsec.kcbl.model.BlxxModel;
import com.taiji.pubsec.kcbl.model.CheckDetailResult;
import com.taiji.pubsec.kcbl.service.BlglService;


@Service("BlglServiceImpl")
public class BlglServiceImpl implements BlglService {
	@SuppressWarnings("rawtypes")
	@Resource
	private Dao dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BlxxModel> findBlxxList(String unitName, String sfhxdw,
			String sshy, String startTime, String endTime) {
		StringBuilder xql = new StringBuilder("FROM BlxxModel blxx WHERE 1=1");
		Map<String,Object> xqlMap = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		if(StringUtils.isNotEmpty(unitName)){
			xql.append(" and blxx.bdcdwmc = :unitName ");
			xqlMap.put("unitName", unitName);
		}
		if(StringUtils.isNotEmpty(sfhxdw)){
			xql.append("and blxx.iscoreunit = :sfhxdw ");
			xqlMap.put("sfhxdw", sfhxdw);
		}
		if(StringUtils.isNotEmpty(sshy)){
			xql.append("and blxx.belongindustry = :sshy ");
			xqlMap.put("sshy", sshy);
		}
		try {
			if(StringUtils.isNotEmpty(startTime)){
				xql.append(" and blxx.starttime >= :startTime ");
				xqlMap.put("startTime", sdf.parse(startTime));
			}
			if(StringUtils.isNotEmpty(endTime)){
				xql.append("and blxx.endtime <= :endTime");
				xqlMap.put("endTime", sdf.parse(endTime));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  this.dao.findAllByParams(BlxxModel.class, xql.toString(), xqlMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BlxxModel> findAllBlxxList() {
		
		return this.dao.findAll(BlxxModel.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public BlxxModel findBlxxById(String id) {
		String sql="from BlxxModel blxx where blxx.id=?";
		return (BlxxModel) this.dao.findByParams(BlxxModel.class, sql,new Object[]{id});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckDetailResult> findBlxxContentDescr() {
		return this.dao.findAll(CheckDetailResult.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findCheckManbyUnitIds(String[] unitIds) {
		String sql="from Person where id in (?)";
		return this.dao.findAllByParams(Person.class, sql, new Object[]{unitIds});
	}


}
