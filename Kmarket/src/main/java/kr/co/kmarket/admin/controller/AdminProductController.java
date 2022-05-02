package kr.co.kmarket.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.admin.service.AdminProductService;

@Controller
public class AdminProductController {

	@Autowired
	private AdminProductService service;
	
	@GetMapping("/admin/product/list")
	public String list() {
		return "/admin/product/list";
	}
	@GetMapping("/admin/product/register")
	public String register() {
		return "/admin/product/register";
	}
}
