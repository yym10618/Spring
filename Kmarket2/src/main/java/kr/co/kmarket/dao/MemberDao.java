package kr.co.kmarket.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.TermsVo;

@Mapper
@Repository
public interface MemberDao {

	
	public MemberVo selectMember(MemberVo vo);
	public TermsVo selectTerms();
	public void insertMember(MemberVo vo);
	
}