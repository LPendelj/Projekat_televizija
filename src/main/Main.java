package main;

import model.User;
import util.Role;

public class Main {

	public static void main(String[] args) {
		User startingUser = new User("Luka", "Pendelj", "luka", "luka123", Role.ADMIN);
		// UserRepository userRepository = new UserRepository(new ArrayList<User>());
		// userRepository.add(startingUser);
		// login();
	}

}
