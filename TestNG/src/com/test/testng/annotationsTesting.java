package com.test.testng;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.webDriverFactory;

public class annotationsTesting {
	
	private static WebDriver driver = webDriverFactory.getWebDriver();
	public static void main(String args[])
	{
		driver.navigate().to("http://www.google.com");
		
	}
}
