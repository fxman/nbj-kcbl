package com.taiji.pubsec.kcbl.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taiji.persistence.dao.Dao;
import com.taiji.pubsec.businesscomponent.dictionary.model.DictionaryItem;
import com.taiji.pubsec.kcbl.model.BeCheckedUnit;
import com.taiji.pubsec.kcbl.service.BeCheckUnitService;

@Service("beCheckUnitServiceImpl")
public class BeCheckUnitServiceImpl implements BeCheckUnitService{
	@SuppressWarnings("rawtypes")
	@Resource
	private Dao dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public BeCheckedUnit findBeCheckedUnitServiceById(String id) {
	    return (BeCheckedUnit) this.dao.findById(BeCheckedUnit.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BeCheckedUnit> findBecheckedUnitServiceBySshy(String sshy,String partyUnit) {
		String str="from BeCheckedUnit bjdw where  bjdw.belongIndustry=? ";
		List<Object> params = new ArrayList<Object>();
		params.add(sshy);
		if (partyUnit != null){
			str += " and bjdw.bdcdwmc like ?";
			params.add("%" + partyUnit + "%");
		}
		return  this.dao.findAllByParams(BeCheckedUnit.class,str ,params.toArray());
	}
	@Override
	public BeCheckedUnit findBeCheckedUnitByName(String name){
		String str="from BeCheckedUnit bjdw where  bjdw.bdcdwmc=?";
		return  (BeCheckedUnit) this.dao.findByParams(BeCheckedUnit.class, str, new Object[]{name});
	}

	@SuppressWarnings("unchecked")
	@Override
	public DictionaryItem findBeCheckedUnitserviceByName(String unitName) {
		String sql = "from DictionaryItem unit where unit.name=?";
		return (DictionaryItem) this.dao.findByParams(DictionaryItem.class, sql, new Object[]{unitName});
	}

	@Override
	public List<BeCheckedUnit> findAllSshy() {
		String sql = "from BeCheckedUnit ncdw  where 1=? GROUP BY  ncdw.belongIndustry";
		return   this.dao.findAllByParams(BeCheckedUnit.class, sql, new Object[]{1});
	}

	@Override
	public List<BeCheckedUnit> findAllByConditons(String name) {
		String sql = "from BeCheckedUnit ncdw  where bdcdwmc like ?";
		return   this.dao.findAllByParams(BeCheckedUnit.class, sql, new Object[]{"%" + name + "%"});
	}
}
