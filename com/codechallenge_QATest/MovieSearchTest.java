package com.codechallenge_QATest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codechallenge_QA.DetailMoviePage;
import com.codechallenge_QA.SearchMoviePage;
import com.codechallenge_QA.SearchResultMoviePage;

public class MovieSearchTest {

    	WebDriver driver;
	    SearchMoviePage searchmoviepage = new SearchMoviePage(driver);
	    SearchResultMoviePage searchresulstmoviepage = new SearchResultMoviePage(driver);
	    DetailMoviePage detailmoviepage = new DetailMoviePage(driver);

	    @Test
		public void searchExistingMovieTest(){
			searchmoviepage.navigateToWebApp();
			searchmoviepage.enterTitleName("Star Wars");
			searchresulstmoviepage = searchmoviepage.ClickSearch();
			Assert.assertTrue(searchresulstmoviepage.getInTheaterText().equals("In Theater"));
			Assert.assertTrue(searchresulstmoviepage.getMovieImage().equals("StarWars.jpeg"));
			
		}
	 
	    @Test
		public void searchNonExistingMovieTest(){
	    	searchmoviepage.navigateToWebApp();
	    	searchmoviepage.enterTitleName("BLAH BLAH BLAH");
	    	searchresulstmoviepage = searchmoviepage.ClickSearch();
	    	Assert.assertTrue(searchresulstmoviepage.getMovieNotFound().equals("Movie Not Found"));
		}
	    
	    @Test
		public void searchExistingMovieAndGoBackToHomePage(){
	    	searchmoviepage.navigateToWebApp();
			searchmoviepage.enterTitleName("Batman");
			searchresulstmoviepage = searchmoviepage.ClickSearch();
			detailmoviepage = searchresulstmoviepage.ClickTitle();
			Assert.assertTrue(detailmoviepage.getActorImage().equals("Batman.jpeg"));
			Assert.assertTrue(detailmoviepage.getReleaseDate().equals("02/02/2016"));
			searchmoviepage = detailmoviepage.clickHome();
			
		}
	    
	    @AfterClass
	    public void afterClass() {
	     driver.quit();
	    }

}
