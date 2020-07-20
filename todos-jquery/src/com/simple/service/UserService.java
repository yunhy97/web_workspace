package com.simple.service;


import com.simple.dao.UserDao;
import com.simple.vo.User;

public class UserService {

	private UserDao userDao = new UserDao();
	
	/**
	 * 지정된 사용자정보를 회원가입시킨다.
	 * 단, 동일한 아이디를 가진 사용자가 있는 경우, 예외를 발생시킨다.
	 * @param user 새 사용자 정보
	 * @throws Exception
	 */
	public void addNewUser(User user) throws Exception {
		User savedUser = userDao.getUserById(user.getId());
		if(savedUser != null ) {
			throw new Exception("아이디 중복");
		}
		
		userDao.insertUser(user);
	}
	
	/**
	 * 지정된 아이디와 비밀번호로 가입된 사용자 정보와 비교해서 로그인 여부를 결정한다.
	 * 인증과정을 통과하지 못한 경우, 예외를 발생시킨다.
	 * @param userId 사용자 아이디
	 * @param password 비밀번호
	 * @return 인증과정이 통과된 사용자의 정보
	 * @throws Exception
	 */
	public User getLoginUser(String userId, String password) throws Exception {

		User user = userDao.getUserById(userId);
		
		if(user == null) {
			throw new Exception("사용자가 존재하지 않음");
		}
		
		if(!password.equals(user.getPassword())) {
			throw new Exception("비밀번호 불일치");
		}
		return user;
	}
}
