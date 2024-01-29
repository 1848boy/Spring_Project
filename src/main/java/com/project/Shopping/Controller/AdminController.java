package com.project.Shopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.Shopping.Model.Products;
import com.project.Shopping.Repository.ProductsRepository;

@Controller
public class AdminController {

	@Autowired
	ProductsRepository productsrepository;


	@GetMapping("/ProductsPage")
	public String callProductPage(Model model) {
		List<Products> productslist = productsrepository.findAll();
		model.addAttribute("productslist", productslist);
		return "AdminProductsPage";
	}
	
	@PostMapping("/adminEdit")
	public ResponseEntity<String> handleFormSubmission(@RequestBody Products products) {
	    // Process the form data in your controller
	    // Example: Save the updated product details to the database
	    System.err.println(products);
	    // Return a response (you can customize the response as needed)
	    return ResponseEntity.ok("Form submitted successfully!");
	}

}
