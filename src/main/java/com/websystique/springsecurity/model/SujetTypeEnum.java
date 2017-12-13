package com.websystique.springsecurity.model;

import java.io.Serializable;

public enum SujetTypeEnum implements Serializable {
	DOMESTIQUE("DOMESTIQUE"),
	ALIMENTAIRE("ALIMENTAIRE");
	
	String sujetTypeEnum;
	
	private SujetTypeEnum(String sujetTypeEnum) {
		this.sujetTypeEnum = sujetTypeEnum;
	}
	
	public String getSujetTypeEnum() {
		return sujetTypeEnum;
	}	
}
