package com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "User")
@Table(name = "tbl_user")
public class Account {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "user_username")
	@Size(min = 3, max = 50)
	@NotNull
	private String username;

	@Column(name = "user_name")
	@Size(min = 3, max = 50)
	@NotNull
	private String name;

	@Column(name = "user_password")
	@Size(min = 3, max = 50)
	@NotNull
	private String password;

	@Column(name = "user_role")
	private int role;

	@Column(name = "user_enable")
	private boolean enable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String username, String name, String password, int role, boolean enable) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.role = role;
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password + ", role="
				+ role + ", enable=" + enable + "]";
	}

}
