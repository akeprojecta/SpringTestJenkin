package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final KafkaTemplate<String, String> kafkaTemplate;

	public ProductService(ProductRepository productRepository, KafkaTemplate<String, String> kafkaTemplate) {
		this.productRepository = productRepository;
		this.kafkaTemplate = kafkaTemplate;
	}

	public String createProduct() {

	    Product product = Product.builder()
	            .name("Product name")
	            .description("First project")
	            .quantity(1000)
	            .build();

		kafkaTemplate.send("wepower-product", "testtt");

		Product saveProduct = productRepository.save(product);
		return "yeahhh";

	}

}
