package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
		WebDriver driver;
		private By username = By.id("loginusername");
		private By password = By.id("loginpassword");
		private By loginButton = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void setUsername(String username) {
			driver.findElement(this.username).sendKeys(username);
		}
		public void setPassword(String password) {
			driver.findElement(this.password).sendKeys(password);
		}
		public void clickLogin() {
			driver.findElement(loginButton).click();
		}
		public void clearUsername() {
			driver.findElement(this.username).clear();
		}
		public void clearPassword() {
			driver.findElement(this.password).clear();
		}

}

