package kr.co.Farmstory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.Farmstory.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/board/list")
	public String list(Model model, String cate, String type) {
		
		// cate, type view에서 참조하기 위해 cate, type 파라미터 받아와서 model.addAttribute
		model.addAttribute("cate", cate);
		model.addAttribute("type", type);
		
		return "/board/list";
	}
	
	@GetMapping("/board/write")
	public String write() {
		return "/board/write";
	}
	
	@GetMapping("/board/view")
	public String view() {
		return "/board/view";
	}
	
	@GetMapping("/board/modify")
	public String modify() {
		return "/board/modify";
	}
}
