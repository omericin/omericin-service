package com.web.phone.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.web.phone.dto.BrandColorRequestDTO;
import com.web.phone.dto.BrandStorageRequestDTO;

@Document
public class Brand {
	
    @Id
    private String id;
    private String deviceId;
    private String name;
    private String image;
    private List<BrandColorRequestDTO> colorList;
    private List<BrandStorageRequestDTO> storageList;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<BrandColorRequestDTO> getColorList() {
		return colorList;
	}
	public void setColorList(List<BrandColorRequestDTO> colorList) {
		this.colorList = colorList;
	}
	public List<BrandStorageRequestDTO> getStorageList() {
		return storageList;
	}
	public void setStorageList(List<BrandStorageRequestDTO> storageList) {
		this.storageList = storageList;
	}

}
