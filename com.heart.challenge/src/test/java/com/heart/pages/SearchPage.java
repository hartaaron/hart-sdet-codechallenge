package com.heart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.heart.challenge.com.heart.challenge.BaseUtil;

public class SearchPage extends BaseUtil {

	private static final Logger log = LoggerFactory.getLogger(SearchPage.class);

	WebDriverWait wait = new WebDriverWait(driver, 30);
	By searchButton = By.id("seachButton");
	By searchTextBox = By.id("SearchText");

	public void clickSearch() {

		try {

			wait.until(ExpectedConditions.elementToBeClickable(searchButton))
					.click();

		} catch (NoSuchElementException e) {
			log.error("Fail ", e);
			Assert.fail();
		}
	}

	public void searchMovies(String searchParam) {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(searchTextBox))
					.click();
			driver.findElement(searchTextBox).sendKeys(searchParam);
			clickSearch();

		} catch (NoSuchElementException e) {
			log.error("Fail ", e);
			Assert.fail();
		}
	}
}