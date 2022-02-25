package util;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserRepository implements Repository {

	 List<User> lista;
	 
	 
	
	public UserRepository(List<User> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public void save(User user) {
		lista.add(user);
		
	}

	@Override
	public User get(String username) {
		for(User u : lista) {
			if(u.getUserName().equals(username)) {
				return u;
			}
		}
		//throw new Exception("User is not availible");
		return null;
	}
	

	@Override
	public List<User> getAll() {
		return this.lista;
	}

		

}
