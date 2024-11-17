package com.cjc.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cjc.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProduct(int id);

	boolean deleteProduct(int id);

	Product updateProduct(Integer id, Product product);

	Product addProduct(Product product);

}
