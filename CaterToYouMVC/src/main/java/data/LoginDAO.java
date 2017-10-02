package data;

import entity.User;

public interface LoginDAO {
	public User returnUser(String userName, String password);
}
