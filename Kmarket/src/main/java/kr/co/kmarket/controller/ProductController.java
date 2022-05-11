package kr.co.kmarket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.CartVo;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.ProductVo;

@SessionAttributes("sessMember")
@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	// 최초에 sessMember값 초기화하는 메서드 
	@ModelAttribute("sessMember")
	public MemberVo setMemberVo() {
		return null;
	}
	
	
	@GetMapping("/product/cart")
	public String cart(@ModelAttribute("sessMember") MemberVo sessMember, Model model) {
		
		if(sessMember == null) {
			return "redirect:/member/login";
		}else {
			String uid = sessMember.getUid();
			List<CartVo> carts = service.selectCarts(uid);
			model.addAttribute("carts", carts);
			return "/product/cart";
		}
		
	}
	
	@ResponseBody
	@PostMapping("/product/cart")
	public Map<String, Integer> cart(CartVo vo) {
		
		int result = service.insertCart(vo);
		//int result = 1;
		
		Map<String, Integer> jsonData = new HashMap<>();
		jsonData.put("result", result);
		
		return jsonData;
	}
	
	@GetMapping("/product/complete")
	public String complete() {
		return "/product/complete";
	}
	
	@GetMapping("/product/list")
	public String list(ProductVo vo, Model model) {
		
		int start = 0;
		int order = vo.getOrder();
		
		vo.setStart(start);
		vo.setOrder(order);
				
		CategoriesVo cates = service.selectCateTitles(vo);		
		List<ProductVo> products = service.selectProducts(vo);
		
		model.addAttribute("products", products);
		model.addAttribute("cates", cates);
		model.addAttribute("order", order);
		
		
		return "/product/list";
	}
	
	@GetMapping("/product/view")
	public String view(int pid, Model model) {
		
		ProductVo product = service.selectProduct(pid);
		CategoriesVo cates = service.selectCateTitles(product);
		
		model.addAttribute("product", product);
		model.addAttribute("cates", cates);
		
		return "/product/view";
	}
	@GetMapping("/product/order")
	public String order() {
		return "/product/order";
	}
	@GetMapping("/product/search")
	public String search() {
		return "/product/search";
	}
	
	
}