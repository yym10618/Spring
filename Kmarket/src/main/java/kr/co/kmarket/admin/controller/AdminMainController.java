package kr.co.kmarket.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.admin.service.AdminMainService;


@Controller
public class AdminMainController {

	@Autowired
	private AdminMainService service;
	
	@GetMapping(value = {"/admin", "/admin/index"})
	public String index() {
		return "/admin/index";
	}
}
