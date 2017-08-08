package com.taiji.pubsec.kcbl.xtgl.print;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.taiji.pubsec.common.tools.doc.core.model.ReportConfig;
import com.taiji.pubsec.common.tools.doc.msoffice.impl.poicr.builder.PoiCrReportBuilder;
import com.taiji.pubsec.common.tools.doc.msoffice.impl.poicr.reporter.PoiCrReport;
import com.taiji.pubsec.common.web.action.ExportInfoReq;
import com.taiji.pubsec.kcbl.util.ReturnMessageAction;

@Controller("printAction")
@Scope("prototype")
public class PrintAction extends ReturnMessageAction {
	private String docName;
	private String docType;
	private String contLength;
	private InputStream docFile;
	@Resource
	private PoiCrReportBuilder poiCrReportBuilder;
	private ExportInfoReq exportInfoReq = new ExportInfoReq();

	public String printBlxx() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("n1", "内保局");
		map.put("n2", "赖仁俊");
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
		try {
			exportInfoReq
					.setLength(Long.valueOf(String.valueOf(is.available())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		exportInfoReq.setIn(is);
		exportInfoReq.setName("test.docx");
		docName = exportInfoReq.getName();
		String type = docName.substring(docName.lastIndexOf(".") + 1);
		if (exportInfoReq.getLength() != null)
			setContLength(String.valueOf(exportInfoReq.getLength()));
		if (exportInfoReq.getLength() != null)
			setContLength(String.valueOf(exportInfoReq.getLength()));
		if (type.equals("xls") || type.equals("xlsx"))
			setDocType("application/vnd.ms-excel");
		else if (type.equals("docx") || type.equals("doc"))
			setDocType("application/vnd.ms-word");
		else
			setDocType("application/octet-stream");
		docName = URLEncoder.encode(docName, "utf-8");
		docFile = exportInfoReq.getIn();
		return "success";
	}
	public InputStream getDocFile() throws Exception {
		return this.docFile;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getContLength() {
		return contLength;
	}

	public void setContLength(String contLength) {
		this.contLength = contLength;
	}
	public void setDocFile(InputStream docFile) {
		this.docFile = docFile;
	}
}
