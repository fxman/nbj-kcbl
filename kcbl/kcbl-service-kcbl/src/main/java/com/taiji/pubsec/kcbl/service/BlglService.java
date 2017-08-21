package com.taiji.pubsec.kcbl.service;

import java.util.Date;
import java.util.List;

import com.taiji.pubsec.kcbl.model.BlxxModel;

public interface  BlglService {
	List<BlxxModel> findBlxxList(String unitName,String sfhxdw,String sshy,String startTime,String endTime);
    List<BlxxModel> findAllBlxxList();
}
