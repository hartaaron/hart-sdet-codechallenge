package com.heart.tests;

import org.testng.annotations.Test;

import com.heart.challenge.com.heart.challenge.BaseUtil;
import com.heart.pages.MovieDetailPage;
import com.heart.pages.ResultsPage;
import com.heart.pages.SearchPage;

public class ResultsOfMovieSearch extends BaseUtil {

	SearchPage search = new SearchPage();
	ResultsPage result = new ResultsPage();

	@Test
	public void findMovie() {

		String movieName = "the movie";

		search.searchMovies(movieName);
		result.movieExist(movieName);

	}

	@Test
	public void MovieDoesNotExist() {
		String movieName = " ";

		search.searchMovies(movieName);
		result.noMovieExist();
	}

}
