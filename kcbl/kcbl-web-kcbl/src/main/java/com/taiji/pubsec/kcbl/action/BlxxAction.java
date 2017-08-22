package com.taiji.pubsec.kcbl.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.annotations.Source;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.taiji.pubsec.businesscomponent.dictionary.model.DictionaryItem;
import com.taiji.pubsec.businesscomponent.dictionary.model.DictionaryType;
import com.taiji.pubsec.businesscomponent.dictionary.service.IDictionaryItemService;
import com.taiji.pubsec.businesscomponent.dictionary.service.IDictionaryTypeService;
import com.taiji.pubsec.businesscomponent.organization.model.Person;
import com.taiji.pubsec.businesscomponent.organization.model.Unit;
import com.taiji.pubsec.businesscomponent.organization.service.IPersonService;
import com.taiji.pubsec.businesscomponent.organization.service.IUnitService;
import com.taiji.pubsec.kcbl.bean.BlListBean;
import com.taiji.pubsec.kcbl.model.BeCheckedUnit;
import com.taiji.pubsec.kcbl.model.BlxxModel;
import com.taiji.pubsec.kcbl.service.BeCheckUnitService;
import com.taiji.pubsec.kcbl.service.BlglService;
import com.taiji.pubsec.kcbl.util.ReturnMessageAction;
import com.taiji.pubsec.kcbl.util.bean.PersonBean;

@Controller("blxxAction")
@Scope("prototype")
public class BlxxAction extends ReturnMessageAction{
	
	@Resource(name = "unitService")
	private IUnitService unitService;
	@Resource
	private BlglService blglServiceImpl;
	@Resource
	private IPersonService personService;
	@Resource
	private BeCheckUnitService bjcwService;
	@Resource
	private IDictionaryTypeService dictionaryTypeService;
	@Resource
	private IDictionaryItemService dictionaryItemService;
	
	private BlListBean blxxBean;
	private String checkUnit;
	private String belongIndustry;
	private String iscoreunit;
	private String startTime;
	private String endTime;
	private List<BlListBean> blxxList;
	private List<Unit> unitList;
	private String unitId;
	private List<Person> checkManList;
	private List<DictionaryItem> bjdwList;
	private String sshy;
	private String dicTypeCode;
	private String state;
	private List<DictionaryItem> checkContentList;
	private List<DictionaryItem> subContentList;
	private String parentItemCode; 
	private List<BlxxModel> blxxModelList;
	
