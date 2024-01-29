package com.project.Shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Shopping.Service.MainService;

@Controller
@RequestMapping("/") // >>>>>>>>>>>>>>>>>>>>>> URL EndPoint
public class MainController {

	@Autowired
	private MainService service;

	@GetMapping("/") // >>>>>>>>>>>>>>>>>>>>>> Empty HomePage EndPoint
	public String getHomePage(Model model) {
		model.addAttribute("condition", false);
		return "HomePage";
	}
	@GetMapping("/Home") // >>>>>>>>>>>>>>>>>>>>>> All Products HomePage EndPoint
	public String getHome(Model model) {
		service.getHome(model);
		model.addAttribute("condition", false);
		return "HomePage";
	}

	@GetMapping("/category/{type}") // >>>>>>>>>>>>>>>>>>>>>> Category filter EndPoint
	public String filterCategory(@PathVariable String type, Model model) {
		model.addAttribute("productslist", service.getByCategory(type));
		model.addAttribute("condition", false);
		return "HomePage";
	}

	@GetMapping("/CartPage") // >>>>>>>>>>>>>>>>>>>>>> CartPage EndPoint
	public String showCartPage(Model model) {
		String response = service.showCartPage(model);
		return response;
	}

	@GetMapping("/product/{productid}") // >>>>>>>>>>>>>>>>>>>>>> Add Product EndPoint
	public String addToCart(@PathVariable int productid, Model model) {
		String response = service.addToCart(productid, model);
		model.addAttribute("messaage", "Added to Cart ");
		System.err.println(response);
		return "redirect:/CartPage";
	}

	@GetMapping("/ProductPage/{productid}")
	public String showProductPage(@PathVariable int productid, Model model) {
		service.showProdcutPage(productid, model);
		return "ProductPage";
	}

	@GetMapping("/updateQuantity/{value}/{productid}")
	public String updateQuantity(@PathVariable String value, @PathVariable int productid, Model model) {
		if ("plus".equals(value)) {
			service.updateQuantity(value, productid, model);
			return "redirect:/CartPage";
		} else if ("minus".equals(value)) {
			service.updateQuantity(value, productid, model);
			return "redirect:/CartPage";
		}
		return "redirect:/CartPage";
	}

	@GetMapping("/search")
	public String search(@RequestParam(name = "searchQuery", required = false) String searchQuery, Model model) {
		System.err.println(searchQuery);
		service.searchproduct(searchQuery,model);
		return "HomePage";
	}
	@GetMapping("/adminsearch")
	public String adminSearch(@RequestParam(name = "searchQuery", required = false) String searchQuery, Model model) {
		System.err.println(searchQuery);
		service.searchproduct(searchQuery,model);
		return "AdminProductsPage";
	}

}