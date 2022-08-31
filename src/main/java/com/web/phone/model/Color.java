package com.web.phone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Color {
	
	@Id
	private String id;
	private String name;
	private String hexCode;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHexCode() {
		return hexCode;
	}
	public void setHexCode(String hexCode) {
		this.hexCode = hexCode;
	}
	
	

}
