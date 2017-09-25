package com.taiji.pubsec.kcbl.bean;

import java.util.List;

import com.taiji.pubsec.businesscomponent.dictionary.model.DictionaryItem;

public class CheckContentBean {
    private  String parentName;
    private  String parentId;
    private  String code;
    private List<DictionaryItem> dicItems;
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public List<DictionaryItem> getDicItems() {
		return dicItems;
	}
	public void setDicItems(List<DictionaryItem> dicItems) {
		this.dicItems = dicItems;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
