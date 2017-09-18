package com.taiji.pubsec.kcbl.service;

import java.util.List;

import com.taiji.pubsec.kcbl.model.BlxxModel;
public interface  BlglService {
	List<BlxxModel> findBlxxList(String blh,String sfhxdw,String sshy,String startTime,String endTime);
    List<BlxxModel> findAllBlxxList();
    BlxxModel findBlxxById(String id);

    /**
     * 保存笔录
     * @param blxxModel
     * @return
     */
    String saveBlxx(BlxxModel blxxModel);

    String findMaxBlh();
   

}
