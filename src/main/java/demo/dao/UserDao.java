package demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import demo.entity.User;

@Repository("userDao")
public interface UserDao {

	public User getUser(String id);
	
	public List<User> getAllUser();
	
	public int addUser(User user);
	
	public int delUser(String id);
	
	public int updateUser(User user);
}
