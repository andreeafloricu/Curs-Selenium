package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddress {
	
	WebDriver driver;
	WebElement dropdown;
	Select selectDropdown;

	public ShippingAddress(WebDriver driver) {
		this.driver = driver;
	}

	public By regionDropdown = By.name("shipping_country");

	public void filterRegionByIndex(int index) {
		dropdown = driver.findElement(regionDropdown);
		selectDropdown = new Select(dropdown);
		selectDropdown.selectByIndex(index);
	}
	
	public void filterRegionByValue(String value) {
		dropdown = driver.findElement(regionDropdown);
		selectDropdown =  new Select(dropdown);
		selectDropdown.selectByValue(value);
	}
	
	public String getTheCurrentSelectedRegion() {
		dropdown = driver.findElement(regionDropdown);
		selectDropdown = new Select(dropdown);	
		String elementText = selectDropdown.getFirstSelectedOption().getText();
		return elementText;
		
	}
	
	public int getIndexForCountryName(String name) {
		String[] regions = driver.findElement(regionDropdown).getText().split("\n");
		int indexCountry = 0;
		
		for (int i = 0 ; i < regions.length; i++) {
			if(regions[i].equals(name)) {
				return i;
			}
		}
		
		return indexCountry;
	}
}
