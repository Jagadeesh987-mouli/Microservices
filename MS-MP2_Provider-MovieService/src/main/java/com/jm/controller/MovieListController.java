package com.jm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jm.model.Movie;
import com.jm.service.IMovieService;

@RestController
@RequestMapping("/movie-api")
@CrossOrigin(origins = "http://localhost:5173")
public class MovieListController 
{
	@Autowired
	private IMovieService movieService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerMovie(@RequestBody Movie movie)
	{
		return new ResponseEntity<String>(movieService.addMovie(movie), HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Movie>> getAllMovies()
	{
		return new ResponseEntity<List<Movie>>(movieService.fetchAllMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable int id)
	{
		return new ResponseEntity<>(movieService.fetchMovieById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateMovie(@RequestBody Movie movie)
	{
		return new ResponseEntity<String>(movieService.modifyMovie(movie), HttpStatus.OK);
	}
	
	@PatchMapping("/update/{id}/{name}")
	public ResponseEntity<String> updateMovieByName(@PathVariable int id, @PathVariable String name)
	{
		return new ResponseEntity<String>(movieService.modifyMovieName(id, name), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMovieById(@PathVariable int id)
	{
		return new ResponseEntity<String>(movieService.removeMovieById(id), HttpStatus.OK);
	}
}

