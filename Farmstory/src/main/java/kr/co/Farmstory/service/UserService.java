package kr.co.Farmstory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.Farmstory.dao.UserDao;
import kr.co.Farmstory.vo.TermsVo;
import kr.co.Farmstory.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public void insertUser(UserVo vo) {
		dao.insertUser(vo);
	}
	public TermsVo selectTerms() {
		return dao.selectTerms();
	}
	public int CountUserUid(String uid) {
		return dao.CountUserUid(uid);
	}
	public int CountUserNick(String nick) {
		return dao.CountUserNick(nick);
	}
	public int CountUserEmail(String email) {
		return dao.CountUserEmail(email);
	}
	public int CountUserHp(String hp) {
		return dao.CountUserHp(hp);
	}
	public UserVo selectUser(UserVo vo) {
		return dao.selectUser(vo);
	}
	public List<UserVo> selectUsers() {
		return dao.selectUsers();				
	}
	public void updateUser(UserVo vo) {
		dao.updateUser(vo);
	}
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}
}
