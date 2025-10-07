package com.driving.e_commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driving.e_commerce.entity.Product;
import com.driving.e_commerce.repo.ProductRepo;

@Service
public class ProductServiceImpl  implements  ProductService{

	@Autowired
	private ProductRepo pr;

	@Override
	public Product addProduct(Product p) {
		Product save = pr.save(p);
		
		return save;
	}

	@Override
	public List<Product> getProduct() {
		List<Product> findAll = pr.findAll();
		return findAll;
	}

	@Override
	public Product updatedproduct(String id, Product p) {
	      Product exiting= pr.getByIdProduct(id);
	       exiting.setName(p.getName());
	       exiting.setPrice(p.getPrice());
	       exiting.setStock(p.getStock());
		
		return pr.save(exiting);
	}
	@Override
	public String delete(String id) {
		pr.deleteAll();
		return "Product Removed";
	}
	
	 
	
	
	
}
