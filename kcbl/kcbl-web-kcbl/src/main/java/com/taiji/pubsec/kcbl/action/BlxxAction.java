package com.taiji.pubsec.kcbl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
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
import com.taiji.pubsec.kcbl.bean.BlxxDetailBean;
import com.taiji.pubsec.kcbl.model.BeCheckedUnit;
import com.taiji.pubsec.kcbl.model.BlxxModel;
import com.taiji.pubsec.kcbl.model.CheckDetailResult;
import com.taiji.pubsec.kcbl.model.FileInfo;
import com.taiji.pubsec.kcbl.service.BeCheckUnitService;
import com.taiji.pubsec.kcbl.service.BlglService;
import com.taiji.pubsec.kcbl.service.FileService;
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
	
	@Resource 
    private FileService fileSeriveimpl;
	
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
	private String blxxId;
	private BlxxModel blxx;
	private BlxxDetailBean blBean;
	private List<CheckDetailResult> checkContentDescrList;
	
	 private File file;
	    
	 private FileInfo attaceMent;
	    //提交过来的file的名字
	 private String fileFileName;
	
	
	
	
	public String findAllBlxxList(){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月DD日 HH时mm分");
         blxxModelList=blglServiceImpl.findAllBlxxList();
         blxxList=new ArrayList<BlListBean>();
		for(BlxxModel blxx:blxxModelList){
			blxxBean=new BlListBean();
			blxxBean.setBlxxId(blxx.getId());
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
	public String findBlxxDetail(){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月DD日 HH时mm分");
		blxx=blglServiceImpl.findBlxxById(blxxId);
		blBean=new BlxxDetailBean();
        blBean.setStartTime(sdf.format(blxx.getStarttime()));
        blBean.setEndTime(sdf.format(blxx.getEndtime()));
        blBean.setDetailAddress(blxx.getDetailaddress());
        blBean.setCheckUnit(blxx.getCheckunitcode());
        blBean.setCheckMan(blxx.getCheckpersoncode());
        blBean.setBeCheckedUnit(blxx.getBecheckedunit().getBdcdwmc());
        blBean.setPartyMan(blxx.getPartyname());
        blBean.setWitness(blxx.getWitness());
        blBean.setReasonsAndPurpose(blxx.getReasonsandpurpose());
        blBean.setPocessAndResult(blxx.getCheckprocess());
        
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
	public String saveblxx() throws IOException{
		 String root = ServletActionContext.getServletContext().getRealPath("/upload");
	        InputStream is;
	        OutputStream os;
	        String filePath = "D:/upload";
			try {
				//检查目录
		    	File uploadDir = new File(filePath);
		    	if(!uploadDir.isDirectory()){
		    		uploadDir.mkdir();

		    	}
		    	attaceMent = new FileInfo();
		    	is = new FileInputStream(file);
				 os = new FileOutputStream(new File(filePath, fileFileName));
				attaceMent.setSaveName(fileFileName);
		    	//检查目录写权限
				attaceMent.setFilePath(filePath);
				attaceMent.setId(null);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String fDate = df.format(date);
				attaceMent.setFileUpdateTime(fDate);
				attaceMent.setBgq(fDate.substring(0, 4));
				fileSeriveimpl.saveFileInformation(attaceMent);
				System.out.println("fileFileName: " + fileFileName);
				System.out.println("file: " + file.getName());
				System.out.println("file: " + file.getPath());
				byte[] buffer = new byte[500];
				int length = 0;
				while(-1 != (length = is.read(buffer, 0, buffer.length)))
				{
					os.write(buffer);
				}
				
				os.close();
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return SUCCESS;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public FileInfo getAttaceMent() {
		return attaceMent;
	}
	public void setAttaceMent(FileInfo attaceMent) {
		this.attaceMent = attaceMent;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
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
	public String initCheckDescr(){
		checkContentDescrList=blglServiceImpl.findBlxxContentDescr();
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
	public String toblDetail(){
		return SUCCESS;
	}
	public String toContentDescr(){
		return SUCCESS;
	}
	
	/*get&set方法*/
	public List<CheckDetailResult> getCheckContentDescrList() {
		return checkContentDescrList;
	}
	public void setCheckContentDescrList(
			List<CheckDetailResult> checkContentDescrList) {
		this.checkContentDescrList = checkContentDescrList;
	}
	public BlxxDetailBean getBlBean() {
		return blBean;
	}
	public void setBlBean(BlxxDetailBean blBean) {
		this.blBean = blBean;
	}
	public BlxxModel getBlxx() {
		return blxx;
	}
	public void setBlxx(BlxxModel blxx) {
		this.blxx = blxx;
	}
	public String getBlxxId() {
		return blxxId;
	}
	public void setBlxxId(String blxxId) {
		this.blxxId = blxxId;
	}
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
