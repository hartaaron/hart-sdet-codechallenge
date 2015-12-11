package com.codechallenge_QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailMoviePage extends AbstractPage {
	
	public DetailMoviePage(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy(id = "Search Page")
	public WebElement searchPage;
	
	@FindBy(xpath="//img[contains(@id,'Actor Image')]")
	public WebElement actorImage;
	
	@FindBy(linkText = "ReleaseDate")
	public WebElement releaseDate;
	
	public SearchMoviePage clickHome(){
		
		searchPage.click();
		return new SearchMoviePage(driver);
	}
	
    public String getReleaseDate(){
     	 
        return getDriver().findElement(By.linkText("releaseDate")).getText();
        
       }
    
    public String getActorImage(){
     	 
        return getDriver().findElement(By.linkText("actorImage")).getText();
        
       }

}
