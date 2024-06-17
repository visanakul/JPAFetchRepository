package com.jpafetch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name = "Product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long product_id;
	private String title;
	private float price;
	private String description;
	@ManyToOne
	@JoinColumn(name="category_id")
	@JsonIgnore
	private CategoryEntity categoryEntity;
	
	@Override
	public String toString() {
		return "("+product_id+"="+title+"="+price+"="+description+")";
	}
}
