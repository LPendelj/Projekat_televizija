package main;

import java.util.Scanner;

import util.UserRepository;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void login() {
		System.out.println("Unesite korisnicko ime:");
		
		boolean korekt = false;
		
		while(!korekt) {
		String user = sc.nextLine();
		
		System.out.println("Unesite sifru");
		
		String pass = sc.nextLine();
		
		
		UserRepository repo = new UserRepository();
		if(repo.getUserByUsername(user) == null) {
			System.out.println("user or password are not correct");
		} else {
			if(repo.getUserByUsername(user).getPassword().equalsIgnoreCase(pass)) {
				
			};
		}
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
