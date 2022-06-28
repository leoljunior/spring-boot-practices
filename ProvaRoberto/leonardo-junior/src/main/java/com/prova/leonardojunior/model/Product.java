package com.prova.leonardojunior.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Products")
public class Product {

	@Id
	private String id;
	private String code;
	private String name;
	private String description;
	private BigDecimal price;
	private String category;
	
	@DBRef
	private List<Auditing> auditings = new ArrayList<>();
	
	public void saveAuditings(Auditing auditing) {
		this.auditings.add(auditing);
	}
}
