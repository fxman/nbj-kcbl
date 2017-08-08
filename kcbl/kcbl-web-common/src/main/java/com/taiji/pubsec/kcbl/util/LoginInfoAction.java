package com.taiji.pubsec.kcbl.util;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.taiji.pubsec.businesscomponent.organization.model.Organization;
import com.taiji.pubsec.businesscomponent.organization.model.Person;
import com.taiji.pubsec.businesscomponent.organization.service.IOrganizationService;
import com.taiji.pubsec.businesscomponent.organization.service.IPersonService;
import com.taiji.pubsec.common.web.action.BaseAction;
import com.taiji.pubsec.springsecurity.resource.util.MySecureUser;
import com.taiji.pubsec.springsecurity.resource.util.SessionUserDetailsUtil;

public class LoginInfoAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private IOrganizationService organizationService;
	@Resource
	private IPersonService personService;
	
	@SuppressWarnings("unchecked")
	protected Person findCurrentPerson(){
		MySecureUser user = SessionUserDetailsUtil.getMySecureUser() ;
		Map<String, Object> userMap = user.getUserMap() ;
		Map<String, String> mPerson = new HashMap<String, String>(0) ;
		if(userMap.get("person")!=null){
			mPerson = (Map<String, String>)userMap.get("person");
		}
		return personService.findById(mPerson.get("id"));
	}
	@SuppressWarnings("unchecked")
	protected Organization findCurrentOrganization(){
		MySecureUser user = SessionUserDetailsUtil.getMySecureUser() ;
		Map<String, Object> userMap = user.getUserMap() ;
		Map<String, String> mOrg = new HashMap<String, String>(0) ;
		if(userMap.get("org")!=null){
			mOrg = (Map<String, String>)userMap.get("org");
		}
		return organizationService.findOrganizationById(mOrg.get("id"));
	}
	
	
	/**
	 * 获取客户端的ip
	 * @param request
	 * @return
	 */
	private  String getIp() {
		HttpServletRequest request =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
}
