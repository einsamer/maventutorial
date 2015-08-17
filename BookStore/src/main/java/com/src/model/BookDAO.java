package com.src.model;

import java.util.List;

import com.src.entity.Book;

public interface BookDAO {
	public void save(Book book);
	public List<Book> getAllBook();
}
