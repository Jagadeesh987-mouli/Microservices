package com.jm.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jm.exception.MovieNotFoundException;
import com.jm.model.ErrorDetails;

@RestControllerAdvice
public class MovieOperationsControllerAdvice
{
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllErrors(Exception e)
	{
		System.out.println("MovieOperationsControllerAdvice.handleAllErrors()");
		ErrorDetails error = new ErrorDetails( LocalDateTime.now(), e.getMessage(), "Internal ERROR");
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleMovieNotFoundException(MovieNotFoundException mnfe)
	{
		System.out.println("MovieOperationsControllerAdvice.handleAllErrors()");
		ErrorDetails error = new ErrorDetails( LocalDateTime.now(), mnfe.getMessage(), "Internal ERROR");
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
