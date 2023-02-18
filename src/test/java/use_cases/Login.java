package use_cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SignUpPage;
import pages.LoginPage;

public class Login extends Setup {
	HomePage homepage;
	LoginPage loginPage;
	SignUp signUp;
	@BeforeTest
	public void setup() {
		homepage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		signUp = new SignUp();
		signUp.setup();
		signUp.performSignUp();
	}
	@Test
	public void login() throws InterruptedException {
		homepage.clickLogin();
		loginPage.clearUsername();
		loginPage.clearPassword();
		loginPage.setUsername(signUp.username);
		loginPage.setPassword(signUp.password);
		loginPage.clickLogin();
		List<WebElement> items= driver.findElements(By.xpath("//img[contains(@class,'card-img-top')]"));
		int noOfItems = items.size();
		assertTrue(noOfItems !=0, "there are no items");
		Thread.sleep(3000);
		assertEquals(driver.findElement(By.id("nameofuser")).getText(), "Welcome " +signUp.username);

	}
}
