package com.taiji.pubsec.kcbl.print;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.taiji.pubsec.common.tools.doc.core.model.ReportConfig;
import com.taiji.pubsec.common.tools.doc.msoffice.impl.poicr.builder.PoiCrReportBuilder;
import com.taiji.pubsec.common.tools.doc.msoffice.impl.poicr.reporter.PoiCrReport;
import com.taiji.pubsec.kcbl.bean.BlxxDetailBean;
import com.taiji.pubsec.kcbl.util.ReturnMessageAction;

@Controller("printAction")
@Scope("prototype")
public class PrintAction extends ReturnMessageAction {
	private String fileName;
	private BlxxDetailBean blxxDetailBean;
	private String filePath;
	private InputStream loadFile;
	
	@Resource
	private PoiCrReportBuilder poiCrReportBuilder;

	public String printBlxx() throws IOException {
		String root = ServletActionContext.getServletContext().getRealPath("/images/tempFileUpLoad");
        OutputStream os;
        SimpleDateFormat sdfSaveName =  new SimpleDateFormat("yyyyMMddhhmmss");
		try{
			SimpleDateFormat sdf =  new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
			SimpleDateFormat sdfend =  new SimpleDateFormat("yyyy年MM月dd日");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
			map.put("n4", checkMans);
			//map.put("n5", blxxDetailBean.getCheckUnit());
			map.put("n6", blxxDetailBean.getBeCheckedUnit());
			map.put("n7",  blxxDetailBean.getPartyMan());
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
					+ "testTemp.xml");
			PoiCrReport report = new PoiCrReport(rc);
			poiCrReportBuilder.build(report);
			InputStream is = report.generateReportInputStream();
			//检查目录
	    	File uploadDir = new File(root);
	    	if(!uploadDir.isDirectory()){
	    		uploadDir.mkdir();
	    	}
	    	fileName = "nbjbl"+sdfSaveName.format(new Date())+".docx";
	    	os = new FileOutputStream(new File(root, fileName));
	    	byte[] buffer = new byte[500];
			int length = 0;
			while(-1 != (length = is.read(buffer, 0, buffer.length)))
			{
				os.write(buffer);
			}
			filePath = root+File.separatorChar+fileName;
	    	os.flush();
			os.close();
			is.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS; 
	}
    public String  fetchLoadFile() throws IOException{
    	String root = ServletActionContext.getServletContext().getRealPath("/images/tempFileUpLoad");
    	InputStream inputStream = null;
    	ServletOutputStream servletOutputStream = null;
    	HttpServletResponse response= ServletActionContext.getResponse();
    	File f = new File(root + File.separator + fileName);
    	System.out.println(fileName);
    	System.out.println(f.length());
    	response.reset();
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ URLEncoder.encode(fileName, "UTF-8"));
		response.setHeader("Content-Length", String.valueOf(f.length()));
		response.setContentType("application/octet-stream");
		servletOutputStream = response.getOutputStream();
		int byteRead = 0;
		byte[] buffer = new byte[1024 * 1024 * 10];
		inputStream = new BufferedInputStream(new FileInputStream(f));
		while ((byteRead = inputStream.read(buffer)) != -1) {
			servletOutputStream.write(buffer, 0, byteRead);
		}
    	return null;
    }
	public BlxxDetailBean getBlxxDetailBean() {
		return blxxDetailBean;
	}
	public void setBlxxDetailBean(BlxxDetailBean blxxDetailBean) {
		this.blxxDetailBean = blxxDetailBean;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public InputStream getLoadFile() {
		return loadFile;
	}
	public void setLoadFile(InputStream loadFile) {
		this.loadFile = loadFile;
	}
}
