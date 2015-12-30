package com.heart.tests;

import org.testng.annotations.Test;

import com.heart.pages.MovieDetailPage;
import com.heart.pages.ResultsPage;
import com.heart.pages.SearchPage;

public class MovieDetails {

	SearchPage search = new SearchPage();
	ResultsPage result = new ResultsPage();
	MovieDetailPage detail = new MovieDetailPage();

	@Test
	public void GetMovieDetails() {

		String movieName = "the movie";

		search.searchMovies(movieName);
		result.movieExist(movieName);
		detail.AssertMovieTitle(movieName);

	}

}
