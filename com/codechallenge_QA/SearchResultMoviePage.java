package com.codechallenge_QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultMoviePage extends AbstractPage {
	
	public SearchResultMoviePage(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy(linkText = "TitleName")
	public WebElement linkTitle;
	
	@FindBy(xpath="//img[contains(@id,'Test Image')]")
	public WebElement movieImage;
	
	@FindBy(linkText = "InTheater")
	public WebElement inTheater;
	
	@FindBy(linkText = "Movie Not Found")
	public WebElement notFound;
	
	public DetailMoviePage ClickTitle(){
		
		linkTitle.click();
		return new DetailMoviePage(driver);
	}

    public String getMovieImage(){
 
    	return getDriver().findElement(By.xpath("movieImage")).getText();
 
    }
    
    public String getTitle(){
    	 
        return getDriver().findElement(By.linkText("linkTitle")).getText();
    
       }
    
    public String getInTheaterText(){
   	 
        return getDriver().findElement(By.linkText("inTheater")).getText();
        
       }
    public String getMovieNotFound(){
     	 
        return getDriver().findElement(By.linkText("notFound")).getText();
        
       }

}
