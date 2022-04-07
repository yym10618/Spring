package kr.co.ch06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch06.service.StudentService;
import kr.co.ch06.vo.StudentVo;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/student/register")
	public String register() {
		return "/student/register";
	}
	
	@PostMapping("/student/register")
	public String register(StudentVo vo) {
		service.insertStudent(vo);
		return "redirect:/student/list";
	}
	
	@GetMapping("/student/list")
	public String list(Model model) {
		List<StudentVo> students = service.selectStudents();
		model.addAttribute("students", students);
		return "/student/list";
	}
	
	@GetMapping("/student/modify")
	public String modify(String sid, Model model) {
		StudentVo student = service.selectStudent(sid);
		model.addAttribute("student", student);
		return "/student/modify";
	}
	
	@PostMapping("/student/modify")
	public String modify(StudentVo vo) {
		service.updateStudent(vo);
		return "redirect:/student/list";
	}
	
	@GetMapping("/student/delete")
	public String delete(String sid) {
		service.deleteStudent(sid);
		return "redirect:/student/list";
	}
}
