package com.src.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.Book;

public class BookDAOImp implements BookDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void saveOrUpdate(Book book) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(book);
		
	}

	@Transactional
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub

		Session session = this.sessionFactory.getCurrentSession();
		List<Book> books = session.createQuery("from Book").list();
		
		return books;
	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		
			Session session = this.sessionFactory.getCurrentSession();
			Book book = (Book) session.load(Book.class, new Integer(id));
		
		if (book != null) {
			session.delete(book);
			System.out.println("deleted!");
		} else {
			System.out.println("cannot find that book!");
		}
		
	}

	public Book getBook(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Book book = (Book) session.load(Book.class, new Integer(id));
		return book;
	}

}
