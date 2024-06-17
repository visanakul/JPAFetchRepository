package com.jpafetch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpafetch.entity.CategoryEntity;
import com.jpafetch.repository.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/fetch")
public class FetchTypeController {
	private CategoryRepository categoryRepository;

	public FetchTypeController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@GetMapping
	public List<CategoryEntity> getAllCategories() {
		List<String> productTitles=new ArrayList<>();
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
		System.out.println("-----Before fetching children(EAGER,SUBSELECT, BatchSize 10)-----");
		System.out.println(categoryEntities);
		categoryEntities.forEach(c -> {
			System.out.println();
			System.out.println(c.getName());
			c.getProductEntities().forEach(p -> {
				productTitles.add(p.getTitle());
			});

		});
		System.out.println("-----After fetching children-----");
		System.out.println(categoryEntities);
		System.out.println(productTitles);
		return categoryEntities;
	}

	@PostMapping
	public ResponseEntity<?> saveCategoryWithProduct(@RequestBody List<CategoryEntity> entities) {
		System.out.println(entities);
		for (CategoryEntity entity : entities) {
			entity.getProductEntities().forEach(p -> {
				p.setCategoryEntity(entity);
			});
		}
		
		categoryRepository.saveAll(entities);
		Map<String, String> map = new HashMap<>();
		map.put("message", "Records Saved");
		map.put("code", String.valueOf(HttpStatus.OK.value()));
		return new ResponseEntity(map, HttpStatus.OK);
	}

}
