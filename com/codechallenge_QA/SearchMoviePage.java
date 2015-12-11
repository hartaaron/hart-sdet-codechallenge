package com.codechallenge_QA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.codechallenge_QA.AbstractPage;

public class SearchMoviePage extends AbstractPage {
	
	public SearchMoviePage(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@id='lst-ib']")
	public WebElement txtInputField;
	
	@FindBy(name="btnG")
	public WebElement btnSearch;
	
	public void enterTitleName(String searchText){
		//Input field to enter the title of the movie
		txtInputField.sendKeys(searchText);
		
	}
	
	public SearchResultMoviePage ClickSearch(){
		
		btnSearch.click();
		return new SearchResultMoviePage(driver);
	}

}
