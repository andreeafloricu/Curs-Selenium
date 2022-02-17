package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest extends Driver{
	
	
	public String url = ReadPropertiesFile.config.getProperty("url");
	public WebDriver driver;
	public BasePage page;
	
	//public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser) {
		driver = initDriver(browser);
		driver.get(url);
		page = new BasePage();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	

}