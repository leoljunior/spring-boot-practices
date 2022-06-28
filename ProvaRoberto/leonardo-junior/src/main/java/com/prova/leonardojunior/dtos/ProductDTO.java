package com.prova.leonardojunior.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.prova.leonardojunior.model.Auditing;
import com.prova.leonardojunior.model.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
		
	
	private String id;
	
	@NotBlank(message = "Field Code can´t be blank.")
	@NotNull(message = "Field Code can´t be null.")
	private String code;
	
	@NotBlank(message = "Field Name can´t be blank.")
	@NotNull(message = "Field Name can´t be null.")
	private String name;
	
	@NotBlank(message = "Field Description can´t be blank.")
	@NotNull(message = "Field Description can´t be null.")
	private String description;
	
	@DecimalMin(message = "Minimum value must be 1", value = "1")
	@NotNull(message = "Field Price can´t be null.")
	private BigDecimal price;
	
	@NotBlank(message = "Field Category can´t be blank.")
	@NotNull(message = "Field Category can´t be null.")
	private String category;
	
	private List<Auditing> auditings = new ArrayList<>();

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.code = product.getCode();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.category = product.getCategory();
		product.getAuditings().forEach(d -> this.auditings.add(d));
	}
	
	
	
}
