package com.jm.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="REST_MOVIES")
public class Movie 
{
	@Id
	@SequenceGenerator(sequenceName = "GEN_MOVIE_ID", name = "GEN1", initialValue = 1000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN1")
	private Integer movieId;
	
	@Column(length = 50)
	private String movieName;
	
	private Integer releaseYear;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date releaseDate;
	
	@Column(length = 30)
	private String director;
	
	@Column(length = 30)
	private String actor;
	
	@Column(length = 30)
	private String actress;
	
	@Column(length = 30)
	private String language;
	
	@Column(length = 30)
	private String genres;
	
	@ElementCollection
	@CollectionTable(name = "REST_MOVIE_SHOWTIMES", joinColumns = @JoinColumn(referencedColumnName = "movieId"))
	private List<String> showTimes;
}
