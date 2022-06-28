package com.leojr.modelmapper.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leojr.modelmapper.dtos.ProductModel;
import com.leojr.modelmapper.dtos.ProductSummaryModel;
import com.leojr.modelmapper.exception.ProductNotFoundException;
import com.leojr.modelmapper.model.Product;
import com.leojr.modelmapper.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<ProductSummaryModel> listAll() {
		return productRepository.findAll()
				.stream()
				.map(this::toProdutoSummaryModel)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ProductModel searchById(@PathVariable Long id) {
		Product product = productRepository.findById(id)
					.orElseThrow(ProductNotFoundException::new);
		return toProductModel(product);	
	}
	
	private ProductModel toProductModel(Product product) {
		return modelMapper.map(product, ProductModel.class);
	}
	private ProductSummaryModel toProdutoSummaryModel(Product product) {
		return modelMapper.map(product, ProductSummaryModel.class);
	}
	
//  Without using ModelMapper
//	private ProductModel toProductModel(Product product) {
//		var categoryModel = new CategoryModel();
//		categoryModel.setId(product.getCategory().getId());
//		categoryModel.setName(product.getCategory().getName());
//		
//		var productModel = new ProductModel();
//		productModel.setId(product.getId());
//		productModel.setName(product.getName());
//		productModel.setPrice(product.getPrice());
//		productModel.setCategory(categoryModel);
//		productModel.setStockStatus(product.getStockAmount() > 0
//				? StockStatus.AVAILABLE : StockStatus.UNAVAILABLE);
//		
//		return productModel;
//	}
		
//	Without using ModelMapper
//	private ProductSummaryModel toProdutoSummaryModel(Product product) {
//		var productSummaryModel = new ProductSummaryModel();
//		productSummaryModel.setId(product.getId());
//		productSummaryModel.setName(product.getName());
//		productSummaryModel.setCategory(product.getCategory().getName());
//		
//		return productSummaryModel;
//	}
	
}
