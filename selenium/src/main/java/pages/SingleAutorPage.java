package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SingleAutorPage {

	WebDriver driver;

	public SingleAutorPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public static final By skillsDiagram = By.cssSelector("div[id*='sc_skills_diagram']");
	
	public String getSkillValue(String skill) {
		
		WebElement skills = driver.findElement(skillsDiagram);
		
		String[] list = skills.getText().split("\n");
		
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(skill)) {
				return list[i + 1];
			}
		}
		return null;
	}
}
