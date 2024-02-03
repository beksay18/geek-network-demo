package com.geek.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 500)
	private String title;
	@Column(nullable = false, length = 500)
	private String description;
	private String duration;
	@Column(name = "release_date")
	private Date releaseDate;
	@Column(name = "date_created")
	private Date dateCreated;
	private BigDecimal costs;
	private Double rating;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@ElementCollection(targetClass = Languages.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "movie_language",
			joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
	@Enumerated(EnumType.STRING)
	@Column(name = "language")
	private Set<Languages> languageList = new HashSet<>();

	@ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinTable(name = "movie_actors",
			joinColumns = @JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private Set<Actors> actors = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public BigDecimal getCosts() {
		return costs;
	}

	public void setCosts(BigDecimal costs) {
		this.costs = costs;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Languages> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(Set<Languages> languageList) {
		this.languageList = languageList;
	}

	public Set<Actors> getActors() {
		return actors;
	}

	public void setActors(Set<Actors> actors) {
		this.actors = actors;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
