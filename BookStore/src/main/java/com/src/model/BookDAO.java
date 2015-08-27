package com.src.model;

import java.util.List;

import com.src.entity.Book;

public interface BookDAO {
	public void saveOrUpdate(Book book);
	public List<Book> getAllBook();
	public void delete(int id);
	public Book getBook (int id);
	public List<Book> getAllBookWithKey(String key);
}
