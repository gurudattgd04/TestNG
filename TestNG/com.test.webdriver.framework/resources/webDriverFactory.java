package resources;
import org.openqa.selenium.WebDriver;

public class webDriverFactory {
	
	
private static 	WebDriver driver = null;


private webDriverFactory()
{
	
}

public static WebDriver getWebDriver()
{
	
	if(driver==null)
	{
		synchronized(webDriverFactory.class)
		{
			if(driver==null)
			{
				driver = initDriver();
			}
		}
	}
	
		return driver;
	
}

private static WebDriver initDriver(String browser)
{
	switch(browser)
	{
	
	}
	
	
	return driver;
	
}


}
