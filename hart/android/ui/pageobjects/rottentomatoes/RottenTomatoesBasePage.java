package com.hart.android.ui.pageobjects.rottentomatoes;

import com.kareo.ui.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by sushil.mayer on 12/10/2015.
 */

public class RottenTomatoesBasePage extends PageBase {
    @FindBy(id = "searchTextBox") private WebElement searchTextBox;
    @FindBy(id = "searchButton") private WebElement searchButton;

    public RottenTomatoesBasePage(WebDriver driver) {
        super(driver);
        this.initPage(searchTextBox);
    }

    public void setSearchTextBox(String text){
        try{
            System.out.println("Entering Search Text Box: " + text);
            searchTextBox.clear();
            searchTextBox.sendKeys(text);
        } catch (Exception e){
            System.out.println("ERROR: Entering Search Text Box: " + text);
        }
    }

    public String getSearchTextBox(){
        try{
            System.out.println("Getting Text from Search Text Box");
            return searchTextBox.getText();
        } catch (Exception e){
            System.out.println("ERROR: Entering Search Text Box");
        }
        return  null;
    }

    public boolean isInitialPageCorrect(){
        try{
            System.out.println("Verifying if the Initial Page is displaying: No Results");
            WebElement initialPageText = driver.findElement(By.cssSelector("indexPage"));
            if (initialPageText.getText().equalsIgnoreCase("No Results")){
                return true;
            }
        } catch (Exception e){
            System.out.println("ERROR: Verifying if the Initial Page");
        }
        return false;
    }

    public ResultsPage clickSearchButton(){
        try{
            System.out.println("Clicking Search Button");
            searchButton.click();
            return new ResultsPage(driver);
        } catch (Exception e){
            System.out.println("ERROR: Clicking Search Button");
        }
        return null;
    }

    public void takeScreenshot(){
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = null;
        try {
            capture = new Robot().createScreenCapture(screenRect);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}