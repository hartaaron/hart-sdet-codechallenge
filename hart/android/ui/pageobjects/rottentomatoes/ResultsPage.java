package com.hart.android.ui.pageobjects.rottentomatoes;

import com.kareo.ui.UIUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

/**
 * Created by sushil.mayer on 12/10/2015.
 */

public class ResultsPage extends RottenTomatoesBasePage{

    public ResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, pageTimeoutTime), this);
        UIUtility.waitForElementVisibility(driver, pageTimeoutTime, getNthResult(0));
    }

    public List<WebElement> getResultsList() {
        try {
            System.out.println("Getting All Search Results");

            List<WebElement> results = UIUtility.getElementByPrefix(driver, "li", "ng-repeat", "result in results");
            return results;
        } catch (Exception e){
            System.out.println("ERROR: Getting All Search Results");
        }
        return null;
    }

    public WebElement getNthResult(int n) {
        try {
            System.out.println("Getting Search Result Index: " + n);
            List<WebElement> results = getResultsList();
            return  results.get(n);
        } catch (Exception e){
            System.out.println("ERROR: Getting Search Result Index: " + n);
        }
        return null;
    }

    public boolean isTitleInList(String text){
        try{
            System.out.println("Is Movie Title In Results List: " + text);

            List<String> titles = getAllTitles();
            for (String title : titles){
                if (title.equalsIgnoreCase(text)){
                    return true;
                }
            }
        } catch (Exception e){
            System.out.println("ERROR: Finding Movie Title In Results List: " + text);
        }
        return false;
    }

    public List<String> getAllTitles() {
        try {
            System.out.println("Getting All Search Titles");

            List<WebElement> results = getResultsList();
            List<String> titles = null;

            for (WebElement result : results){
                titles.add(result.getAttribute("title"));
            }
            return titles;
        } catch (Exception e){
            System.out.println("ERROR: Getting All Search Titles");
        }
        return null;
    }

    public List<String> getAllRatings() {
        try {
            System.out.println("Getting All Search Ratings");

            List<WebElement> results = getResultsList();
            List<String> ratings = null;

            for (WebElement result : results){
                ratings.add(result.getAttribute("rating"));
            }
            return ratings;
        } catch (Exception e){
            System.out.println("ERROR: Getting All Search Ratings");
        }
        return null;
    }

    public List<String> getAllDurations() {
        try {
            System.out.println("Getting All Search Durations");

            List<WebElement> results = getResultsList();
            List<String> durations = null;

            for (WebElement result : results){
                durations.add(result.getAttribute("duration"));
            }
            return durations;
        } catch (Exception e){
            System.out.println("ERROR: Getting All Search Durations");
        }
        return null;
    }

    public DetailsPage clickMovieByTitle(String title) {
        try {
            System.out.println("Selecting Movie By Title: " + title);

            List<WebElement> results = getResultsList();
            for (WebElement result : results){
                if(result.getAttribute("title").equalsIgnoreCase(title)){
                    UIUtility.scrollTo(result);
                    result.click();
                    return new DetailsPage(driver);
                }
            }
        } catch (Exception e){
            System.out.println("ERROR: Selecting Movie By Title: " + title);
        }
        return null;
    }

    public DetailsPage clickMovieById(String id) {
        try {
            System.out.println("Selecting Movie By ID: " + id);

            List<WebElement> results = getResultsList();
            for (WebElement result : results){
                if(result.getAttribute("id").equalsIgnoreCase(id)){
                    UIUtility.scrollTo(result);
                    result.click();
                    return new DetailsPage(driver);
                }
            }
        } catch (Exception e){
            System.out.println("ERROR: Selecting Movie By ID: " + id);
        }
        return null;
    }

}
