package resources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class webDriverFactory {
	
	
private static WebDriver driver ;


public static WebDriver getWebDriver()
{
	
	if(driver==null)
	{
		synchronized(webDriverFactory.class)
		{
			if(driver==null)
			{
				String browserName = getBrowser();
				driver = initDriver(browserName);
			}
		}
	}
	
		return driver;
	
}

//Initiate driver based on the browser selected in bean configuration file
private static WebDriver initDriver(String browser)
{
	if(browser=="ie")
	{
		driver = new InternetExplorerDriver();
	}	
	if(browser=="FireFox")
	{
		driver = new FirefoxDriver();
	}
	if(browser.toLowerCase()=="chrome")
	{
		driver = new ChromeDriver();
	}
	else
	{
		driver = new FirefoxDriver();
	}
	return driver;
	
}

private static String getBrowser()
{
	ApplicationContext context;
	context = new FileSystemXmlApplicationContext("Config/Beans.xml");
		beanConfiguration tableCollection = (beanConfiguration) context.getBean("tables");
		System.out.println("Browser is: "+tableCollection.getBrowser());
		return (String)tableCollection.getBrowser();
}

}
