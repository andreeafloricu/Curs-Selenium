package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Driver {
	
	public static WebDriver driver; //trebuie sa fie static ca sa aiba aceeasi valoarea indiferent de cate obiecte sunt create
	public String url = ReadPropertiesFile.config.getProperty("url");
	public BasePage page;
	
	@BeforeClass
	public void setUp() {
		driver = initDriver();
		driver.get(url);
		page = new BasePage();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
