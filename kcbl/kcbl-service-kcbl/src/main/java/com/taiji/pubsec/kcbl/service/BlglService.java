package com.taiji.pubsec.kcbl.service;

import java.util.List;

import com.taiji.pubsec.businesscomponent.dictionary.model.DictionaryItem;
import com.taiji.pubsec.businesscomponent.organization.model.Person;
import com.taiji.pubsec.kcbl.model.BlxxModel;
import com.taiji.pubsec.kcbl.model.CheckDetailResult;

public interface  BlglService {
	List<BlxxModel> findBlxxList(String unitName,String sfhxdw,String sshy,String startTime,String endTime);
    List<BlxxModel> findAllBlxxList();
    BlxxModel findBlxxById(String id);
    List<CheckDetailResult> findBlxxContentDescr();
    List<Person> findCheckManbyUnitIds(String[] unitIds);
}
