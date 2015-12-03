package rottentomateschallenge.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MovieListingPage extends WebDriverPage {
    int MAX_MOVIES=10;
    public MovieListingPage(WebDriver driver) {
        super(driver);
    }

    public By movies;
    public By movieImage;
    public By movieTitle;
    public By viewDetailsLink;

    public List<WebElement> getMovieList() { return driver.findElements(movies); }

    public WebElement getMovieByIndex(int index) {
        return getMovieList().get(index);
    }

    public WebElement findMovieByTitle(String title) {
        for (int i=0; i<MAX_MOVIES; i++) {
            WebElement movie = getMovieByIndex(i);
            if (movie.findElement(movieTitle).equals(title)) {
                return movie;
            }
        }

        //no movie found
        return null;
    }

    public MovieDetailsPage selectMovie(String title) {
        WebElement movie = findMovieByTitle(title);
        movie.click();
        return new MovieDetailsPage(driver);
    }

    @Override
    public void initializeElements() {
        movies = By.cssSelector("div.movie");
    }
}
