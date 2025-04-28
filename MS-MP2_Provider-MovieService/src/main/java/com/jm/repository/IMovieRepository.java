package com.jm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jm.model.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer>
{

}
