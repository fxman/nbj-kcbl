package com.taiji.pubsec.kcbl.service;

import com.taiji.pubsec.kcbl.model.BeCheckedUnit;

public  interface  BeCheckUnitService {
  
	/**
	 * 根据ID查找被检查单位
	 * @param id
	 */
	BeCheckedUnit findBeCheckedUnitServiceById(String id);
}
