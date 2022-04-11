package kr.co.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch07.service.StudentService;
import kr.co.ch07.vo.StudentVo;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	// 등록
	@GetMapping("/student/register")
	public String insertStudent() {
		return "/student/register";
	}
	
	@PostMapping("/student/register")
	public String insertStudent(StudentVo vo) {
		service.insertStudent(vo);
		return "redirect:/student/list";
	}
	
	// 목록
	@GetMapping("/student/list")
	public String selectStudents(Model model) {
		List<StudentVo> students = service.selectStudents();
		model.addAttribute("students", students);
		return "/student/list";
	}
	
	// 수정
	@GetMapping("/student/modify")
	public String selectStudent(String sid, Model model) {
		StudentVo student = service.selectStudent(sid);
		model.addAttribute("student", student);
		return "/student/modify";
	}
	
	@PostMapping("/student/modify")
	public String updateStudent(StudentVo vo) {
		service.updateStudent(vo);
		return "redirect:/student/list";
	}
	
	// 삭제
	@GetMapping("/student/delete")
	public String deleteStudent(String sid) {
		service.deleteStudent(sid);
		return "redirect:/student/list";
	}
}
