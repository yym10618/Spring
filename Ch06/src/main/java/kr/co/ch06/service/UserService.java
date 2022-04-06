package kr.co.ch06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch06.persistence.UserDao;
import kr.co.ch06.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public void insertUser(UserVo vo) {
		dao.insertUser(vo);
	}
	public UserVo selectUser(String uid) {
		return dao.selectUser(uid);
	}
	public List<UserVo> selectUsers() {
		List<UserVo> users =  dao.selectUsers();
		return users;
		// return dao.selectUsers(); <- 한줄로 표현
	}
	public void updateUser(UserVo vo) {
		dao.updateUser(vo);
	}
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}
}
