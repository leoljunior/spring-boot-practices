package com.leojr.modelmapper;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leojr.modelmapper.model.Category;
import com.leojr.modelmapper.model.Product;
import com.leojr.modelmapper.repository.CategoryRepository;
import com.leojr.modelmapper.repository.ProductRepository;

@SpringBootApplication
public class ModelmapperApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ModelmapperApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category();
		Category cat2 = new Category();
		cat1.setName("Games");
		cat2.setName("Hardware");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
		Product p1 = new Product();
		p1.setName("Resident Evil 2");
		p1.setPrice(new BigDecimal(179.99));
		p1.setStockAmount(0);
		p1.setCategory(cat1);
		
		Product p2 = new Product();
		p2.setName("Dark Souls: Prepare to Die");
		p2.setPrice(new BigDecimal(279.99));
		p2.setStockAmount(6);
		p2.setCategory(cat1);
		
		Product p3 = new Product();
		p3.setName("GEFORCE GTX 1660");
		p3.setPrice(new BigDecimal(2779.99));
		p3.setStockAmount(0);
		p3.setCategory(cat2);
		
		Product p4 = new Product();
		p4.setName("Water Cooler - Cooler Master");
		p4.setPrice(new BigDecimal(779.99));
		p4.setStockAmount(3);
		p4.setCategory(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	}

}
