package com.leojr.modelmapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leojr.modelmapper.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}