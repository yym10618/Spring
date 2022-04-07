package kr.co.ch06.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch06.vo.StudentVo;

@Repository
public interface StudentDao {

	public void insertStudent(StudentVo vo);
	public StudentVo selectStudent(String sid);
	public List<StudentVo> selectStudents();
	public void updateStudent(StudentVo vo);
	public void deleteStudent(String sid);
}
