package demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import demo.dao.UserDao;
import demo.entity.User;
import demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	//@Autowired
	//@Qualifier("userDao")
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public boolean delUser(String id) {
		
		return userDao.delUser(id)>0;
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user)>0;
	}

}
