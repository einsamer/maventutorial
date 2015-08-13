package com.src.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Book {

	private int bookid;

	@NotEmpty(message = "Please enter name of book")
	private String bookname;

	@NotEmpty(message = "Please enter image url of book")
	@Size(min = 6, max = 500, message = "length of link is too short or too long")
	private String bookimgurl;

	@Min(0)
	private int bookprice;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookid, String bookname, String bookimgurl, int bookprice) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookimgurl = bookimgurl;
		this.bookprice = bookprice;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookimgurl() {
		return bookimgurl;
	}

	public void setBookimgurl(String bookimgurl) {
		this.bookimgurl = bookimgurl;
	}

	public int getBookprice() {
		return bookprice;
	}

	public void setBookprice(int bookprice) {
		this.bookprice = bookprice;
	}

}
