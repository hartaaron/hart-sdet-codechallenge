package com.heart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.heart.challenge.com.heart.challenge.BaseUtil;

public class MovieDetailPage extends BaseUtil {

	private static final Logger log = LoggerFactory
			.getLogger(MovieDetailPage.class);

	WebDriverWait wait = new WebDriverWait(driver, 30);
	By movieTitle = By.id("movieTitle");
	By backButton = By.id("backButton");

	public void AssertMovieTitle(String movieTitleName) {
		try {

			wait.until(ExpectedConditions.textToBePresentInElementLocated(
					movieTitle, movieTitleName));

			Assert.assertTrue(driver.getPageSource().contains(movieTitleName));

		} catch (NoSuchElementException e) {
			log.error("Fail ", e);
			Assert.fail();
		}
	}

	public void clickBackButton() {

		try {

			wait.until(ExpectedConditions.elementToBeClickable(backButton))
					.click();

		} catch (NoSuchElementException e) {
			log.error("Fail ", e);
			Assert.fail();
		}
	}
}
