package com.heart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.heart.challenge.com.heart.challenge.BaseUtil;

public class ResultsPage extends BaseUtil {

	private static final Logger log = LoggerFactory
			.getLogger(ResultsPage.class);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	By nextPageButton = By.linkText("nextPage");

	public void noMovieExist() {
		Assert.assertTrue(driver.getPageSource().contains("No Results"));
	}

	public void movieExist(String MovieName) {
		try {
			Assert.assertTrue(driver.getPageSource().contains(MovieName));
		} catch (NoSuchElementException e) {
			log.error("Movie Not Found.", e);
		}

		boolean morePagesExist = isElementPresent();

		try {

			while (morePagesExist == true) {

				driver.findElement(nextPageButton).click();
				Assert.assertTrue(driver.getPageSource().contains(MovieName));

				/*
				 * try {
				 * Assert.assertTrue(driver.getPageSource().contains("Next Page"
				 * )); } catch (NoSuchElementException e) { log.error("Fail ",
				 * e); Assert.fail(); }
				 * 
				 * try {
				 * wait.until(ExpectedConditions.elementToBeClickable(nextPageButton
				 * )) .click();
				 * 
				 * Assert.assertTrue(driver.getPageSource().contains(MovieName));
				 */
			}
		} catch (NoSuchElementException e) {
			log.error("Fail ", e);
			Assert.fail();
		}
	}

	public void clickMovie(String linkText) {
		try {

			wait.until(
					ExpectedConditions.elementToBeClickable(By
							.linkText(linkText))).click();

		} catch (NoSuchElementException e) {
			log.error("Fail ", e);
			Assert.fail();
		}
	}

	private boolean isElementPresent() {
		try {
			driver.findElement(nextPageButton);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
