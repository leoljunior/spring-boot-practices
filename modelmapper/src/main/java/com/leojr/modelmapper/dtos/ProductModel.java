package com.leojr.modelmapper.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductModel {

	private Long id;
	private String name;
	private BigDecimal price;
	private CategoryModel category;
	private StockStatus stockStatus;
	
}
