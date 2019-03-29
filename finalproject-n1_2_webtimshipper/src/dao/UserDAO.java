package dao;

import model.User;

public interface UserDAO {

	User login(String username, String password);

	void register(User user);

	User getUserById(Integer id);

}
