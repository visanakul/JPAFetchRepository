package com.jpafetch.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpafetch.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID>{
	
}
