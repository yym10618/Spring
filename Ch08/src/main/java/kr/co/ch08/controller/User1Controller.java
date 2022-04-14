package kr.co.ch08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch08.service.User1Service;
import kr.co.ch08.vo.User1Vo;

@Controller
public class User1Controller {

	@Autowired
	private User1Service service;
	
	
	@GetMapping("/user1/login")
	public String login() {
		return "/user1/login";
	}
	
	@GetMapping("/user1/loginSuccess")
	public String loginSuccess() {
		return "/user1/loginSuccess";
	}
	
	@GetMapping("/user1/register")
	public String register() {
		return "/user1/register";
	}
	
	@PostMapping("/user1/register")
	public String register(User1Vo vo) {
		service.insertUser(vo);
		return "redirect:/user1/login";
	}
	
	
}
