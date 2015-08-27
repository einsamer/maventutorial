package com.src.model;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.User;

public class UserDAOImp implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public User checkLogin(User user) {
		// TODO Auto-generated method stub
		
		String raw_query = "from User where username = '%s' and password = '%s'";
		
		String user_query = String.format(raw_query, user.getUsername(), user.getPassword());
		
		Session session = this.sessionFactory.getCurrentSession();
		
		List<User> users = session.createQuery(user_query).list();
		
		if ( users.size() > 0) {
			User tmp = users.get(0);
			
			user.setId(tmp.getId());
			user.setName(tmp.getName());
			user.setPassword("untouchable");
			user.setRole(tmp.getRole());
			
		} else {
			user.setRole(666);
		}
		
		System.out.println(user.toString());
		return user;
	}

}
