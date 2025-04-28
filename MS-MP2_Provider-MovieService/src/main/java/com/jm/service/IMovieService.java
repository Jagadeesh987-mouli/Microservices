package com.jm.service;

import java.util.List;
import java.util.Optional;

import com.jm.model.Movie;

public interface IMovieService 
{
	public String addMovie(Movie movie);
	public List<Movie> fetchAllMovies();
	public Optional<Movie> fetchMovieById(int id);
	public String modifyMovie(Movie movie);
	public String modifyMovieName(int id, String name);
	public String removeMovieById(int id);
}
