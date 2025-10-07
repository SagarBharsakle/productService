package com.driving.e_commerce.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driving.e_commerce.entity.Product;
import com.driving.e_commerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService psi;

	@PostMapping("/add")
	public ResponseEntity<Product> setProduct(@RequestBody Product p) {

		Product addProduct = psi.addProduct(p);

		return new ResponseEntity<>(addProduct, HttpStatus.CREATED);

	}

	@GetMapping("/get")
	public ResponseEntity<List<Product>> getallProduct() {

		List<Product> product = psi.getProduct();

		return new ResponseEntity<>(product, HttpStatus.OK);

	}

	@PutMapping("/updated/{id}")
	public ResponseEntity<Product> updated(@PathVariable String id, @RequestBody Product p) {

		Product updatedproduct = psi.updatedproduct(id, p);

		return new ResponseEntity<>(updatedproduct, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/dalete/{id}")
	public ResponseEntity<String> deleted(@PathVariable String Id) {
		String delete = psi.delete(Id);

		return new ResponseEntity<>(delete, HttpStatus.OK);

	}

}
