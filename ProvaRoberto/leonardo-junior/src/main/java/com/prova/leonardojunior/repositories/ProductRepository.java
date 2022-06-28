package com.prova.leonardojunior.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.prova.leonardojunior.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
