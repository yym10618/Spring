package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.ProductVo;

@SessionAttributes("sessMember")
@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	// 최초에 sessMember값 초기화하는 메서드 
	@ModelAttribute("sessMember")
	public MemberVo setMemberVo() {
		return null;
	}
	
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		
		List<ProductVo> productsHit 	  = service.selectMainProducts("hit");
		List<ProductVo> productsRecommend = service.selectMainProducts("score");
		List<ProductVo> productsNew 	  = service.selectMainProducts("rdate");
		List<ProductVo> productsDiscount  = service.selectMainProducts("discount");
		List<ProductVo> productsBest      = service.selectMainProducts("sold");
		
		model.addAttribute("productsHit", productsHit);
		model.addAttribute("productsRecommend", productsRecommend);
		model.addAttribute("productsNew", productsNew);
		model.addAttribute("productsDiscount", productsDiscount);
		model.addAttribute("productsBest", productsBest);
		model.addAttribute("productsBest", productsBest);
		
		return "/index";
	}
	
	
	@ResponseBody
	@GetMapping("/getCategories")
	public List<CategoriesVo> getCategories() {
		return service.selectCategories();
	}
	
}