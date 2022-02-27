package util;

import java.util.List;

import model.User;

public class UserRepository implements Repository<User> {

	 List<User> lista;
	 
	 
	
	public UserRepository(List<User> lista) {
		super();
		this.lista = lista;
	}

	/*
	 * @Override public void save(T t) {
	 * 
	 * 
	 * }
	 */

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

	
	public void save(User u) {
		lista.add(u);
		
	}
	
	public boolean deleteUser(String s) {
		for(User t:lista) {
			if(t.getUserName().equals(s)) {
				lista.remove(t);
				return true;
			}
			
		}
		
		return false;
		
	}

		

}
