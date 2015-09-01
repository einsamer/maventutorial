package com.src.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.Account;

public class UserDAOImp implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Account checkLogin(Account user) {

		String raw_query = "from User where username = '%s' and password = '%s'";

		String user_query = String.format(raw_query, user.getUsername(), user.getPassword());

		Session session = this.sessionFactory.getCurrentSession();

		List<Account> users = session.createQuery(user_query).list();

		if (users.size() > 0) {
			Account tmp = users.get(0);

			user.setId(tmp.getId());
			user.setName(tmp.getName());
			user.setPassword("untouchable");
			user.setEnable(tmp.isEnable());
			user.setRole(tmp.getRole());

		} else {
			user.setRole(666);
		}

		System.out.println(user.toString());
		return user;
	}

	@Transactional
	public Account findUserFromName(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		String raw_query = "from User where username = '%s'";
		System.out.println(raw_query);
		String user_query = String.format(raw_query, username);
		List<Account> users = session.createQuery(user_query).list();
		if (users.size() > 0) {
			Account user = users.get(0);
			System.out.println(user.toString());
			return user;
		} else {
			return null;
		}

	}

}
