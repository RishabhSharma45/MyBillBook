package com.example.demo.Entity;

public class ProductDetails {
	
	private String productname;
	private String pack;
	private String batch;
	private String expiry;
	private String hsn;
	private String mrp;
	private String cd;
	private String sd;
	
	public ProductDetails() {
	}

	public ProductDetails(String productname, String pack, String batch, String expiry, String hsn, String mrp, String cd,
			String sd) {
		this.productname = productname;
		this.pack=pack;
		this.batch = batch;
		this.expiry = expiry;
		this.hsn = hsn;
		this.mrp = mrp;
		this.cd = cd;
		this.sd = sd;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
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
		return "ProductDetails [productname=" + productname + ", batch=" + batch + ", expiry=" + expiry + ", hsn=" + hsn
				+ ", mrp=" + mrp + ", cd=" + cd + ", sd=" + sd + "]";
	}
	
	
	
}
