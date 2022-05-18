package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MemberDao;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.TermsVo;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public MemberVo selectMember(MemberVo vo) {
		return dao.selectMember(vo);
	}
	
	public TermsVo selectTerms() {
		return dao.selectTerms();
	}
	
	public void insertMember(MemberVo vo) {
		dao.insertMember(vo);
	}
}