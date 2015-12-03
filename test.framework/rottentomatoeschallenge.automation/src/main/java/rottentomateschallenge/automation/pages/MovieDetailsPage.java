package rottentomateschallenge.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovieDetailsPage extends WebDriverPage {

    public By MovieTitle;
    public By MovieImage;
    public By TatometerScore;
    public By AudienceScore;
    public By Rating;
    public By Duration;
    public By Description;

    public MovieDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void initializeElements() {
        MovieTitle = By.id("title");
    }


}
