package rottentomateschallenge.automation;

import org.openqa.selenium.WebDriver;
import rottentomateschallenge.automation.pages.MovieDetailsPage;
import rottentomateschallenge.automation.pages.MovieListPage;
import rottentomateschallenge.automation.pages.SearchPage;

public class RottenTomatoesDriver {
    WebDriver driver;

    public RottenTomatoesDriver(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage search;
    public MovieListPage movieList;
    public MovieDetailsPage movieDetails;


    public void start() {
        initialisePageObjects();
    }


    private void initialisePageObjects(){
        search = new SearchPage(driver);
        movieList = new MovieListPage(driver);
        movieDetails = new MovieDetailsPage(driver);
    }
}
