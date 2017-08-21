package com.taiji.pubsec.kcbl.service;



import java.util.List;

import com.taiji.pubsec.kcbl.model.BeCheckedUnit;

public  interface  BeCheckUnitService {
  
	/**
	 * 根据ID查找被检查单位
	 * @param id
	 */
	BeCheckedUnit findBeCheckedUnitServiceById(String id);
	/**
	 * 根据所属行业查询被检查单位
	 * @param sshy
	 * @return
	 */
	List<BeCheckedUnit> findBecheckedUnitServiceBySshy(String sshy);
	
}
