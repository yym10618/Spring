package kr.co.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch07.service.CustomerService;
import kr.co.ch07.vo.CustomerVo;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	// 등록
	@GetMapping("/customer/register")
	public String insertCustomer() {
		return "/customer/register";
	}
	
	@PostMapping("/customer/register")
	public String insertCustomer(CustomerVo vo, Model model) {
		service.insertCustomer(vo);
		model.addAttribute("model", model);
		return "redirect:/customer/list";
	}
	
	// 목록
	@GetMapping("/customer/list")
	public String selectCustomers(Model model) {
		List<CustomerVo> customers = service.selectCustomers();
		model.addAttribute("customers", customers);
		return "/customer/list";
	}
	
	// 수정
	@GetMapping("/customer/modify")
	public String selectCustomer(String custid, Model model) {
		CustomerVo customer = service.selectCustomer(custid);
		model.addAttribute("customer", customer);
		return "/customer/modify";
	}
	
	@PostMapping("/customer/modify")
	public String updateCustomer(CustomerVo vo) {
		service.updateCustomer(vo);
		return "redirect:/customer/list";
	}
	
	// 삭제
	@GetMapping("/customer/delete")
	public String deleteCustomer(String custid) {
		service.deleteCustomer(custid);
		return "redirect:/customer/list";
	}
	
	
}
