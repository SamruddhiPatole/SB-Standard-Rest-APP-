package com.cjc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cjc.model.Product;
import com.cjc.repository.ProductRepository;
import com.cjc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public Product getProduct(int id) {
		if (productRepository.existsById(id)) {
			return productRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public boolean deleteProduct(int id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		if(productRepository.existsById(id))
		{
		product.setProductId(id);
		return productRepository.save(product);
		}
		return null;
	}
	
	@Override
	public Product addProduct(Product product) {
	return	productRepository.save(product);
	}
}
