package com.project.Shopping.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.Shopping.Model.Products;
import com.project.Shopping.Model.cart;
import com.project.Shopping.Repository.ProductsRepository;

@Service
public class MainService {

	private static List<cart> cat = new ArrayList<cart>();
	private  List<Products> searchlist = new ArrayList<Products>();
	private static double total = 0;

	@Autowired
	ProductsRepository productsrepository;

	public void getHome(Model model) {
		List<Products> productslist = productsrepository.findAll();
		model.addAttribute("productslist", productslist);
		// System.err.println(productslist);
	}

	public List<Products> getByCategory(String Category) {
		return productsrepository.findByCategory(Category);
	}

	public String showCartPage(Model model) {
		model.addAttribute("cat", cat);
		model.addAttribute("total", total);
		model.addAttribute("messaage", "Added to Cart ");
		return "CartPage";
	}

	public String addToCart(int productid, Model model) {
		Products singleproduct = productsrepository.findById(productid).orElse(null);

		if (singleproduct != null) {
			boolean productInCart = false;

			for (cart c : cat) {
				if (c.getProducts().getproductid() == productid) {
					c.setQuantity(c.getQuantity() + 1);
					total += singleproduct.getPrice();
					System.err.println(total);
					productInCart = true;
					break;
				}
			}

			if (!productInCart) {
				int quantity = 1;
				total += singleproduct.getPrice();
				System.err.println(total);
				cat.add(new cart(singleproduct, quantity));
			}
		}

		return "Product Added to Cart";
	}

	public String updateQuantity(String value, int productid, Model model) {
		Products singleproduct = productsrepository.findById(productid).orElse(null);
		if("plus".equals(value)) 
		{
			if (singleproduct != null) {
				boolean productInCart = false;
				
				for (cart c : cat) {
					if (c.getProducts().getproductid() == productid) {
						c.setQuantity(c.getQuantity() + 1);
						total += singleproduct.getPrice();
						System.err.println(total);
						productInCart = true;
						break;
					}
				}
				
				if (!productInCart) {
					int quantity = 1;
					total += singleproduct.getPrice();
					System.err.println(total);
					cat.add(new cart(singleproduct, quantity));
				}
			}
		}
		else if("minus".equals(value)) 
		{
			if (singleproduct != null) {
				boolean productInCart = false;
				
				for (cart c : cat) {
					if (c.getProducts().getproductid() == productid) {
						c.setQuantity(c.getQuantity() - 1);
						total -= singleproduct.getPrice();
						System.err.println(total);
						productInCart = true;
						break;
					}
				}
				
				if (!productInCart) {
					int quantity = 1;
					total -= singleproduct.getPrice();
					System.err.println(total);
					cat.add(new cart(singleproduct, quantity));
				}
			}
		}
		return "Product Added to Cart";
	}

	public String showProdcutPage(int productid, Model model) {
		Products singleproduct = productsrepository.findById(productid).get();
		model.addAttribute("product", singleproduct);
		System.err.println(singleproduct);
		return "ProductPage";
	}

	public String searchproduct(String searchname,Model model) 
	{
		searchlist = productsrepository.findByProducts(searchname);
		System.err.println(searchlist);
		model.addAttribute("productslist", searchlist);
		
		return "Success";
	}

}
