package com.taiji.pubsec.kcbl.action;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.taiji.pubsec.businesscomponent.dictionary.model.DictionaryItem;
import com.taiji.pubsec.businesscomponent.dictionary.service.IDictionaryItemService;
import com.taiji.pubsec.businesscomponent.dictionary.service.IDictionaryTypeService;
import com.taiji.pubsec.businesscomponent.organization.model.Account;
import com.taiji.pubsec.businesscomponent.organization.model.Person;
import com.taiji.pubsec.businesscomponent.organization.model.Unit;
import com.taiji.pubsec.businesscomponent.organization.service.AccountServiceImpl;
import com.taiji.pubsec.businesscomponent.organization.service.IPersonService;
import com.taiji.pubsec.businesscomponent.organization.service.IUnitService;
import com.taiji.pubsec.common.tool.base64.Base64CryptFmtUtil;
import com.taiji.pubsec.common.tools.doc.core.model.ReportConfig;
import com.taiji.pubsec.common.tools.doc.msoffice.impl.poi.pojo.ImagePojo;
import com.taiji.pubsec.common.tools.doc.msoffice.impl.poi.pojo.ImageType;
import com.taiji.pubsec.common.tools.doc.msoffice.impl.poicr.builder.PoiCrReportBuilder;
import com.taiji.pubsec.common.tools.doc.msoffice.impl.poicr.reporter.PoiCrReport;
import com.taiji.pubsec.kcbl.bean.BeCheckUnitBean;
import com.taiji.pubsec.kcbl.bean.BelongIndustryBean;
import com.taiji.pubsec.kcbl.bean.BlListBean;
import com.taiji.pubsec.kcbl.bean.BlxxDetailBean;
import com.taiji.pubsec.kcbl.bean.CheckContentBean;
import com.taiji.pubsec.kcbl.generatenum.service.IGenerateNumService;
import com.taiji.pubsec.kcbl.model.BeCheckedUnit;
import com.taiji.pubsec.kcbl.model.BelongIndustry;
import com.taiji.pubsec.kcbl.model.BlxxModel;
import com.taiji.pubsec.kcbl.model.CheckDetailResult;
import com.taiji.pubsec.kcbl.model.FileInfo;
import com.taiji.pubsec.kcbl.service.AccountTempService;
import com.taiji.pubsec.kcbl.service.BeCheckUnitService;
import com.taiji.pubsec.kcbl.service.BelongIndustyService;
import com.taiji.pubsec.kcbl.service.BlglService;
import com.taiji.pubsec.kcbl.service.CheckDetailResultService;
import com.taiji.pubsec.kcbl.service.FileService;
import com.taiji.pubsec.kcbl.service.PersonReplenService;
import com.taiji.pubsec.kcbl.service.UnitReplenService;
import com.taiji.pubsec.kcbl.util.Constant;
import com.taiji.pubsec.kcbl.util.ReturnMessageAction;

