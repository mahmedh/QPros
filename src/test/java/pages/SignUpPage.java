package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
	WebDriver driver;
	public By username = By.id("sign-username");
	public By password = By.id("sign-password");
	public By signUpButton = By.xpath("/html/body/div[2]/div/div/div[3]/button[2]");

	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUsername(String username) {
		driver.findElement(this.username).sendKeys(username);
	}
	public void setPassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}
	public void clickSignUp() {
		driver.findElement(signUpButton).click();
	}
	public void clearUsername() {
		driver.findElement(this.username).clear();
	}
	public void clearPassword() {
		driver.findElement(this.password).clear();
	}
}
