package com.prova.leonardojunior.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.prova.leonardojunior.enums.Operation;

import lombok.Data;

@Data
@Document(collection = "Auditings")
public class Auditing {

	@Id
	private String id;
	
	private LocalDateTime eventDate;
	
	private Operation operation;
	
	
	
}
