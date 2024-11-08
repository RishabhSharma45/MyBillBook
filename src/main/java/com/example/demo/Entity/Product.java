package com.example.demo.Entity;

public class Product {
	
	private String productname;
	private int rate;
	private int quantity;
	
	private String batch;
	private String expiry;
	private String hsn;
	private String mrp;
	private String cd;
	private String sd;
	
	
	public Product() {
		
	}
	public Product(String productname, int rate, int quantity , int amount) {
		super();
		this.productname = productname;
		this.rate = rate;
		this.quantity = quantity;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	  public int getAmount() {
	        return this.rate * this.quantity;
	    }
	  
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getHsn() {
		return hsn;
	}
	public void setHsn(String hsn) {
		this.hsn = hsn;
	}
	public String getMrp() {
		return mrp;
	}
	public void setMrp(String mrp) {
		this.mrp = mrp;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getSd() {
		return sd;
	}
	public void setSd(String sd) {
		this.sd = sd;
	}
	@Override
	public String toString() {
		return "Product [productname=" + productname + ", rate=" + rate + ", quantity=" + quantity + "]";
	}
	
	
	

}
