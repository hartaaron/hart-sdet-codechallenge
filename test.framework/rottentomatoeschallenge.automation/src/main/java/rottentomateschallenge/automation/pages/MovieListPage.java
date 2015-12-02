package rottentomateschallenge.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MovieListPage extends WebDriverPage {
    int MAX_MOVIES=10;
    public MovieListPage(WebDriver driver) {
        super(driver);
    }

    public By movie;
    public By movieImage;
    public By movieTitle;
    public By viewDetailsLink;

    public WebElement getMovieByIndex(int index) {
        return driver.findElements(movie).get(index);
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


    @Override
    public void initializeElements() {
        movie = By.cssSelector("div.movie");
    }
}
