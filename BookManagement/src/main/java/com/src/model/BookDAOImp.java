package com.src.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.src.entity.Book;
import com.src.mapper.BookMapper;

public class BookDAOImp implements BookDAO{
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTmp;
	


	@Override
	public List<Book> getBook() {
		// TODO Auto-generated method stub
		
		String sql = "select * from tbl_book";
		
		jdbcTmp = new JdbcTemplate(dataSource);
		List<Book> listbook = jdbcTmp.query(sql, new BookMapper());
		
		return listbook;
	}

	@Override
	public void insertBook(String name, String URL, int price) {
		// TODO Auto-generated method stub
		jdbcTmp = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO tbl_book (bookname, bookimgurl, bookprice) values (?,?,?)";
		
		try{
			int num = jdbcTmp.update(sql, name, URL, price);
			System.out.println(num);
		}catch(Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		jdbcTmp = new JdbcTemplate(dataSource);
		String sql = "DELETE FROM tbl_book where bookid = ?";
		
		try{
			int num = jdbcTmp.update(sql,id);
			System.out.println(num);
		}catch(Exception e) {
			System.err.println(e);
		}
		
		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		jdbcTmp = new JdbcTemplate(dataSource);
		String sql = "Update tbl_book set bookname = ? , bookimgurl = ?, bookprice = ? where bookid = ?";
		
		int num = jdbcTmp.update(sql, book.getBookname(), book.getBookimgurl(), book.getBookprice(), book.getBookid());
		
		System.out.println(num);
		
	}

}
