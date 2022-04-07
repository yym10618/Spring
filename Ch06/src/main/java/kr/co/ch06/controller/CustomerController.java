package kr.co.ch06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch06.service.CustomerService;
import kr.co.ch06.vo.CustomerVo;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/customer/register")
	public String register() {
		return "/customer/register";
	}
	
	@PostMapping("/customer/register")
	public String register(CustomerVo vo){
		service.insertCustomer(vo);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/customer/list")
	public String list(Model model) {
		List<CustomerVo> customers = service.selectCustomers();
		model.addAttribute("customers", customers);
		return "/customer/list";
	}
	
	@GetMapping("/customer/modify")
	public String modify(String custid, Model model) {
		// 수정데이터 요청
		CustomerVo customer = service.selectCustomer(custid);
		model.addAttribute("customer", customer);
		return "/customer/modify";
	}
	
	@PostMapping("/customer/modify")
	public String modify(CustomerVo vo) {
		// 수정 요청
		service.updateCustomer(vo);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/customer/delete")
	public String delete(String custid) {
		service.deleteCustomer(custid);
		return "redirect:/customer/list";
	}
	
}
