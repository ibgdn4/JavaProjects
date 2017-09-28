package com.struts2.tiles;

import com.opensymphony.xwork2.ActionSupport;

public class LinkAction extends ActionSupport{
	private static final long serialVersionUID = 1l;
	
	public String welcome() {
		return "welcome";
	}
	
	public String friends() {
		return "friends";
	}
	
	public String office() {
		return "office";
	}
}
