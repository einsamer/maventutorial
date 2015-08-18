package com.src.model;

import java.util.List;

import com.src.entity.Book;

public interface BookDAO {
	public List<Book> getBook();
	public void insertBook(String name, String URL);
	public void deleteBook(int id);
	public void updateBook(Book book);
}
