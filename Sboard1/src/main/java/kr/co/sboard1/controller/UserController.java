package kr.co.sboard1.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sboard1.service.UserService;
import kr.co.sboard1.vo.TermsVo;
import kr.co.sboard1.vo.UserVo;

@SessionAttributes("sessUser")
@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	
	// 로그인
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	@PostMapping("/user/login")
	public String login(UserVo vo, Model model) {
		
		UserVo user = service.selectUser(vo);
		
		if(user == null) {
			// 로그인 실패
			return "redirect:/user/login?success=100";
			
		}else {
			// 로그인 성공
			model.addAttribute("sessUser", user);
			return "redirect:/article/list";
		}
		
	}
	
	// 로그아웃
	@GetMapping("/user/logout")
	public String logout(SessionStatus status) {
		// @SessionAttributes로 설정한 세션 해제
		status.setComplete();
		return "redirect:/user/login?success=103";
	}
	
	@GetMapping("/user/terms")
	public String terms(Model model) {
		
		TermsVo terms = service.selectTerms();
		model.addAttribute(terms);
		
		return "/user/terms";
	}
	
	// 회원가입
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	@PostMapping("/user/register")
	public String register(UserVo vo, HttpServletRequest req) {
		
		// regip req객체로 받아와서 입력
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertUser(vo);
		return "redirect:/user/login";
	}
	
	@ResponseBody // 뷰 포워드 하지 않고 클라이언트로 전송 어노테이션
	@GetMapping("/user/checkUid")
	public Map<String, Integer> checkUid(String uid) {
		
		int result = service.CountUserUid(uid);
		
		// Spring Boot의 기본 json 라이브러리 Jackson으로 자바 자료구조를 자동으로 Json 객체로 출력됨
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		
		return map;
	}
	@ResponseBody
	@GetMapping("/user/checkNick")
	public Map<String, Integer> checknick(String nick) {
		
		int result = service.CountUserNick(nick);
		
		// Spring Boot의 기본 json 라이브러리 Jackson으로 자바 자료구조를 자동으로 Json 객체로 출력됨
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		
		return map;
	}
	@ResponseBody
	@GetMapping("/user/checkEmail")
	public Map<String, Integer> checkemail(String email) {
		
		int result = service.CountUserEmail(email);
		
		// Spring Boot의 기본 json 라이브러리 Jackson으로 자바 자료구조를 자동으로 Json 객체로 출력됨
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		
		return map;
	}
}