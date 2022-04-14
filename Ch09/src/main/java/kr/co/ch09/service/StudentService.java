package kr.co.ch09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch09.dao.StudentDao;
import kr.co.ch09.vo.StudentVo;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;
	
	public void insertStudent(StudentVo vo) {
		dao.insertStudent(vo);
	}
	public StudentVo selectStudent(String sid) {
		return dao.selectStudent(sid);
	}
	public List<StudentVo> selectStudents() {
		return dao.selectStudents();
	}
	public void updateStudent(StudentVo vo) {
		dao.updateStudent(vo);
	}
	public void deleteStudent(String sid) {
		dao.deleteStudent(sid);
	}
}
