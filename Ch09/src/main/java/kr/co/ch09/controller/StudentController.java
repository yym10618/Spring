package kr.co.ch09.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ch09.service.StudentService;
import kr.co.ch09.vo.StudentVo;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/student")
	public List<StudentVo> list() {
		List<StudentVo> students = service.selectStudents();
		return students;
	}
	
	@PostMapping("/student")
	public List<StudentVo> register(StudentVo vo) {
		service.insertStudent(vo);
		return service.selectStudents();
	}
	
	@PutMapping("/student/{sid}")
	public List<StudentVo> modify(@PathVariable ("sid") String sid, StudentVo vo) {
		vo.setSid(sid);
		service.updateStudent(vo);
		return service.selectStudents();
	}
	
	@DeleteMapping("/student/{sid}")
	public List<StudentVo> delete(@PathVariable ("sid") String sid) {
		service.deleteStudent(sid);
		return service.selectStudents();
	}
}
