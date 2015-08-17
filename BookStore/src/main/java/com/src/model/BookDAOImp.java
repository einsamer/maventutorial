package com.src.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.src.entity.Book;

public class BookDAOImp implements BookDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Book book) {
		// TODO Auto-generated method stub
		
	}

	public List<Book> getAllBook() {
		// TODO Auto-generated method stub

		Session session = this.sessionFactory.openSession();
		List<Book> books = session.createQuery("from Book").list();
		session.close();
		
		return books;
	}

}
