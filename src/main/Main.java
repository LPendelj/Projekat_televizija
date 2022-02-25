package main;


import java.util.ArrayList;
import java.util.Scanner;

import util.UserRepository;

import model.User;
import util.AdminMenu;
import util.EditorMenu;
import util.Role;


public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void login(UserRepository repo) {
		//pokazivac za izlaz iz  petlje
		boolean correct = false;
		//kontrola broja pokusaja
		int numberOfTries = 0;
		
		User u;
		
		//glavna petlja za logovanje. U okviru nje se pokrece Admin menu, ako su kredencijali ispravni
		while(!correct && numberOfTries < 4) {
		System.out.println("Enter username");
	
		
		String user = sc.nextLine();
		
		System.out.println("Enter Password");
		
		
		
		String pass = sc.nextLine();
		
		if(repo.get(user) == null) {
			//brojac pokuksaja raste jer korisnik ne postoji u sistemu.
			numberOfTries++;
			System.out.println("Username and/or password are not correct");
		} else {
			if(repo.get(user).getPassword().equals(pass)) {
				//System.out.println("dobra lozinka");
				correct = true;
				u = repo.get(user);
				if(u.getRole()==Role.ADMIN) {
					//System.out.println("korisnik je admin");
					AdminMenu am = new AdminMenu(repo, sc, u);
					//pokrece se admin menu
					am.startAdminMenu();
						} else {
							//prazna implementacija. Mogao bi da ima opciju da se vide korisnici.
							EditorMenu.startEditorMenu();
						}
					}  else {
				//zbog pogresne lozinke povecava se brojac pokusaja
				numberOfTries++;
				System.out.println("Username and/or password are not correct");
					} 
			
				}
		
		}
		
		System.out.println("You have entered too many wrong answers. App is locked");
		System.exit(0);
		
		
	}

	public static void main(String[] args) {
		//Dodata su dva startna korisnika.
		User startingUser = new User("Luka", "Pendelj", "luka", "luka123", Role.ADMIN);
		User editor = new User("Nenad", "Novitovic", "nesa", "nesa123", Role.EDITOR);
		
		//Formiran je repozitorijum
		 UserRepository userRepository = new UserRepository(new ArrayList<User>());
		 
		//Korisnici su dodati
		 userRepository.save(startingUser);
		 userRepository.save(editor);
		 
		//System.out.println(startingUser);
		
		 //pokrece se program
		 login(userRepository);
	}

}
