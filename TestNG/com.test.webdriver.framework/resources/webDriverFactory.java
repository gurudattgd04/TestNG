package resources;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.google.common.base.Function;
import com.jcabi.aspects.RetryOnFailure;

public class webDriverFactory {
	
	
private static WebDriver driver ;


public static WebDriver getWebDriver()
{
	String browser = getBrowser().trim().toString();
	initDriver(browser);
	driver.manage().window().maximize();
		return driver; 
}

private static final String USER_DIR = System.getProperty("user.dir");
private static final String DRIVERS_PATH = USER_DIR + File.separator + "com.test.webdriver.framework" + 
                                           File.separator + "resources" + File.separator + "Drivers";
private static final String CHROME_PATH	= DRIVERS_PATH + File.separator + "chromedriver.exe";

//Initiate driver based on the browser selected in bean configuration file
private static  void initDriver(String browser)
{
	
	
	if(driver==null)
	{
		synchronized(webDriverFactory.class)
		{
		if(driver==null)
		{
			if(browser.toLowerCase().equals("ie"))
			{
				driver = new InternetExplorerDriver();
			}	
			else if(browser.toLowerCase().equals("FireFox"))
			{
				driver = new FirefoxDriver();
			}
			else if(browser.toLowerCase().equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", CHROME_PATH);
				driver = new ChromeDriver();
			}
			else
			{
				System.out.println("Not found!!");
			}
		}
		}
				
	}
}

private static final String getBrowser()
{
	ApplicationContext context;
	context = new FileSystemXmlApplicationContext("Config/Beans.xml");
		beanConfiguration tableCollection = (beanConfiguration) context.getBean("tables");
		System.out.println("Browser is: "+tableCollection.getBrowser());
		return tableCollection.getBrowser();
}

@RetryOnFailure(attempts= 2, delay=2, unit  =TimeUnit.SECONDS )
public static void waitForElement(By locator)
{
	
				 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				       .withTimeout(60, TimeUnit.SECONDS)
				       .pollingEvery(5, TimeUnit.SECONDS)
				       .ignoring(NoSuchElementException.class);
		   
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	
}

}
