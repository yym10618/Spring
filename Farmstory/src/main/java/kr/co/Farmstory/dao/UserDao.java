package kr.co.Farmstory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.Farmstory.vo.UserVo;

@Mapper
@Repository
public interface UserDao {

	public void insertUser(UserVo vo);
	public UserVo selectUser(String uid);
	public List<UserVo> selectUsers();
	public void updateUser(UserVo vo);
	public void deleteUser(String uid);
}
