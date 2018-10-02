package dev.viplove.springbootstarter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="USER_NAM_MAP")
public class User {

	@Id
	@Column(name="USER_NAM")
	String username;
	
	@Column(name="PWD")
	String password;
	
	@Column(name="ROLE")
	String role;

	public User(User u) {
		username = u.getUsername();
		password = u.getPassword();
		role = u.getRole();
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
