package com.geek.repository;

import com.geek.entity.Category;
import com.geek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query("SELECT c FROM Category c WHERE c.name = ?1")
	public Category findByName(String name);
	
}
