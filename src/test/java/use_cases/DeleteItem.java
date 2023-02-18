package use_cases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AddToCardPage;
import pages.HomePage;

public class DeleteItem extends Setup {
	HomePage homepage;
	AddItem addItem;
	AddToCardPage addToCard;

	@BeforeTest
	public void setup() throws InterruptedException {
		homepage = new HomePage(driver);
		addToCard = new AddToCardPage(driver);
		addItem = new AddItem();
		addItem.setup();
		addItem.addItemToCard();

	}

	@Test
	public void deleteItem() throws InterruptedException {
		addToCard.clickCart(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Explicit wait
		assertEquals(driver.findElement(addToCard.delete).isDisplayed(), true, "The item is not added");
		Thread.sleep(4000);
		addToCard.clickDelete(driver);
		Thread.sleep(3000);
		assertEquals(driver.findElements(addToCard.delete).size(), 0, "The item is not deleted");
	}

}
