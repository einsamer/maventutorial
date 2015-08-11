package com.src.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.src.entity.Book;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Book book = new Book();
		
		book.setBookid(rs.getInt("bookid"));
		book.setBookname(rs.getString("bookname"));
		book.setBookimgurl(rs.getString("bookimgurl"));
		
		return book;
	}

}
