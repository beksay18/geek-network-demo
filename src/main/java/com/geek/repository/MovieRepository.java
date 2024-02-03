package com.geek.repository;

import com.geek.entity.Movie;
import com.geek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	@Query("SELECT m FROM Movie m WHERE m.title = ?1")
	public Movie findByTitle(String title);
	
}
