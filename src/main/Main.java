package main;


import java.util.ArrayList;
import java.util.Scanner;

import util.UserRepository;

import model.User;
import util.Role;


public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void login(UserRepository repo) {
		System.out.println("Unesite korisnicko ime:");
		
		boolean korekt = false;
		
		while(!korekt) {
		String user = sc.nextLine();
		
		System.out.println("Unesite sifru");
		
		String pass = sc.nextLine();
		
		if(repo.getUserByUsername(user) == null) {
			System.out.println("user or password are not correct");
		} else {
			if(repo.getUserByUsername(user).getPassword().equalsIgnoreCase(pass)) {
				
			};
		}
	}
	}

	public static void main(String[] args) {
		User startingUser = new User("Luka", "Pendelj", "luka", "luka123", Role.ADMIN);
		 UserRepository userRepository = new UserRepository(new ArrayList<User>());
		// userRepository.add(startingUser);
		// login();
	}

}
