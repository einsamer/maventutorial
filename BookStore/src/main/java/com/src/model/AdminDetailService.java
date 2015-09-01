package com.src.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.src.entity.Account;

@Service("adminDetailService")
public class AdminDetailService implements UserDetailsService {

	@Autowired
	UserDAOImp userDAOImp;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.src.entity.Account user = userDAOImp.findUserFromName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

		return buildUserFromAuthentication(user, authorities);
	}

	private User buildUserFromAuthentication(Account user, List<GrantedAuthority> authorities) {

		System.out.println("buildUserFromAuthentication " + authorities.get(0).toString());
		return new User(user.getUsername(), user.getPassword(), user.isEnable(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(int role) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		setAuths.add(new SimpleGrantedAuthority(getRoleFrom(role)));
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		System.out.println("buildUserAuthority " + Result.get(0).toString());

		return Result;
	}

	private String getRoleFrom(int role) {

		String role_name = "guest";
		switch (role) {
		case 1:
			role_name = "ROLE_ADMIN";
			break;
		case 2:
			role_name = "DBA";
			break;

		}
		return role_name;
	}

}
