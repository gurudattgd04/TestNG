package com.test.testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import resources.webDriverFactory;

public class annotationsTesting {
	
	private static WebDriver driver = webDriverFactory.getWebDriver();
	
	private static final String USERNAME_CSS_LOCATOR = "#username";
	private static final String PASSWORD_CSS_LOCATOR = "#password";
	private static final String SIGNINBTN_CSS_LOCATOR = ".btn-submit";
	
	@BeforeTest(groups="p1", alwaysRun= true)
	public void accessURL()
	{
		driver.navigate().to("https://www.pearsonrealize.com/community/");
	}

	@Parameters({"realizeadminusername", "realizeadminpassword"})
	@Test(groups="p1")
	public void loginTest(String username, String password)
	{
		webDriverFactory.waitForElement(By.cssSelector(USERNAME_CSS_LOCATOR));
		driver.findElement(By.cssSelector(USERNAME_CSS_LOCATOR)).sendKeys(username);
		webDriverFactory.waitForElement(By.cssSelector(PASSWORD_CSS_LOCATOR));
		driver.findElement(By.cssSelector(PASSWORD_CSS_LOCATOR)).sendKeys(password);
		webDriverFactory.waitForElement(By.cssSelector(SIGNINBTN_CSS_LOCATOR));
		driver.findElement(By.cssSelector(SIGNINBTN_CSS_LOCATOR)).click();
	}
	
	
	
	
	@AfterClass
	public void terminateDriver()
	{
		driver.close();
		driver.quit();
		
	}
	
}
