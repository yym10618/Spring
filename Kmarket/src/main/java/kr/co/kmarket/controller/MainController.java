package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.admin.vo.ProductVo;
import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVo;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		
		List<ProductVo> hitProducts = service.selectHit();
		
		model.addAttribute("hitProducts", hitProducts);
		
		return "/index";
	}
	
	
	@ResponseBody
	@GetMapping("/getCategories")
	public List<CategoriesVo> getCategories() {
		return service.selectCategories();
	}
}
