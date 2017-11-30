package demo.dao;

import java.util.List;

import demo.entity.User;


public interface UserDao {
	static final String GETUSER = "getUser";
	static final String GETALLUSER = "getAllUser";
	static final String ADDUSER = "addUser";
	static final String DELUSER = "delUser";
	static final String UPDATEUSER = "updateUser";

	public User getUser(String id);
	
	public List<User> getAllUser();
	
	public int addUser(User user);
	
	public int delUser(String id);
	
	public int updateUser(User user);
}
