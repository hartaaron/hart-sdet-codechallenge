package com.heart.tests;

import org.testng.annotations.Test;

import com.heart.challenge.com.heart.challenge.BaseUtil;
import com.heart.pages.ResultsPage;
import com.heart.pages.SearchPage;

public class SearchFunction extends BaseUtil {

	SearchPage search = new SearchPage();
	ResultsPage result = new ResultsPage();

	@Test
	public void BlankSearch() {
		search.searchMovies(" ");
	}

	@Test
	public void ValidSearch() {
		String movieName = "Pulp Fiction";

		search.searchMovies(movieName);
	}

}
