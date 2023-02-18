package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {
	
	WebDriver driver;
	public By signUp = By.id("signin2");
	public By login = By.id("login2");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clickLogin() {
		driver.findElement(login).click();
	}
	public void clickSignup() {
		driver.findElement(signUp).click();
	}


	
	

}
