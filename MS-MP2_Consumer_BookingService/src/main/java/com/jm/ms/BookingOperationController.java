package com.jm.ms;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jm.client.MovieServiceClientComp;
import com.jm.exception.MovieNotFoundException;
import com.jm.model.Movie;

@RestController
@RequestMapping("/booking-api")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingOperationController 
{
	@Autowired
	private MovieServiceClientComp client;
	
	@GetMapping("/book/{mid}/{tickets}/{showTime}")
	public ResponseEntity<String> bookTicket(@PathVariable int mid, @PathVariable int tickets, @PathVariable String showTime)
	{
		Optional<Movie> opt = client.executeGetMovieById(mid);
		if(opt.isPresent()) 
		{
			Movie movie = opt.get();
            List<String> showTimes = movie.getShowTimes();
    		if(!showTimes.contains(showTime))
    		{
    			 return new ResponseEntity<String>("Showtime not available for this movie", HttpStatus.OK);			 
    		}
    		
    		return new ResponseEntity<String>("Booking successful for " + tickets + " tickets to watch '" + movie.getMovieName() + "' at " + showTime, HttpStatus.OK);
        }
		else {
			throw new MovieNotFoundException("Movie not found");
		}
		
	}
}
