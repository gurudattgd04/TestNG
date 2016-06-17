package resources;
import org.openqa.selenium.WebDriver;

public class webDriverFactory {
	
	
private static 	WebDriver driver = null;


private webDriverFactory()
{
	
}

public static WebDriver getWebDriver()
{
		return driver;
	
}




}
