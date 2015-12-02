package rottentomateschallenge.automation;

import org.openqa.selenium.WebDriver;

public class RottenTomatoesDriver {
    WebDriver driver;

    public RottenTomatoesDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void start() {}
}
