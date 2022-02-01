package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class AudioPostPage extends SeleniumWrappers {
	
	public AudioPostPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "span.mejs-time-handle") public WebElement timeSlider;
	@FindBy(css = "div.mejs-horizontal-volume-handle") public WebElement volumeSlider;
}
