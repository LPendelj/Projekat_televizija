package util;

import java.util.List;


public interface Repository<T> {
	void save(T t);
	public T get(String username);
	public List<T> getAll();
//	void save(model.T t);
	boolean deleteUser(String s);
	
}
