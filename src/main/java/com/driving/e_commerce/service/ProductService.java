package com.driving.e_commerce.service;

import java.util.List;

import com.driving.e_commerce.entity.Product;

public interface ProductService {

	public Product addProduct(Product p);

	public List<Product> getProduct();

	public Product updatedproduct(String id ,Product p);

	public String delete(String id);

}
