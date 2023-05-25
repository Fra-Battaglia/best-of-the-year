package org.java.best.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MyController {
	
	@GetMapping("/")
	private List<Movie> getBestMovies() {
		return Arrays.asList(new Movie[] {
				new Movie(1, "Movie1"),
		});
	};
	private List<Song> getBestSongs() {
		return Arrays.asList(new Song[] {
				new Song(1, "Song1"),
		});
	}
	
	
	// Home
	@GetMapping("/hello")
	public String sayHello(Model model,
			@RequestParam(name = "name") String name) {
		
		model.addAttribute("name", name);
		
		return "index";
	}
	
	
	// Movies
	@GetMapping("/movies")
	public String sayMovies(Model model) {
		
		String mts = "";
		Iterator<Movie> it = getBestMovies().iterator();
		while(it.hasNext()) {
			
			mts += it.next().getTitle();
			
			if (it.hasNext())
				mts += ", ";
		}
		
		model.addAttribute("movies", mts);
		
		return "movies";
	}
	
	
	// Songs
	@GetMapping("/songs")
	public String saySongs(Model model) {
		
		String mts = "";
		Iterator<Song> it = getBestSongs().iterator();
		while(it.hasNext()) {
			
			mts += it.next().getTitle();
			
			if (it.hasNext())
				mts += ", ";
		}
		
		model.addAttribute("song", mts);
		
		return "songs";
	}
}
