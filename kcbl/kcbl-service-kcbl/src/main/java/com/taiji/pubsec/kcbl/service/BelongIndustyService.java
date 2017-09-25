package com.taiji.pubsec.kcbl.service;

import java.util.List;

import com.taiji.pubsec.kcbl.model.BelongIndustry;

/**
 * 所属行业查询
 * @author xinfan
 *
 */
public interface BelongIndustyService {

	List<BelongIndustry> findAll();
}
