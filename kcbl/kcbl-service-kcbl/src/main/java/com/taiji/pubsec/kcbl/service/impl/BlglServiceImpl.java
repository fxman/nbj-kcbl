package com.taiji.pubsec.kcbl.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public List<BlxxModel> findBlxxList(String blh, String sfhxdw, String sshy,
			String startTime, String endTime) {
		StringBuilder xql = new StringBuilder(
				"select blxx FROM BlxxModel blxx , BeCheckedUnit bcu  WHERE blxx.becheckedunit = bcu.id ");
		Map<String, Object> xqlMap = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if (StringUtils.isNotEmpty(blh)) {
			xql.append(" and blxx.blCode like :blh ");
			xqlMap.put("blh", "%" + blh + "%");
		}
		if (StringUtils.isNotEmpty(sfhxdw)) {
			xql.append("and bcu.isCoreUnit = :sfhxdw ");
			xqlMap.put("sfhxdw", sfhxdw);
		}
		if (StringUtils.isNotEmpty(sshy)) {
			xql.append("and bcu.belongIndustry = :sshy ");
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
	public List<BlxxModel> findAllBlxxList() {
		String sql = "from BlxxModel blxx where blCode is not null and 1=?";
		return this.dao.findAllByParams(BlxxModel.class, sql,
				new Object[] { 1 });
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
