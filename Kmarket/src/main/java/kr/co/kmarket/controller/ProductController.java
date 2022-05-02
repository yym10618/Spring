package kr.co.kmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/product/cart")
	public String cart() {
		return "/product/cart";
	}
	@GetMapping("/product/complete")
	public String complete() {
		return "/product/complete";
	}
	@GetMapping("/product/list")
	public String list() {
		return "/product/list";
	}
	@GetMapping("/product/order")
	public String order() {
		return "/product/order";
	}
	@GetMapping("/product/search")
	public String search() {
		return "/product/search";
	}
	@GetMapping("/product/view")
	public String view() {
		return "/product/view";
	}
}
