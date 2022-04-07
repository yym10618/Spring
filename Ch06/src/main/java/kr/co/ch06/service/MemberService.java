package kr.co.ch06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch06.persistence.MemberDao;
import kr.co.ch06.vo.MemberVo;
import kr.co.ch06.vo.UserVo;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public void insertMember(MemberVo vo) {
		dao.insertMember(vo);
	}
	public MemberVo selectMember(String uid) {
		return dao.selectMember(uid);
	}
	public List<MemberVo> selectMembers() {
		List<MemberVo> members = dao.selectMembers();
		return members;
	}
	public void updateMember(MemberVo vo) {
		dao.updateMember(vo);
	}
	public void deleteMember(String uid) {
		dao.deleteMember(uid);
	}
}
