package com.taiji.pubsec.kcbl.attachment.action;

import java.io.InputStream;

import com.taiji.pubsec.businesscomponent.attachment.AttachmentCopy;
import com.taiji.pubsec.businesscomponent.attachment.AttachmentMeta;
import com.taiji.pubsec.common.tool.spring.SpringContextUtil;
import com.taiji.pubsec.common.web.action.ExportInfoReq;
import com.taiji.pubsec.kcbl.attach.model.Attachment;
import com.taiji.pubsec.kcbl.attachment.service.IAttachmentCustomizedService;

public class AttachmentHandler {
	
	public static ExportInfoReq makeExportInfoReqByAttachmentId(String attachmentId){
		IAttachmentCustomizedService service = (IAttachmentCustomizedService)SpringContextUtil.getBean("attachmentCustomizedService") ;
		Attachment entity = service.findById(attachmentId) ;
		
		AttachmentMeta attaMeta = entity.getAttachmentMeta() ;
		
		InputStream in = null;
		
		ExportInfoReq req = new ExportInfoReq();
		
		if(attaMeta.getAttachmentCopys().size()>0){
			AttachmentCopy ac = attaMeta.getAttachmentCopys().get(0) ;
			in = ac.getInputStream();
			req.setIn(in);
			req.setName(attaMeta.getName());
			req.setLength(Long.valueOf(ac.getProperty("filelenth").toString()));
		}
		return req ;
	}

}
