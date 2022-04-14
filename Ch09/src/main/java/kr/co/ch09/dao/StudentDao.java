package kr.co.ch09.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch09.vo.StudentVo;

@Mapper
@Repository
public interface StudentDao {

	public void insertStudent(StudentVo vo);
	public StudentVo selectStudent(String sid);
	public List<StudentVo> selectStudents();
	public void updateStudent(StudentVo vo);
	public void deleteStudent(String sid);
}
