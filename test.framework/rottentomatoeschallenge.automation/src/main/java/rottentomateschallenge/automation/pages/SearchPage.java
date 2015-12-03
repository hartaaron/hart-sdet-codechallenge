package rottentomateschallenge.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import rottentomateschallenge.automation.AutomationException;

public class SearchPage extends WebDriverPage {

    By searchIcon;
    By searchField;
    By searchButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void initializeElements() {
        searchIcon = By.id("search-icon");
        searchField = By.id("search-field");
        searchButton = By.cssSelector("search-button");
    }

    public void searchFor(String title) throws AutomationException {
        isCurrentPage();
        driver.findElement(searchIcon).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(searchField));
        driver.findElement(searchField).sendKeys(title);
        driver.findElement(searchButton).click();
    }
}
