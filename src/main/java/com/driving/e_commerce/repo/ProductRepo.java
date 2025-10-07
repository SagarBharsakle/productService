package com.driving.e_commerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.driving.e_commerce.entity.Product;
@Repository
public interface ProductRepo extends  JpaRepository <Product,String>{

	
	public List<Product> findByid(String id);
	
	
	@Modifying
	@Query("UPDATE Product p SET p.name = :name, p.price = :price, p.stock=:stock WHERE p.id = :id")
	int updateBook(@Param("id") String id,
	               @Param("price") double price,
	               @Param("name") String name,
                 	@Param("stock") int stock);

	   @Query("SELECT p FROM Product p WHERE p.id = :id")
	    Product getByIdProduct(String id);
	
	
	
	
}
