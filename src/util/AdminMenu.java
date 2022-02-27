package util;

import java.util.List;
import java.util.Scanner;

import model.User;
//TODO treba uraditi provere kad god ima neki unos

public class AdminMenu {
	private final Repository<User> repo;
	private final User currentUser;
	private final Scanner scanner;

	public AdminMenu(Repository<User> repo, Scanner scanner, User currentUser) {
		super();
		this.scanner = scanner;
		this.repo = repo;
		this.currentUser = currentUser;
	}

	public void startAdminMenu() {
		System.out.println("Admin meni je startovao");
		
		int decision = -1;
		while (decision != 0) {
			showConsole();
			decision = scanner.nextInt();
			 scanner.nextLine();
			// mozda treba dodati ovo da bi ocistio enter posle unosa int - DODATO
			switch (decision) {
			case 1:
				enterNewUser();
				break;
			case 2:
				showAllUsers();
				break;
			case 3:
				showUser();
				break;
			case 4:
				changeUser();
				break;
			case 5:
				deleteUser();
				break;
			case 0:
				break;
			default:

				break;
			}
		}

	}

	private void showConsole() {
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println("1. Unos novog korisnika");
		System.out.println("2. Prikazi sve korisnike");
		System.out.println("3. Prikaz korisnika");
		System.out.println("4. Izmena korisnika");
		System.out.println("5. Brisanje korisnika");
	}

	private void deleteUser() {
		System.out.println("Brisanje korisnika");
		System.out.println("Unesite username korisnika kog zelite da izbrisete");
		String userName = scanner.nextLine();
		if(repo.deleteUser(userName)) {
			System.out.println("Korisnik " + userName + " je obrisan.");
		} else System.out.println("Korisnik sa tim korisnickim imenom ne postoji.");; //implementirati metodu delete
		
	}

	private void changeUser() {
		System.out.println("Izmena korisnika");
		System.out.println("Unesite username korisnika kog zelite da izmenite");
		String userName = scanner.nextLine();
		// mozda treba samo ubaciti funkcionalnost getUserByUsername(userName) metode u
		// get() metodu
		// i dodati parametar String userName u nju, da bude get(String userName);
		// da ne bismo morali da radimo ovo castovanje - ISPRAVLJENO
		User userToChange =  repo.get(userName);
		System.out.println("Staro ime korisnika:" + userToChange.getFirstName() + "Unesite novo ime korisnika:");
		String firstName = scanner.nextLine();
		System.out.println("Staro prezime korisnika:" + userToChange.getLastName() + "Unesite novo prezime korisnika:");
		String lastName = scanner.nextLine();
		// ako treba menjati i username treba odraditi proveru da li postoji korisnik s
		// tim username
		System.out.println("Stari username korisnika:" + userToChange.getUserName() + "Unesite novi username korisnika:");
		String newUserName = scanner.nextLine();
		System.out.println("Stara uloga korisnika:" + userToChange.getRole() + "Unesite novu ulogu korisnika:");
		String role = scanner.nextLine();
		Role newRole = role.equals("ADMIN") ? Role.ADMIN : Role.EDITOR; // izmenjen upit tako da se poredi sa Stringom.
		// mozda dodati novu metodu za update(User user), u suprotnom moze save da se
		// odradi tako da radi i kao save i kao update
		repo.save(new User(firstName, lastName, newUserName, userToChange.getPassword(), newRole));
	}

	private void showUser() {
		System.out.println("Prikaz korisnika, unesite username:");
		String userName = scanner.nextLine();
		User t =  repo.get(userName);
		System.out.println(t);
	}

	private void showAllUsers() {
		System.out.println("Prikaz svih korisnika:");
		List<User> ts = repo.getAll();
		for (User u : ts) {
			System.out.println(u);
		}
	}

	// treba uraditi provere kad god ima neki unos
	private void enterNewUser() {
		System.out.println("Unos novog korisnika");
		System.out.println("Unesite ime korisnika:");
		String firstName = scanner.nextLine();
		System.out.println("Unesite prezime korisnika:");
		String lastName = scanner.nextLine();

		boolean validEntry = false;
		String userName = "";
		while (!validEntry) {
			System.out.println("Unesite username korisnika:");
			userName = scanner.nextLine();
			validEntry = checkUserName(userName);
		}
		validEntry = false;
		String password = "";
		while (!validEntry) {
			System.out.println("Unesite password korisnika:");
			password = scanner.nextLine();
			validEntry = checkPassword(password);
		}
		String password2 = "";
		while (!validEntry) {
			System.out.println("Ponovo password korisnika:");
			password2 = scanner.nextLine();
			validEntry = password2.equals(password);
		}

		System.out.println("Unesite ulogu korisnika:");
		String role = scanner.nextLine();
		Role newRole = role.equals("ADMIN") ? Role.ADMIN : Role.EDITOR;
		repo.save(new User(firstName, lastName, userName, password, newRole));
	}

	private boolean checkPassword(String password) {
		boolean passwordOK = false;
		// password mora poceti slovom i imati barem 1 broj
		if (Character.isAlphabetic(password.charAt(0))) {
			for (int i = 1; i < password.length(); i++) {
				if (Character.isDigit(password.charAt(i)))
					passwordOK = true;
				//return true; // <- optimizacija, izbacimo passwordOK = true;
			}
		}

		return passwordOK;
	}

	private boolean checkUserName(String userName) {
		boolean userNameOK = false;
		if (repo.get(userName) == null)
			userNameOK = true;
		return userNameOK;
	}

}
