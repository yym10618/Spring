package kr.co.kmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	@GetMapping("/member/register-seller")
	public String registerSeller() {
		return "/member/register-seller";
	}
	@GetMapping("/member/signup")
	public String signUp() {
		return "/member/signup";
	}
}
