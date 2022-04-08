package kr.co.staff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.staff.service.StaffService;
import kr.co.staff.vo.StaffVo;

@Controller
public class StaffController {
	
	@Autowired
	private StaffService service;

	@GetMapping("/register")
	public String register() {
		return "/register";
	}
	
	@PostMapping("/register")
	public String register(StaffVo vo) {
		service.insertStaff(vo);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<StaffVo> staffs = service.selectStaffs();
		model.addAttribute("staffs", staffs);
		return "/list";
	}
	
	@GetMapping("/modify")
	public String modify(String stf_no, Model model) {
		// 수정데이터 요청
		StaffVo staff = service.selectStaff(stf_no);
		model.addAttribute("staff", staff);
		return "/modify";
	}
	
	@PostMapping("/modify")
	public String modify(StaffVo vo) {
		// 수정 요청
		service.updateStaff(vo);
		return "redirect:/list";
	}
	
	@GetMapping("/delete")
	public String delete(String stf_no) {
		service.deleteStaff(stf_no);
		return "redirect:/list";
	}
	
}
