package kr.co.ch06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch06.persistence.MemberDao;
import kr.co.ch06.vo.MemberVo;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public void insertMember() {
		dao.insertMember();
	}
	public void selectMember() {
		dao.selectMember();
	}
	public List<MemberVo> selectMembers() {
		List<MemberVo> members = dao.selectMembers();
		return members;
	}
	public void updateMember() {
		dao.updateMember();
	}
	public void deleteMember() {
		dao.deleteMember();
	}
}
