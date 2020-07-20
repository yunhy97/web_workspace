package com.bookstore.dto;

import java.util.Date;

public class UserDetailDTO {
	private int no;
	private int bookNo;
	private String userId;
	private String title;
	private int price;
	private int amount;
	private int orderPrice;
	private Date registeredDate;
	
	public UserDetailDTO() {}

	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBookNo() {
		return bookNo;
	}
	
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getOrderPrice() {
		return orderPrice;
	}
	
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	
	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	
	
}