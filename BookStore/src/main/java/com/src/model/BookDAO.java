package com.src.model;

import java.util.List;

import com.src.entity.Book;

public interface BookDAO<T> {
	public void saveOrUpdate(T book);
	public List<T> getAllBook();
	public void delete(int id);
	public T getBook (int id);
	public List<T> getAllBookWithKey(String key);
}
