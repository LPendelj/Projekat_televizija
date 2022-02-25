package model;

import util.Role;

public class User {
	final private String firstName;
	final private String lastName;
	final private String userName;
	final private String password;
	final private Role role;

	public User(String firstName, String lastName, String userName, String password, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", role=" + role
				+ "]";
	}

}
