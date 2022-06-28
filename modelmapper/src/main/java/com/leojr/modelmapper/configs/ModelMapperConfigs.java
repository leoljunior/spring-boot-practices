package com.leojr.modelmapper.configs;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.leojr.modelmapper.dtos.ProductModel;
import com.leojr.modelmapper.dtos.ProductSummaryModel;
import com.leojr.modelmapper.dtos.StockStatus;
import com.leojr.modelmapper.model.Product;

@Configuration
public class ModelMapperConfigs {

	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		
//		Criamos um conversor de inteiro(quantidade em estoque) para StockStatus
		Converter<Integer, StockStatus> stockStatusConverter = context 
				-> context.getSource() > 0 ? StockStatus.AVAILABLE : StockStatus.UNAVAILABLE;
		
//		Indicamos que quando for feita a conversão de Product para ProductModel sera usado o metodo conversor		
		modelMapper.createTypeMap(Product.class, ProductModel.class)
			.addMappings(mapper -> mapper.using(stockStatusConverter)
					.map(Product::getStockAmount, ProductModel::setStockStatus));
				
//		Params, tipo de entrada / tipo de saída
		modelMapper.createTypeMap(Product.class, ProductSummaryModel.class)
			.<String>addMapping(source -> source.getCategory().getName(),
					(destiny, value) -> destiny.setCategory(value));
				
		return modelMapper;
	}
}
