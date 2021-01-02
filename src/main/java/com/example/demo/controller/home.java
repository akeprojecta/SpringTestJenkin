package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {


	private final ProductService productService;
	public home(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/")
	public String homepage() {
		return productService.createProduct();
	}

}
