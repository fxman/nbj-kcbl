package com.taiji.pubsec.kcbl.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.taiji.persistence.dao.Dao;
import com.taiji.pubsec.kcbl.model.BlxxModel;
import com.taiji.pubsec.kcbl.service.BlglService;

@Service("BlglServiceImpl")
public class BlglServiceImpl implements BlglService {
	@Resource
	private Dao<BlxxModel, String> dao;

	@Override
	public List<BlxxModel> findBlxxList(String userName , String blh, String sfhxdw, String sshy,
			String startTime, String endTime,String issafety) {
		StringBuilder xql = new StringBuilder(
				"select blxx FROM BlxxModel blxx , BeCheckedUnit bcu  WHERE blxx.becheckedunit = bcu.id ");
		Map<String, Object> xqlMap = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(userName != null ){
			xql .append( " and blxx.checkpersoncode like :userName ");
			xqlMap.put("userName", "%" +userName+ "%");
		}
		if (StringUtils.isNotEmpty(blh)) {
			xql.append(" and blxx.blCode like :blh ");
			xqlMap.put("blh", "%" + blh + "%");
		}
		if (StringUtils.isNotEmpty(sfhxdw)) {
			xql.append("and bcu.isCoreUnit = :sfhxdw ");
			xqlMap.put("sfhxdw", sfhxdw);
		}
		if (StringUtils.isNotEmpty(issafety)) {
			xql.append("and blxx.issafety = :issafety ");
			xqlMap.put("issafety", issafety);
		}
		if (StringUtils.isNotEmpty(sshy)) {
			xql.append("and bcu.belongIndustry.name = :sshy ");
			xqlMap.put("sshy", sshy);
		}
		
		try {
			 if (StringUtils.isNotEmpty(startTime)) {
				xql.append(" and blxx.starttime >= :startTime  ");
				xqlMap.put("startTime", sdf.parse(startTime));
			 }
		     if (StringUtils.isNotEmpty(endTime)) {
					xql.append("and blxx.endtime <= :endTime");
					xqlMap.put("endTime",  sdf.parse(endTime));
			}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return this.dao
				.findAllByParams(BlxxModel.class, xql.toString(), xqlMap);
	}

	@Override
	public List<BlxxModel> findAllBlxxList(String userName) {
		String sql = "from BlxxModel blxx where blCode is not null and 1=?";
		List<Object> params =new ArrayList<Object>();
		params.add(1);
		if(userName != null ){
			sql += " and checkpersoncode like ? ";
			params.add("%" + userName + "%");
		}
		return this.dao.findAllByParams(BlxxModel.class, sql,
				params.toArray());
	}

	@Override
	public BlxxModel findBlxxById(String id) {
		String sql = "from BlxxModel blxx where blxx.id=?";
		return (BlxxModel) this.dao.findByParams(BlxxModel.class, sql,
				new Object[] { id });
	}

	@Override
	public String saveBlxx(BlxxModel BlxxModel) {
		this.dao.save(BlxxModel);
		return BlxxModel.getId();
	}

	@Override
	public String findMaxBlh() {
		return null;
	}
}
