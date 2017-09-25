package com.taiji.pubsec.kcbl.service;

import java.util.List;

import com.taiji.pubsec.kcbl.model.CheckDetailResult;

public interface CheckDetailResultService {
	/**
	 * 根据用户名和是否存在安全隐患查找笔录模板
	 * @return
	 */
	List<CheckDetailResult> findBlxxContentDescr(String userName,String issafety);
	/**
	 * 保存或者更新笔录内容
	 * @param cdr
	 * @return
	 */
	String  saveOrUpdateCheckDetailResult(CheckDetailResult cdr);

}
