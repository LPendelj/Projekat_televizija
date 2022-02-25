package util;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserRepository implements Repository {

	 List<User> lista;
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByUsername(String username) {
		for(User u : lista) {
			if(u.getUserName().equals(username)) {
				return u;
			}
		}
		
		return null;
	}

}
