package com.project.Shopping.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productdetails")
public class Products {

	@Id
	private Integer productid;
	private String productname;
	private double Price;
	private int Quantity;
	private String image_url;
	private String description;
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Products [productid=" + productid + ", productname=" + productname + ", Price=" + Price + ", Quantity="
				+ Quantity + ", image_url=" + image_url + ", description=" + description + ", category=" + category
				+ "]";
	}

	public Products(Integer productid, String productname, double price, int Quantity, String image_url,
			String description, String category) {
		super();
		this.productid = productid;
		productname = productname;
		Price = price;
		Quantity = Quantity;
		image_url = image_url;
		description = description;
		this.category = category;
	}

	public Products() {
		super();
	}

	public Integer getproductid() {
		return productid;
	}

	public void setproductid(Integer productid) {
		this.productid = productid;
	}

	public String getproductname() {
		return productname;
	}

	public void setproductname(String productname) {
		productname = productname;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int Quantity) {
		Quantity = Quantity;
	}

	public String getimage_url() {
		return image_url;
	}

	public void setimage_url(String image_url) {
		image_url = image_url;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		description = description;
	}

}
