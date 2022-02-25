package util;

import java.util.List;

import model.User;

public interface Repository {
	public void save(User user);
	public User get();
	public List<User> getAll();
}
