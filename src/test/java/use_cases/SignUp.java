package use_cases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.SignUpPage;

public class SignUp extends Setup {
	public String username;
	public String password;
	HomePage homePage;
	SignUpPage signUpPage;

	@BeforeTest
	public void setup() {
		homePage = new HomePage(driver);
		signUpPage = new SignUpPage(driver);
		homePage.clickSignup();

	}

	public void chooseCredentials() {
		Random rnd = new Random();
		String allAlphabets = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGJHKLZXCVBNM1234567890";
		int stringSize = rnd.nextInt(15);
		StringBuilder randomString = new StringBuilder(stringSize);

		for (int i = 0; i < stringSize; i++) {

			int index = (int) (allAlphabets.length() * Math.random());

			randomString.append(allAlphabets.charAt(index));
		}

		username = randomString.toString();
		String allNumbers = "0123456789";
		password = allNumbers.substring(0, rnd.nextInt(allNumbers.length()));
	}

	@Test
	public void performSignUp() {
		Boolean usedCredentials = true;

		while (usedCredentials) {
			chooseCredentials();
			signUpPage.clearUsername();
			signUpPage.clearPassword();
			signUpPage.setUsername(username);
			signUpPage.setPassword(password);
			signUpPage.clickSignUp();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Explicit wait
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			if (driver.switchTo().alert().getText().equals("Sign up successful.")) {
			    assertEquals(driver.switchTo().alert().getText(), "Sign up successful.");
				usedCredentials = false;
			}
			alert.accept();

		}
//	    assertEquals(driver.switchTo().alert().getText(), "Sign up successful.");
	}

}
