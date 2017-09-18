package com.taiji.pubsec.kcbl.service;



import java.util.List;

import com.taiji.pubsec.businesscomponent.dictionary.model.DictionaryItem;
import com.taiji.pubsec.kcbl.model.BeCheckedUnit;

public  interface  BeCheckUnitService {
  
	/**
	 * 根据ID查找被检查单位
	 * @param id
	 */
	BeCheckedUnit findBeCheckedUnitServiceById(String id);
	/**
	 * 根据所属行业,及输入条件查询被检查单位
	 * @param sshy
	 * @return
	 */
	List<BeCheckedUnit> findBecheckedUnitServiceBySshy(String sshy,String partyUnit);
	/**
	 * 根据单位名称查找被检查单位
	 * @param name
	 * @return
	 */
	BeCheckedUnit findBeCheckedUnitByName(String name);
	/**
	 * 根据单位名称查询检查单位
	 * @param unitName
	 * @return
	 */
	DictionaryItem findBeCheckedUnitserviceByName(String unitName);
	
	/**
	 * 查询所属行业
	 */
	List<BeCheckedUnit> findAllSshy();
	 /**
	  * 根据输入名称查单位
	  * @return
	  */
	List<BeCheckedUnit> findAllByConditons(String name);
}
