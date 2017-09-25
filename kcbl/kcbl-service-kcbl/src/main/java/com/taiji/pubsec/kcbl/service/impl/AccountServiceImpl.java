package com.taiji.pubsec.kcbl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taiji.persistence.dao.Dao;
import com.taiji.pubsec.businesscomponent.organization.model.Account;
import com.taiji.pubsec.kcbl.service.AccountTempService;

@Service
public class AccountServiceImpl implements AccountTempService {
	@Resource
	private Dao<Account , String > dao;
	
	@Override
	public Account findByNameAndPassword(String name, String password) {
		String sql =  "from Account where accountName =? and password=?";
		return dao.findByParams(Account.class, sql, new Object[]{name,password});
	}
    
}
