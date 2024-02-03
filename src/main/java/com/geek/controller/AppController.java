package com.geek.controller;

import java.util.*;

import com.geek.entity.Actors;
import com.geek.entity.Category;
import com.geek.entity.Movie;
import com.geek.entity.User;
import com.geek.repository.ActorRepository;
import com.geek.repository.CategoryRepository;
import com.geek.repository.MovieRepository;
import com.geek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}

	@GetMapping("/add_movie")
	public String showMovieForm(Model model) {
		List<Actors> listActors = actorRepository.findAll();
		List<Category> listCategories = categoryRepository.findAll();
		model.addAttribute("movie", new Movie());
		model.addAttribute("listActors", listActors);
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("actors", new HashSet<>());
		return "movie_form";
	}

	@PostMapping("/save_movie")
	public String saveMovie(Movie movie, Model model) {

        movie.setDateCreated(new Date());
		movieRepository.save(movie);

		List<Movie> listMovies = movieRepository.findAll();
		model.addAttribute("listMovies", listMovies);
		return "users";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);

		List<Movie> listMovies = movieRepository.findAll();
		model.addAttribute("listMovies", listMovies);
		
		return "users";
	}

	@GetMapping("/cancel")
	public String cancel(Model model) {
		model.addAttribute("movie", new Movie());
		List<Movie> listMovies = movieRepository.findAll();
		model.addAttribute("listMovies", listMovies);
		return "users";
	}
}
