package com.taiji.pubsec.kcbl.service;

import com.taiji.pubsec.businesscomponent.organization.model.Account;

public interface AccountTempService {
    /**
     * 根据用户名和密码获取用户
     * @param name
     * @param password
     * @return
     */
	Account findByNameAndPassword(String name,String password);
}
