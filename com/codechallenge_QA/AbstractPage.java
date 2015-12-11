package com.codechallenge_QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codechallenge_QA.SearchMoviePage;

public class AbstractPage {
	
	@FindBy(name="btnG")
	public WebElement btnSearch;
	
	protected WebDriver driver;

	public AbstractPage (WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver(){
		return driver;
	}
	
	public SearchMoviePage navigateToWebApp(){
		getDriver().navigate().to("http://www.movie.com");
		WebElement btnSearch = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.name("btnSearch")));
		return new SearchMoviePage(driver);
	}
}
