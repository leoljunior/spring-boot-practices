package com.leojr.modelmapper.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductSummaryModel {

	private Long id;
	private String name;
//	private String categoryName; ao usar somente category o modelmapper vai retornar o toString da CategoryModel, retornarndo dados indesejaveis
								 //isso se deve a estrategia de correspondencia do modelmapper (Matching Strategies). Neste caso fizemos uma config
								 //do modelmapper para resolver isso.
	private String category;
}
