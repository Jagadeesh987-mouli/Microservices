package com.jm.exception;

@SuppressWarnings("serial")
public class MovieNotFoundException extends RuntimeException
{
	public MovieNotFoundException(String errorMsg)
	{
		super(errorMsg);
	}
	
	public MovieNotFoundException()
	{
		super();
	}
}
