package com.src.model;

import com.src.entity.Account;

public interface UserDAO {
	public Account checkLogin(Account user);
	public Account findUserFromName(String username);

}
