package demo.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import demo.dao.UserDao;
import demo.entity.User;


public class UserDaoImpl implements UserDao {

	private SqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public User getUser(String id) {	
		return this.sqlSessionTemplate.selectOne(GETUSER, id);
	}

	@Override
	public List<User> getAllUser() {
		return this.sqlSessionTemplate.selectList(GETALLUSER);
	}

	@Override
	public int addUser(User user) {
		return this.sqlSessionTemplate.insert(ADDUSER, user);
	}

	@Override
	public int delUser(String id) {
		return this.sqlSessionTemplate.delete(DELUSER, id);
	}

	@Override
	public int updateUser(User user) {
		return this.sqlSessionTemplate.update(UPDATEUSER, user);
	}

}
