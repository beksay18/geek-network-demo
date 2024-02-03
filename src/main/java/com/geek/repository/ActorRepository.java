package com.geek.repository;

import com.geek.entity.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActorRepository extends JpaRepository<Actors, Long> {
	@Query("SELECT a FROM Actors a WHERE a.firstName = ?1")
	public Actors findByName(String name);
	
}
