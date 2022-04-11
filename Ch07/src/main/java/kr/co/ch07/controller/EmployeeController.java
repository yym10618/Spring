package kr.co.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch07.service.EmployeeService;
import kr.co.ch07.vo.EmployeeVo;
import kr.co.ch07.vo.MemberVo;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	// 등록
	@GetMapping("/employee/register")
	public String insertEmployee() {
		return "/employee/register";
	}
	
	@PostMapping("/employee/register")
	public String insertEmployee(EmployeeVo vo) {
		service.insertEmployee(vo);
		return "redirect:/employee/list";
	}
	
	// 목록
	@GetMapping("/employee/list")
	public String selectEmployees(Model model) {
		List<EmployeeVo> employees = service.selectEmployees();
		model.addAttribute("employees", employees);
		return "employee/list";
	}
	
	// 수정
	@GetMapping("/employee/modify")
	public String selectEmployee(String uid, Model model) {
		EmployeeVo employee = service.selectEmployee(uid);
		model.addAttribute("employee", employee);
		return "/employee/modify";
	}
	
	@PostMapping("/employee/modify")
	public String updateEmployee(EmployeeVo vo) {
		service.updateEmployee(vo);
		return "redirect:/employee/list";
	}
	
	// 삭제
	@GetMapping("/employee/delete")
	public String deleteEmployee(String uid) {
		service.deleteEmployee(uid);
		return "redirect:/employee/list";
	}
	
	
	
	
	
}
