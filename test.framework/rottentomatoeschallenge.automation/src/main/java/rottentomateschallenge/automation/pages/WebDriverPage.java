package rottentomateschallenge.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rottentomateschallenge.automation.AutomationException;

import java.util.logging.Logger;

public abstract class WebDriverPage<T> {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log;

    public long timeout = 60;

    public String url;
    public String title;

    public WebDriverPage(WebDriver driver) {
        initializeLogger();
        this.driver = driver;
        wait = new WebDriverWait(this.driver, timeout);
        initializeElements();
    }

    /**
     * This needs implemented for each page.
     * It injects webdriver as needed.
     */
    public abstract void initializeElements();

    public void setUrl(String url) { this.url = url; }
    public String getUrl() { return url; }

    public void setExpectedTitle(String title) { this.title = title; }
    public String getExpectedTitle() { return title; }

    public String getTitle() {
        return driver.getTitle();
    }


    public WebDriverPage<T> navigateTo() throws AutomationException {
        driver.get(url);
        checkIfCurrentPage();
        return this;
    }

    public Boolean isCurrentPage() throws AutomationException {
        try {
            wait.until(ExpectedConditions.titleIs(getExpectedTitle()));
        } catch (WebDriverException e) {

            return false;
        }

        return true;
    }

    protected void checkIfCurrentPage() throws AutomationException {
        if (! isCurrentPage()) {
            throw new AutomationException("not on expected page: " + getPageName());
        }
    }


    protected void initializeLogger() {
        String page = this.getClass().getSimpleName();
        log = Logger.getLogger(page);
    }


    public String getPageName() {
        return this.getClass().getSimpleName();
    }
}
