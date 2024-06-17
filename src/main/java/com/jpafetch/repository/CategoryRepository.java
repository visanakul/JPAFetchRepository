package com.jpafetch.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpafetch.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID>{
	@EntityGraph(
		    type = EntityGraphType.FETCH,
		    attributePaths = {
		      "productEntities",
		      "productEntities.categoryEntity"
		    }
		  )
	List<CategoryEntity> findAll();
}
