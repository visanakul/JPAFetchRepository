package com.jpafetch.entity;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name = "Category")
public class CategoryEntity {
	@Id
	@UuidGenerator(style = Style.AUTO)
	private UUID category_id;
	@Column(unique = true)
	private String name;
	@OneToMany(mappedBy = "categoryEntity", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("price DESC")
	private List<ProductEntity> productEntities;
	@BatchSize(size = 10)
	@Override
	public String toString() {
		return "("+category_id+"="+name+")";
	}
}
