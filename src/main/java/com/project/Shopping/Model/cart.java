package com.project.Shopping.Model;

public class cart {

	private Products products;
	private int Quantity;

	public cart() {
		super();
	}

	public cart(Products products, int quantity) {
		super();
		this.products = products;
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "cart [products=" + products + ", Quantity=" + Quantity + "]";
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

}
