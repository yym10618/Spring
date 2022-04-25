package kr.co.Farmstory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.Farmstory.service.UserService;
import kr.co.Farmstory.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	
	@PostMapping("/user/login")
	public String login(String uid) {
		return "redirect:/index";
	}
	
	@GetMapping("/user/terms")
	public String terms() {
		return "/user/terms";
	}
	
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
}
