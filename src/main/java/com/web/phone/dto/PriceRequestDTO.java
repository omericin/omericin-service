package com.web.phone.dto;

public class PriceRequestDTO {
	
	private String Id;
	private String brandId;
	private String size;
	private String status;
	private String price;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	

}
