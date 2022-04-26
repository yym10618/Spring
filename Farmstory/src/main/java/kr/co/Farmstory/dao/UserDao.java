package kr.co.Farmstory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.Farmstory.vo.TermsVo;
import kr.co.Farmstory.vo.UserVo;


@Mapper
@Repository
public interface UserDao {

	public void insertUser(UserVo vo);
	public TermsVo selectTerms();
	public int CountUserUid(String uid);
	public int CountUserNick(String nick);
	public int CountUserEmail(String email);
	public int CountUserHp(String hp);
	public UserVo selectUser(UserVo vo);
	public List<UserVo> selectUsers();
	public void updateUser(UserVo vo);
	public void deleteUser(String uid);
}