	public String findAllBlxxList(){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月DD日 HH时mm分");
         blxxModelList=blglServiceImpl.findAllBlxxList();
         blxxList=new ArrayList<BlListBean>();
		for(BlxxModel blxx:blxxModelList){
			blxxBean=new BlListBean();
			blxxBean.setBeCheckedUnit(blxx.getBecheckedunit().getBdcdwmc());
			blxxBean.setCheckMan(blxx.getCheckpersoncode());
			blxxBean.setPartyMan(blxx.getPartyname());
			if(blxx.getStarttime()!=null){
			  blxxBean.setEndTime(sdf.format(blxx.getEndtime()));
			}
			if(blxx.getEndtime()!=null){
				blxxBean.setStartTime(sdf.format(blxx.getStarttime()));
			}
			blxxList.add(blxxBean);
		}
		
		return SUCCESS;
	}
	public String generateBlListByCondition(){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月DD日 HH时mm分");
		List<BlxxModel> blxxlist = blglServiceImpl.findBlxxList(checkUnit, iscoreunit, belongIndustry, startTime, endTime);
		for(BlxxModel blxx:blxxlist){
			blxxBean=new BlListBean();
			blxxBean.setBeCheckedUnit(blxx.getBecheckedunit().getBdcdwmc());
			blxxBean.setCheckMan(blxx.getCheckpersoncode());
			blxxBean.setPartyMan(blxx.getPartyname());
			blxxBean.setStartTime(sdf.format(blxx.getStarttime()));
			blxxBean.setEndTime(sdf.format(blxx.getEndtime()));
			blxxList.add(blxxBean);
		}
		
		return SUCCESS;
	}
	public String finsubPartyUnit(){
		bjdwList = dictionaryItemService.findDicItemsByParent(sshy, null);
		return SUCCESS;
	}
	public String initPartyUnit(){
		bjdwList = dictionaryItemService.findAllSubDictionaryItemsByTypeCode(sshy);
		return SUCCESS;
	}
	public String initUnit(){
		unitList=unitService.findAll();
		return SUCCESS;
		
	}
	public String initCheckMan(){
		checkManList=personService.findPersonsByUnitAndPersonName(unitId, "");
		return SUCCESS;
	}
	public String initCheckContent(){
		checkContentList=dictionaryItemService.findDicItemsByTypeCode(dicTypeCode, state);
		return SUCCESS;
	}
	public String getSubContent(){
		subContentList = dictionaryItemService.findDicItemsByParentCode(parentItemCode, state);
		return SUCCESS;
	}
	public String toPartyUnit(){
		return SUCCESS;
	}
	public String toBlList(){
		return SUCCESS;
	}
	public String toblCheck() {
		return SUCCESS;
	}
	public String toCheckManUnit(){
		return SUCCESS;
	}
	public String toCheckMan(){
		return SUCCESS;
	}
	public String toAddResult(){
		return SUCCESS;
	}
	public String toCheckContent(){
		return SUCCESS;
	}
	
	
	/*get&set方法*/
	public List<BlxxModel> getBlxxModelList() {
		return blxxModelList;
	}
	public void setBlxxModelList(List<BlxxModel> blxxModelList) {
		this.blxxModelList = blxxModelList;
	}
	public List<DictionaryItem> getSubContentList() {
		return subContentList;
	}
	public void setSubContentList(List<DictionaryItem> subContentList) {
		this.subContentList = subContentList;
	}
	public String getParentItemCode() {
		return parentItemCode;
	}
	public void setParentItemCode(String parentItemCode) {
		this.parentItemCode = parentItemCode;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<DictionaryItem> getCheckContentList() {
		return checkContentList;
	}
	public void setCheckContentList(List<DictionaryItem> checkContentList) {
		this.checkContentList = checkContentList;
	}
	public String getDicTypeCode() {
		return dicTypeCode;
	}
	public void setDicTypeCode(String dicTypeCode) {
		this.dicTypeCode = dicTypeCode;
	}
	public String getSshy() {
		return sshy;
	}
	public void setSshy(String sshy) {
		this.sshy = sshy;
	}
	public List<DictionaryItem> getBjdwList() {
		return bjdwList;
	}
	public void setBjdwList(List<DictionaryItem> bjdwList) {
		this.bjdwList = bjdwList;
	}
	public List<Person> getCheckManList() {
		return checkManList;
	}
	public void setCheckManList(List<Person> checkManList) {
		this.checkManList = checkManList;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public List<Unit> getUnitList() {
		return unitList;
	}
	public void setUnitList(List<Unit> unitList) {
		this.unitList = unitList;
	}
	public List<BlListBean> getBlxxList() {
		return blxxList;
	}
	
	public void setBlxxList(List<BlListBean> blxxList) {
		this.blxxList = blxxList;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public BlListBean getBlxxBean() {
		return blxxBean;
	}
	
	public void setBlxxBean(BlListBean blxxBean) {
		this.blxxBean = blxxBean;
	}
	
	public String getCheckUnit() {
		return checkUnit;
	}
	
	public void setCheckUnit(String checkUnit) {
		this.checkUnit = checkUnit;
	}
	
	public String getBelongIndustry() {
		return belongIndustry;
	}
	
	public void setBelongIndustry(String belongIndustry) {
		this.belongIndustry = belongIndustry;
	}
	
	public String getIscoreunit() {
		return iscoreunit;
	}
	
	public void setIscoreunit(String iscoreunit) {
		this.iscoreunit = iscoreunit;
	}
	

}