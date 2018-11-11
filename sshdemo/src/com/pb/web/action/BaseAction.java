package com.pb.web.action;

import java.util.Map;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware {
	protected Map<String, Object> request; // request
	protected Map<String, Object> session; // session
	protected Map<String, Object> application; // application

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
