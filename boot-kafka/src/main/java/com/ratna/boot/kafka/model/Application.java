package com.ratna.boot.kafka.model;


public class Application {

	private String product;
	private String status;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Application [product=" + product + ", status=" + status + "]";
	}
	
	
}