@SuppressWarnings("serial")
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
	private IDictionaryTypeService dictionaryTypeService;
	@Resource
	private IDictionaryItemService dictionaryItemService;
	@Resource 
    private FileService fileSeriveimpl;
	@Resource 
	private BeCheckUnitService becheckUnitService;
	@Resource
	private PersonReplenService personReplenService;
	@Resource
	private CheckDetailResultService checkDetailResultService;
	@Resource
	private PoiCrReportBuilder poiCrReportBuilder;
	@Resource
	private IGenerateNumService generateNumService;
	@Resource
	private UnitReplenService unitReplenService;
	@Resource
	private FileService fileService;
	@Resource
	private BelongIndustyService belongIndustyService;
	@Resource 
	private  AccountTempService accountTempService;
	private BlxxDetailBean blxxDetailBean;
	private BlListBean blxxBean;
	private String checkUnit;
	private String belongIndustry;
	private String iscoreunit;
	private String startTime;
	private String endTime;
	private String checkManName;
	private List<BlListBean> blxxList;
	private List<Unit> unitList;
	private String unitId;
	private List<Person> checkManList;
	private List<DictionaryItem> bjdwList;
	private String sshy;
	private String dicTypeCode;
	private String state;
	private List<CheckContentBean> checkContentList;
	private List<DictionaryItem> subContentList;
	private String parentItemCode; 
	private List<BlxxModel> blxxModelList;
	private String blxxId;
	private BlxxModel blxx;
	private BlxxDetailBean blBean;
	private List<CheckDetailResult> checkContentDescrList;
	private DictionaryItem unit;
	private String partyUnit;
	private DictionaryItem accor;
	private String checkAccorId;
	private String unitIds;
	private File file;
	private File fileSign;
	private FileInfo attaceMent;
	private String fileName;
	    //提交过来的file的名字
	private String fileFileName;
	private String fileSignFileName;
	private String fileId;
	private List<BeCheckedUnit> beCheckLits;
	private List<BelongIndustryBean> belongIndustryListBean;
	private String account;
	private String password;
	private String flag;
	
	public String login(){
		flag="true";
		try{
			Account acc = accountTempService.findByNameAndPassword(account, password);
			if(acc != null){
				Map<String,Object> accountMap = ActionContext.getContext().getSession();
				accountMap.put("userName", acc.getAccountName());
				accountMap.put("personName", acc.getPerson().getName());
			}else{
				flag="false";
			}
		}catch(Exception e){
			flag="false";
		}
		return SUCCESS;
	}
	public String findAllBlxxList(){
		Map<String,Object> accountMap = ActionContext.getContext().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
         blxxModelList=blglServiceImpl.findAllBlxxList(accountMap.get("personName").toString());
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
		
		blxx=blglServiceImpl.findBlxxById(blxxId);
		FileInfo signFileInfo =  fileService.findFileByResourceId(blxxId,"1");
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
        blBean.setPocessAndResult(blxx.getCheckcontents());
        blBean.setBlcode(blxx.getBlCode());
        blBean.setBlxxId(blxx.getId());
        if(signFileInfo != null){
        	blBean.setSignPictureUrl(signFileInfo.getSaveName());
        }
		return SUCCESS;
	}
	public String queryBlxxbyCondition(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月DD日 HH时mm分");
		Map<String,Object> accountMap = ActionContext.getContext().getSession();
		List<BlxxModel> blxxModelList = blglServiceImpl.findBlxxList(accountMap.get("personName").toString(),
				blBean.getBlcode(), 
				blBean.getIsCoreUnit(), blBean.getBelongUnit(),
				blBean.getStartTime(), blBean.getEndTime());
		blxxList = new ArrayList<BlListBean>();
		for(BlxxModel blxx:blxxModelList){
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
	public String saveblxx() throws IOException, ParseException{
		Map<String,Object> accountMap = ActionContext.getContext().getSession();
		 SimpleDateFormat sdfNew = new SimpleDateFormat("yyyyMMdd");
		 String[]  checkUnits = blxxDetailBean.getCheckUnit().split(",");
		 Unit  di = unitReplenService.findUnitbyName(checkUnits[0]);
		 //生成笔录号
		 String num = generateNumService.acquireNum("NBDD");//都以内保大队 来生成顺序号
		 String numStr = String.format("%05d",Integer.parseInt(num)+1);
		 String blh = di.getRemark()+sdfNew.format(new Date()) + numStr;
		 String blid =  this.saveBlMethod(Constant.BLSTATUS_BAOCUN,blh);
		 CheckDetailResult cdr = new CheckDetailResult();
		 cdr.setContent(blxxDetailBean.getCheckResult());
		 cdr.setUserName(accountMap.get("userName").toString());
		 cdr.setUpdatetime(new Date());
		 cdr.setIssafety(blxxDetailBean.getIssafety());
		 this.checkDetailResultService.saveOrUpdateCheckDetailResult(cdr);
		 //保存附件 附件的类型为2 签名的类型为1  生成的文档类型为0
		 InputStream isf = null;
		 if(file != null ){
			 isf = new FileInputStream(file);
			 int  index = fileFileName.indexOf(".");
			 this.uploadDoc(isf, blh+"f"+fileFileName.substring(index,fileFileName.length()),blid,"2");
		 }
		//保存签名
		 InputStream iss = null;
		 String suffix = "";
		 if(fileSign != null){
			 iss = new FileInputStream(fileSign);
			 int  index = fileSignFileName.indexOf(".");
			 suffix = fileSignFileName.substring(index,fileSignFileName.length());
			//生成笔录
			 InputStream isbl = this.generateBl();
			 this.uploadDoc(iss, blh+"s"+suffix,blid,"1");
			 this.uploadDoc(isbl, blh+".docx" ,blid,"0");
		 } 
		 return SUCCESS;
	}
	
	//返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流  
    public InputStream getDownloadFile() throws IOException   {
    	InputStream inputStream = null;
    	ServletOutputStream servletOutputStream = null;
    	try {
        FileInfo  fileInfo = fileService.findFileByResourceId(blxxId, "0");//表示下载笔录文档
    	HttpServletResponse response= ServletActionContext.getResponse();
    	String filePath = fileInfo.getFilePath() + File.separatorChar + fileInfo.getSaveName();
    	File file = new File(filePath);
    	response.reset();
		
			response.setHeader("Content-Disposition", "attachment;filename="
					+ URLEncoder.encode(fileInfo.getSaveName(), "UTF-8"));
		
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setContentType("application/octet-stream");
		inputStream = new BufferedInputStream(new FileInputStream(file));
		byte[] buffer = new byte[1024 * 1024 * 10];
		servletOutputStream = response.getOutputStream();
		int byteRead = 0;
		while ((byteRead = inputStream.read(buffer)) != -1) {
			servletOutputStream.write(buffer, 0, byteRead);
		}
		fileName = fileInfo.getSaveName();
    	} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}finally{
			if(inputStream != null ){
				inputStream.close();
			}
			if(servletOutputStream != null){
				servletOutputStream.close();
			}
		}
		return null;
    }
	/**
	 * 暂存笔录
	 * @return
	 * @throws ParseException 
	 */
	public String saveTempBlxx() throws ParseException{
		this.saveBlMethod(Constant.BLSTATUS_ZANCUN,null);
		return SUCCESS;
	}
	public String findCheckContentByAccor(){
		accor=dictionaryItemService.findById(checkAccorId);
		return SUCCESS;
		
	}
	public String findPartyUnitByName(){
		beCheckLits = becheckUnitService.findAllByConditons(partyUnit);
		return SUCCESS;
	}
	public String finsubPartyUnit(){
		beCheckLits = becheckUnitService.findBecheckedUnitServiceBySshy(sshy,partyUnit);
		return SUCCESS;
	}
	public String initPartyUnit(){
		List<BelongIndustry> lis  = belongIndustyService.findAll();
		belongIndustryListBean = new ArrayList<BelongIndustryBean>();
		for(BelongIndustry bi : lis){
			BelongIndustryBean bib = new BelongIndustryBean();
			List<BeCheckUnitBean> bcubList = new ArrayList<BeCheckUnitBean>();
			bib.setId(bi.getId());
			bib.setName(bi.getName());
			for(BeCheckedUnit bcu : bi.getUnits()){
				BeCheckUnitBean   bcub = new BeCheckUnitBean();
				bcub.setId(bcu.getId());
				bcub.setBdcdwmc(bcu.getBdcdwmc());
				bcubList.add(bcub);
			}
			bib.setBeCheckUnits(bcubList);
			belongIndustryListBean.add(bib);
		}
		return SUCCESS;
	}
	public String initUnit(){
		unitList=unitService.findAll();
		return SUCCESS;
		
	}
	public String initCheckMan(){
		String[] ids = unitIds.split(",");
		checkManList = personReplenService.findCheckManbyUnitIds(Arrays.asList(ids));
		return SUCCESS;
	}
	
	public String findCheckManByName(){
		checkManList = personService.findPersonsByUnitAndPersonName(unitId, checkManName);
		return SUCCESS;
	}
	public String initCheckContent(){
		checkContentList =  new ArrayList<CheckContentBean>();
		 List<DictionaryItem> items = dictionaryItemService.findDicItemsByTypeCode(dicTypeCode, state);
	       for(DictionaryItem item : items){
	    	   CheckContentBean ccb = new CheckContentBean();
	    	   ccb.setParentId(item.getId());
	    	   ccb.setParentName(item.getName());
	    	   ccb.setCode(item.getCode());
	    	   subContentList = dictionaryItemService.findDicItemsByParentCode(item.getCode(), "1");
	    	   ccb.setDicItems(subContentList);
	    	   checkContentList.add(ccb);
	       }
		return SUCCESS;
	}
	public String getSubContent(){
		subContentList = dictionaryItemService.findDicItemsByParentCode(parentItemCode, state);
		return SUCCESS;
	}
	public String initCheckDescr(){
		Map<String,Object> accountMap = ActionContext.getContext().getSession();
		String userName = accountMap.get("userName").toString();
		checkContentDescrList=checkDetailResultService.findBlxxContentDescr(
				userName ,this.blBean.getIssafety());
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
	public String toCheckAccor(){
		return SUCCESS;
	}
	public String toblDetail(){
		return SUCCESS;
	}
	public String toContentDescr(){
		return SUCCESS;
	}
	/**
	 * 私有方法
	 * @return
	 * @throws IOException 
	 */
	private void uploadDoc(InputStream is,String fileFileName,String blid,String type) throws IOException{
		String root = ServletActionContext.getServletContext().getRealPath("/images/upload");
        OutputStream os;
        String filePath = root;
		try {
			//检查目录
	    	File uploadDir = new File(filePath);
	    	if(!uploadDir.isDirectory()){
	    		uploadDir.mkdir();
	    	}
	    	attaceMent = new FileInfo();
			os = new FileOutputStream(new File(filePath, fileFileName));
			attaceMent.setSaveName(fileFileName);
	    	//检查目录写权限
			attaceMent.setFilePath(filePath);
			attaceMent.setId(null);
			attaceMent.setResourceType(type);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String fDate = df.format(date);
			attaceMent.setFileUpdateTime(fDate);
			attaceMent.setBgq(fDate.substring(0, 4));
			attaceMent.setResourceId(blid);
			fileSeriveimpl.saveFileInformation(attaceMent);
			byte[] buffer = new byte[500];
			int length = 0;
			while(-1 != (length = is.read(buffer, 0, buffer.length)))
			{
				os.write(buffer);
			}
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	} 
	/**
	 * 保存笔录的私有方法
	 * @return
	 * @throws ParseException
	 */
	private String saveBlMethod(String status,String blNum) throws ParseException{
		BlxxModel  blModel = new BlxxModel();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd hh:mm");
		BeCheckedUnit  beCheckedUnit = becheckUnitService
				.findBeCheckedUnitByName(blxxDetailBean.getBeCheckedUnit());
		blModel.setBecheckedunit(beCheckedUnit);
		blModel.setStarttime(sdf.parse(blxxDetailBean.getStartTime()));
		blModel.setEndtime(sdf.parse(blxxDetailBean.getEndTime()));
		blModel.setDetailaddress(blxxDetailBean.getDetailAddress());
		blModel.setCheckpersoncode(blxxDetailBean.getCheckMan());
		blModel.setCheckunitcode(blxxDetailBean.getCheckUnit());
		blModel.setPartyname(blxxDetailBean.getPartyMan());
		blModel.setReasonsandpurpose(blxxDetailBean.getReasonsAndPurpose());
		blModel.setIssafety(blxxDetailBean.getIssafety());
		blModel.setCheckstyle(blxxDetailBean.getCheckstyle());
		blModel.setCheckprocess(blxxDetailBean.getCheckprocess());
		blModel.setCheckBasis(blxxDetailBean.getCheckBasis());
		blModel.setCheckcontents(blxxDetailBean.getPocessAndResult());
		blModel.setWitness("无");
		blModel.setCheckdetail(blxxDetailBean.getCheckResult());
		blModel.setStatus(status);
		if(null != blNum){
			blModel.setBlCode(blNum);
		}
		return blglServiceImpl.saveBlxx(blModel);
	}
	/**
	 * 生成笔录
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	private InputStream generateBl() throws ParseException{
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdfend =  new SimpleDateFormat("yyyy年MM月dd日");
		Map<String, Object> map = new HashMap<String, Object>();
		Date startDate = df.parse(blxxDetailBean.getStartTime());
		map.put("n1", sdf.format(startDate));
		Date endDate = df.parse(blxxDetailBean.getEndTime());
		map.put("n2", sdf.format(endDate));
		map.put("n3", blxxDetailBean.getDetailAddress());
		String checkMans = blxxDetailBean.getCheckMan();
		String[] checkMan = checkMans.split(",");
		String checkManstr = "";
		for(int i = 0; i < checkMan.length; i++){
			String[] arr = checkMan[i].split("\\s+");
			checkManstr += " " + arr[0];
		}
		map.put("n4",checkMans);
		//map.put("n5", blxxDetailBean.getCheckUnit());
		map.put("n6", blxxDetailBean.getBeCheckedUnit());
		map.put("n7", blxxDetailBean.getPartyMan());
		map.put("n8", blxxDetailBean.getPocessAndResult());
		//map.put("n9", checkManstr);
		//map.put("n10", sdfend.format(new Date()).toString());
		if(null != blxxDetailBean.getPartyMan() &&  !blxxDetailBean.getPartyMan().isEmpty()){
			String[] a = blxxDetailBean.getPartyMan().split("\\s+");//匹配空格
			//map.put("n11", a[0]);
		}
		//map.put("n12",sdfend.format(new Date()).toString());
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("a1", map);
		System.out.println(this.getRequest().getSession().getServletContext()
				.getRealPath("/"));
		ReportConfig rc = poiCrReportBuilder.createFromXmlFile(map1, this
				.getRequest().getSession().getServletContext().getRealPath("/")
				+ "WEB-INF"
				+ File.separator
				+ "printabout"
				+ File.separator
				+ "test.xml");
		PoiCrReport report = new PoiCrReport(rc);
		poiCrReportBuilder.build(report);
		InputStream is = report.generateReportInputStream();
		return is;
	}
	private static byte[] toByteArray(InputStream input) throws IOException {
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    byte[] buffer = new byte[4096];
	    int n = 0;
	    while (-1 != (n = input.read(buffer))) {
	        output.write(buffer, 0, n);
	    }
	    return output.toByteArray();
	}
	/*get&set方法*/
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getUnitIds() {
		return unitIds;
	}
	public void setUnitIds(String unitIds) {
		this.unitIds = unitIds;
	}
	public String getCheckAccorId() {
		return checkAccorId;
	}
	public void setCheckAccorId(String checkAccorId) {
		this.checkAccorId = checkAccorId;
	}
	public DictionaryItem getAccor() {
		return accor;
	}
	public void setAccor(DictionaryItem accor) {
		this.accor = accor;
	}
	public String getPartyUnit() {
		return partyUnit;
	}
	public void setPartyUnit(String partyUnit) {
		this.partyUnit = partyUnit;
	}
	public DictionaryItem getUnit() {
		return unit;
	}
	public void setUnit(DictionaryItem unit) {
		this.unit = unit;
	}
	public String getCheckManName() {
		return checkManName;
	}
	public void setCheckManName(String checkManName) {
		this.checkManName = checkManName;
	}
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
	public BlxxDetailBean getBlxxDetailBean() {
		return blxxDetailBean;
	}
	public void setBlxxDetailBean(BlxxDetailBean blxxDetailBean) {
		this.blxxDetailBean = blxxDetailBean;
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
	public File getFileSign() {
		return fileSign;
	}
	public void setFileSign(File fileSign) {
		this.fileSign = fileSign;
	}
	public String getFileSignFileName() {
		return fileSignFileName;
	}
	public void setFileSignFileName(String fileSignFileName) {
		this.fileSignFileName = fileSignFileName;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<BeCheckedUnit> getBeCheckLits() {
		return beCheckLits;
	}
	public void setBeCheckLits(List<BeCheckedUnit> beCheckLits) {
		this.beCheckLits = beCheckLits;
	}
	public List<BelongIndustryBean> getBelongIndustryListBean() {
		return belongIndustryListBean;
	}
	public void setBelongIndustryListBean(
			List<BelongIndustryBean> belongIndustryListBean) {
		this.belongIndustryListBean = belongIndustryListBean;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<CheckContentBean> getCheckContentList() {
		return checkContentList;
	}
	public void setCheckContentList(List<CheckContentBean> checkContentList) {
		this.checkContentList = checkContentList;
	}

}
