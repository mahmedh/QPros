package use_cases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AddToCardPage;

public class AddItem extends Setup{

	AddToCardPage addToCardPage;
	Login login;
	
	@BeforeTest
	public void setup() throws InterruptedException {
		addToCardPage = new AddToCardPage(driver);
		login = new Login();
		login.setup();
		login.login();
	}
	
	@Test
	public void addItemToCard() throws InterruptedException {
		Random rand = new Random();
		driver.get(driver.getCurrentUrl());
		List<WebElement> items= driver.findElements(By.xpath("//img[contains(@class,'card-img-top')]"));
		WebElement randomItem = items.get(rand.nextInt(items.size()));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);",randomItem);
		randomItem.click();
		Thread.sleep(3000);
		assertEquals(driver.findElement(By.tagName("Strong")).getText(), "Product description", "item not viewed");
		addToCardPage.clickAddToCart(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Explicit wait
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		assertEquals(driver.switchTo().alert().getText().substring(8, 13), "added");
		driver.switchTo().alert().accept();
	}
	

}
