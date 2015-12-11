package com.hart.android.ui.pageobjects.rottentomatoes;

import com.kareo.ui.UIUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by sushil.mayer on 12/10/2015.
 */
public class DetailsPage extends RottenTomatoesBasePage{
    @FindBy(id = "tatometer") private WebElement tatometer;
    @FindBy(id = "audienceScore") private WebElement audienceScore;

    public DetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, pageTimeoutTime), this);

        UIUtility.waitForElementVisibility(driver, pageTimeoutTime, tatometer);
        UIUtility.waitForElementVisibility(driver, pageTimeoutTime, audienceScore);
    }

    public String getTatometer(){
        try{
            System.out.println("Getting Tatometer Element Text");
            return tatometer.getText();
        } catch (Exception e){
            System.out.println("ERROR: Getting Tatometer Element Text");
        }
        return null;
    }

    public String getAudienceScore(){
        try{
            System.out.println("Getting Audience Score Element Text");
            return audienceScore.getText();
        } catch (Exception e){
            System.out.println("ERROR: Getting Audience Score Element Text");
        }
        return null;
    }

    public String getTitle(){
        try{
            System.out.println("Getting Title Element Text");

            WebElement title = driver.findElement(By.name("title"));
            return title.getText();
        } catch (Exception e){
            System.out.println("ERROR: Getting Title Element Text");
        }
        return null;
    }

    public String getRating(){
        try{
            System.out.println("Getting Rating Element Text");

            WebElement rating = driver.findElement(By.name("rating"));
            return rating.getText();
        } catch (Exception e){
            System.out.println("ERROR: Getting Rating Element Text");
        }
        return null;
    }

    public String getDuratoin(){
        try{
            System.out.println("Getting Duration Element Text");

            WebElement duration = driver.findElement(By.name("duration"));
            return duration.getText();
        } catch (Exception e){
            System.out.println("ERROR: Getting Duration Element Text");
        }
        return null;
    }

    public String getSummary(){
        try{
            System.out.println("Getting Summary Element Text");

            WebElement summary = driver.findElement(By.name("summary"));
            return summary.getText();
        } catch (Exception e){
            System.out.println("ERROR: Getting Summary Element Text");
        }
        return null;
    }

    public String getDirector(){
        try{
            System.out.println("Getting Director Element Text");

            WebElement director = driver.findElement(By.name("director"));
            return director.getText();
        } catch (Exception e){
            System.out.println("ERROR: Getting Director Element Text");
        }
        return null;
    }
}
