package kr.co.ch06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch06.service.MemberService;
import kr.co.ch06.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@GetMapping("/member/list")
	public String list(Model model) {
		
		List<MemberVo> members = service.selectMembers();
		model.addAttribute("members", members);
		return "/member/list";
	}
	
}
