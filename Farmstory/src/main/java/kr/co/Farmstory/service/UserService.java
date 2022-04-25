package kr.co.Farmstory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.Farmstory.dao.UserDao;
import kr.co.Farmstory.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public void insertUser(UserVo vo) {
		
	}
	public UserVo selectUser(String uid) {
		return dao.selectUser(uid);
	}
	public List<UserVo> selectUsers(){
		return null;
	}
	public void updateUser(UserVo vo) {
		
	}
	public void deleteUser(String uid) {
		
	}
}
