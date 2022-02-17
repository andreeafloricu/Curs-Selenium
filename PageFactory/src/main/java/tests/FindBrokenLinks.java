package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindBrokenLinks extends BaseTest {

	
	
	@Test
	public void findBrokenLinks() throws IOException {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total linkuri : " + links.size());
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementsByClassName('sc_team_item_title')[0].childNodes[0].setAttribute('href', 'https://keybooks.ro/team/testCeva/')");
		
		
		for(int i=0; i <links.size(); i++) {
			
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			if(url==null) {
				continue;
			}
			System.out.println(url);
			checkLinks(url);	
		}	
	}
	
	
	public static void checkLinks(String urlLink) throws IOException {
		
		
		try {
			URL url =  new URL(urlLink);
			HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();
			httpUrlConnection.setConnectTimeout(3000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode() == 200) {
				
				System.out.println(urlLink + "  -  " + httpUrlConnection.getResponseMessage());
			}
			if(httpUrlConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				
				System.out.println(urlLink + "  -  " + httpUrlConnection.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND );

			}
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}