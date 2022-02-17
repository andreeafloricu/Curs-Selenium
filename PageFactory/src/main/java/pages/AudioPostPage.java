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
	
	@FindBy(css = "span[aria-valuenow='0']") public WebElement timeSliderMin;
	@FindBy(css = "span[aria-valuenow='240.248156']") public WebElement timeSliderMax;
	
	@FindBy(css = "div[style='left: 0%;']") public WebElement volumeSliderMin;
	@FindBy(css = "div[style='left: 100%;']") public WebElement volumeSliderMax;
	
	@FindBy(css = "div[class*='mejs-play']") public WebElement playButton;


}
