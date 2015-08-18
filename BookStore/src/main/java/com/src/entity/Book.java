package com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookid")
	private int bookid;

	@Column(name = "bookname")
	@NotNull
	@Size(min = 1,max = 50)
	private String bookname;

	@Column(name = "bookauthor")
	@NotNull
	@Size(min = 2,max = 50)
	private String bookauthor;

	@Column(name = "bookimgurl")
	@NotNull
	@Size(min = 5,max = 500)
	private String bookimgurl;

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

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookid, String bookname, String bookauthor, String bookimgurl) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
		this.bookimgurl = bookimgurl;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", bookauthor=" + bookauthor + ", bookimgurl="
				+ bookimgurl + "]";
	}

}
