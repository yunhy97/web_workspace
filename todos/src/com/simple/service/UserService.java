package com.simple.service;

import com.simple.dao.UserDao;
import com.simple.vo.User;

public class UserService {

	private UserDao userDao = new UserDao();
	
	public boolean addNewUser(User user) throws Exception {
		User savedUser = userDao.getUserById(user.getId());
		if(savedUser != null) {
			return false;
		}
		
		userDao.insertUser(user);
		return true;
	}
	
	public User loginCheck(String id, String pwd) throws Exception {
		//정달받은 아이디로 사용자 정보를 조회한다.
		User user = userDao.getUserById(id);
		//사용자 정보가 존재하지 않으면 null 반환
		if(user == null) {
			return null;
		}
		//비밀번호가 일치하지 않으면 null 반환
		if(!pwd.equals(user.getPassword())) {
			return null;
		}
		//그 외는 조회된 사용자 정보를 반환한다.
		return user;
	}
}
