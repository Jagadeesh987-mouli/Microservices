package com.jm.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jm.model.Movie;

@FeignClient("MovieService")
public interface MovieServiceClientComp
{
	@GetMapping("/Movie-service/movie-api/get/{id}")
	public Optional<Movie> executeGetMovieById(@PathVariable int id);
}
