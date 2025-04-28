package com.jm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.model.Movie;
import com.jm.repository.IMovieRepository;

@Service
public class MovieServiceClass implements IMovieService
{
	@Autowired
	private IMovieRepository movieRepo;
	
	@Override
	public String addMovie(Movie movie)
	{
		int id = movieRepo.save(movie).getMovieId();
		return "Movie details are saved with id : "+id;
	}
	
	@Override
	public List<Movie> fetchAllMovies() 
	{
		return movieRepo.findAll();
	}
	
	@Override
	public Optional<Movie> fetchMovieById(int id) 
	{
		return movieRepo.findById(id);
	}
	
	@Override
	public String modifyMovie(Movie movie) 
	{
		fetchMovieById(movie.getMovieId());
		movieRepo.save(movie);
		return "Movie details are updated - id :"+movie.getMovieId();
	}

	@Override
	public String modifyMovieName(int id, String name)
	{
		Optional<Movie> opt = fetchMovieById(id);
		if(opt.isPresent())
		{
			Movie movie = opt.get();
			movie.setMovieName(name);
			movieRepo.save(movie);
			return "Movie name is updated - id :"+id;
		}
		else {
			return "Movie not found updation";
		}
		
	}
	
	@Override
	public String removeMovieById(int id) 
	{
		fetchMovieById(id);
		movieRepo.deleteById(id);
		return "Movie details are deleted - id :"+id;
	}
}
