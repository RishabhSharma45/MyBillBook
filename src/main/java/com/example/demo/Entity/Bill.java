package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

public class Bill {
	
	private String customer;
	private String address;
	private String date;
    private List<Product> products = new ArrayList<>();
	public Bill() {
		
	}
	public Bill(String customer, String address, String date, List<Product> products) {
		super();
		this.customer = customer;
		this.address = address;
		this.date = date;
		this.products = products;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public int subTotal() {
		int ans = 0;
		for(int i=0;i<products.size();i++) {
			ans = ans + products.get(i).getAmount();
		}
		return ans;
	}
	
	public int gst() {
		return (this.subTotal()/100)*12;
	}
	
	public int grandTotal() {
		return this.subTotal()+this.gst();
	}
	
	@Override
	public String toString() {
		return "Bill [customer=" + customer + ", address=" + address + ", date=" + date + ", products=" + products
				+ "]";
	}
}