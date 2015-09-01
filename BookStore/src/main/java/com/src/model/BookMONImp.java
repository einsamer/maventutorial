package com.src.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.src.entity.BookMON;

public class BookMONImp implements BookDAO<BookMON> {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void saveOrUpdate(BookMON book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookMON> getAllBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BookMON getBook(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookMON> getAllBookWithKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
