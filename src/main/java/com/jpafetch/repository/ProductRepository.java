package com.jpafetch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpafetch.entity.ProductEntity;

public interface ProductRepository  extends JpaRepository<ProductEntity, Long>{

}
