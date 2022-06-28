package com.prova.leonardojunior.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.prova.leonardojunior.dtos.ProductDTO;
import com.prova.leonardojunior.model.Product;
import com.prova.leonardojunior.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> listAllProducts() {	
		List<ProductDTO> productList = productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTO productDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable String id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody @Valid ProductDTO productDTO, @PathVariable String id) {
		productService.updateProduct(productDTO, id);
		return ResponseEntity.status(HttpStatus.OK).body("Product updated successfully.");
	}
}
