package com.src.entity;

public class Book {
	
	private int bookid;
	private String bookname;
	private String bookimgurl;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookid, String bookname, String bookimgurl) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookimgurl = bookimgurl;
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
	
	

}
