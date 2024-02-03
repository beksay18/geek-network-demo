package com.geek.controller;

import com.geek.entity.Actors;
import com.geek.entity.Genders;
import com.geek.repository.ActorRepository;
import com.geek.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ActorsController {

	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/add_actors")
	public String showActorForm(Model model) {
		List<Actors> listActors = actorRepository.findAll();
		List<Genders> listGenders = Arrays.asList(Genders.values());
		model.addAttribute("actors", new Actors());
		model.addAttribute("listActors", listActors);
		model.addAttribute("listGenders", listGenders);
		return "actor_form";
	}

	@PostMapping("/save_actors")
	public String saveActors(Actors actors, Model model) {
		actorRepository.save(actors);

		List<Actors> listActors = actorRepository.findAll();
		List<Genders> listGenders = Arrays.asList(Genders.values());
		model.addAttribute("listActors", listActors);
		model.addAttribute("actors", new Actors());
		model.addAttribute("listGenders", listGenders);
		return "actor_form";
	}

}
