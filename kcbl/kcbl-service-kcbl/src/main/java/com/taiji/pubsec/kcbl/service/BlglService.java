package com.taiji.pubsec.kcbl.service;

import java.util.List;

import com.taiji.pubsec.kcbl.model.BlxxModel;
public interface  BlglService {
	List<BlxxModel> findBlxxList(String userName , String blh,String sfhxdw,String sshy,String startTime,String endTime,String issafety);
	/**
	 * 根据用户名查找笔录信息
	 * @param userName
	 * @return
	 */
    List<BlxxModel> findAllBlxxList(String userName);
    BlxxModel findBlxxById(String id);

    /**
     * 保存笔录
     * @param blxxModel
     * @return
     */
    String saveBlxx(BlxxModel blxxModel);

    String findMaxBlh();
   

}
