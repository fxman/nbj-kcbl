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
	public List<CheckDetailResult> findBlxxContentDescr(String userName,String issafety) {
		String sql = "from CheckDetailResult where userName = ? and issafety=?  order by updatetime desc  limit 0 , 10 ";
		return this.dao.findAllByParams(CheckDetailResult.class, sql, new Object[]{userName, issafety});
	}
	@Override
	public String saveOrUpdateCheckDetailResult(CheckDetailResult cdr) {
		this.dao.save(cdr);
		return cdr.getId();
	}

}
