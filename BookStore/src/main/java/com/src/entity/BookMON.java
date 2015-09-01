package com.src.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class BookMON {
	
	@Id
	private String _id;
	
	private int bookid;

	private String bookname;

	private String bookauthor;

	private String bookimgurl;
	



	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public String getBookauthor() {
		return bookauthor;
	}

	public String getBookimgurl() {
		return bookimgurl;
	}

	public void setBookimgurl(String bookimgurl) {
		this.bookimgurl = bookimgurl;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public BookMON() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookMON(int bookid, String bookname, String bookauthor, String bookimgurl) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
		this.bookimgurl = bookimgurl;
	}
	
	

	public BookMON(String _id, int bookid, String bookname, String bookauthor, String bookimgurl) {
		super();
		this._id = _id;
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
		this.bookimgurl = bookimgurl;
	}

	@Override
	public String toString() {
		return "BookMON [_id=" + _id + ", bookid=" + bookid + ", bookname=" + bookname + ", bookauthor=" + bookauthor
				+ ", bookimgurl=" + bookimgurl + "]";
	}

	
	
}
