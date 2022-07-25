package com.skillstorm.services;

/**
 * Services perform some business logic for us. this URLParser parses our url from the client side to be readable on the server side  
 * @author phil
 *
 */
public class URLParserService {
	public int extractIdFromURL(String url) {
		// System.out.println(url);
		String[] splitString = url.split("/");
		
		return Integer.parseInt(splitString[1]); // Throws an exception if this isn't a int
	}

	public String extractStringFromURL(String url) {
		String[] splitString = url.split("/");
		
		return splitString[1];
	}
}
