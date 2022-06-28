package com.prova.leonardojunior.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.prova.leonardojunior.dtos.ProductDTO;
import com.prova.leonardojunior.enums.Operation;
import com.prova.leonardojunior.exception.ObjectNotFoundException;
import com.prova.leonardojunior.model.Auditing;
import com.prova.leonardojunior.model.Product;
import com.prova.leonardojunior.repositories.AuditingRepository;
import com.prova.leonardojunior.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final AuditingRepository auditingRepository;
	
	public List<ProductDTO> getAllProducts() {
		List<Product> productList = productRepository.findAll();		
		return productList.stream()
				.map(ProductDTO::new)
				.collect(Collectors.toList());				
	}
	
	public Product getProductById(String id) {
		Optional<Product> findById = productRepository.findById(id);
		
		return findById.orElseThrow(() -> new ObjectNotFoundException("Produto com ID: " + id + " não encontrado"));
	}
	
	public void updateProduct(ProductDTO productDTO, String id) {
		Product product = getProductById(id);
		
		product.setCode(productDTO.getCode());
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setCategory(productDTO.getCategory());
		
		Auditing auditing = new Auditing();
		auditing.setEventDate(LocalDateTime.now());
		auditing.setOperation(Operation.UPDATE);
		auditingRepository.save(auditing);
		product.saveAuditings(auditing);
		
		productRepository.save(product);
	}
	
	public Product createProduct(ProductDTO productDTO) {
				
		Product product = convertToEntity(productDTO);
		
		Auditing auditing = new Auditing();
		auditing.setEventDate(LocalDateTime.now());
		auditing.setOperation(Operation.CREATE);
		auditingRepository.save(auditing);
		product.saveAuditings(auditing);
		
		return productRepository.save(product);
	}
	
	public void deleteProduct(String id) {
		
		Product product = getProductById(id);
		
		Auditing auditing = new Auditing();
		auditing.setEventDate(LocalDateTime.now());
		auditing.setOperation(Operation.DELETE);
		auditingRepository.save(auditing);
		product.saveAuditings(auditing);
		
		productRepository.deleteById(id);
	}
	
	private Product convertToEntity(ProductDTO productDTO) {		
		Product product = new Product(); 		
		BeanUtils.copyProperties(productDTO, product);		
		return product;
	}
}
