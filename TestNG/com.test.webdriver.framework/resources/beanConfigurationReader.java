package resources;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class beanConfigurationReader {
	
	public static void main(String args[])
	{

		ApplicationContext context;
		context = new FileSystemXmlApplicationContext("Config/Beans.xml");
			beanConfiguration tableCollection = (beanConfiguration) context.getBean("tables");
			System.out.println("Browser is: "+tableCollection.getBrowser());
		
	}

}
