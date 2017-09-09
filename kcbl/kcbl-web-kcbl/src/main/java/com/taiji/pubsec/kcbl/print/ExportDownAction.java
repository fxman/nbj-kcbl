package com.taiji.pubsec.kcbl.print;


import java.io.InputStream;
import java.net.URLEncoder;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.taiji.pubsec.common.web.action.BaseAction;
import com.taiji.pubsec.common.web.action.ExportInfoReq;
@Controller("exportDownAction")
@Scope("prototype")
public class ExportDownAction extends BaseAction{

	    public ExportDownAction()
	    {
	        exportInfoReq = new ExportInfoReq();
	    }

	    public String export()
	        throws Exception
	    {
	        return "success";
	    }

	    public InputStream getDocFile()
	        throws Exception
	    {
	        docName = exportInfoReq.getName();
	        String type = docName.substring(docName.lastIndexOf(".") + 1);
	        if(exportInfoReq.getLength() != null)
	            setContLength(String.valueOf(exportInfoReq.getLength()));
	        if(type.equals("xls") || type.equals("xlsx"))
	            setDocType("application/vnd.ms-excel");
	        else
	        if(type.equals("docx") || type.equals("doc"))
	            setDocType("application/vnd.ms-word");
	        else
	            setDocType("application/octet-stream");
	        docName = URLEncoder.encode(docName, "utf-8");
	        return exportInfoReq.getIn();
	    }
	    public ExportInfoReq getExportInfoReq()
	    {
	        return exportInfoReq;
	    }

	    public void setExportInfoReq(ExportInfoReq exportInfoReq)
	    {
	        this.exportInfoReq = exportInfoReq;
	    }

	    public String getDocName()
	    {
	        return docName;
	    }

	    public void setDocName(String docName)
	    {
	        this.docName = docName;
	    }

	    public String getDocType()
	    {
	        return docType;
	    }

	    public void setDocType(String docType)
	    {
	        this.docType = docType;
	    }

	    public String getContLength()
	    {
	        return contLength;
	    }

	    public void setContLength(String contLength)
	    {
	        this.contLength = contLength;
	    }

	    private ExportInfoReq exportInfoReq;
	    private String docName;
	    private String docType;
	    private String contLength;
	
}
