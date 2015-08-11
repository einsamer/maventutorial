package com.src.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.src.entity.Book;
import com.src.map.BookMapper;

public class BookDAOImp implements BookDAO{
	
	DataSource dataSource;
	JdbcTemplate jdbcTmp;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTmp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Book> getBook() {
		// TODO Auto-generated method stub
		
		String sql = "select * from tbl_book";
		
		List<Book> listbook = jdbcTmp.query(sql, new BookMapper());
		
		return listbook;
	}

	@Override
	public void insertBook(String name, String URL) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tbl_book (bookname, bookimgurl) values (?,?)";
		
		try{
			int num = jdbcTmp.update(sql, name, URL);
			System.out.println(num);
		}catch(Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		
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
		
		String sql = "Update tbl_book set bookname = ? , bookimgurl = ? where bookid = ?";
		
		int num = jdbcTmp.update(sql, book.getBookname(), book.getBookimgurl(), book.getBookid());
		
		System.out.println(num);
		
	}

}
