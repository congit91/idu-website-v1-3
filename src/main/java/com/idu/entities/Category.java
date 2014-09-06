package com.idu.entities;

// Generated Sep 5, 2014 3:35:31 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "db_iduwebsite", uniqueConstraints = @UniqueConstraint(columnNames = "categoryName"))
public class Category  {

	private Integer categoryId;
	private String categoryName;
	private boolean active;
	private Set<News> newses = new HashSet<News>(0);

	public Category() {
	}

	public Category(String categoryName, boolean active) {
		this.categoryName = categoryName;
		this.active = active;
	}

	public Category(String categoryName, boolean active, Set<News> newses) {
		this.categoryName = categoryName;
		this.active = active;
		this.newses = newses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "categoryId", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "categoryName", unique = true, nullable = false, length = 45)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	public Set<News> getNewses() {
		return this.newses;
	}

	public void setNewses(Set<News> newses) {
		this.newses = newses;
	}

	@Override
	public boolean equals(Object obj) {
		/*if(obj == null)
			return false;
		if(obj instanceof Category){
			Category category =(Category)obj;
			return this.categoryId == category.getCategoryId();
		}*/
		return true;
	}

	
	
}
