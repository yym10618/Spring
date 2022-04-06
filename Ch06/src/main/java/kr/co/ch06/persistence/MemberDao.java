package kr.co.ch06.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch06.vo.MemberVo;

@Repository
public interface MemberDao {

	public void insertMember();
	public void selectMember();
	public List<MemberVo> selectMembers();
	public void updateMember();
	public void deleteMember();
}
