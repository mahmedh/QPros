package use_cases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AddToCardPage;
import pages.HomePage;
import pages.PlaceOrderPage;

public class SuccessfulCheckout extends Setup {
	
	HomePage homepage;
	AddItem addItem;
	AddToCardPage addToCard;
	PlaceOrderPage placeOrderPage;
	
	@BeforeTest
	public void setup() throws InterruptedException {
		homepage = new HomePage(driver);
		addToCard = new AddToCardPage(driver);
		placeOrderPage = new PlaceOrderPage(driver);
		addItem = new AddItem();
		addItem.setup();
		addItem.addItemToCard();

	}
	
	@Test
	public void checkout() throws InterruptedException {
		addToCard.clickCart(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Explicit wait
		assertEquals(driver.findElement(addToCard.placeOrder).isDisplayed(), true, "The item is not added");
		addToCard.clickPlaceOrder(driver);
		Thread.sleep(2000);
		assertEquals(driver.findElement(addToCard.total).isDisplayed(),true);
		placeOrderPage.setName("Mohamed Hamed");
		placeOrderPage.setCity("Cairo");
		placeOrderPage.setCountry("Egypt");
		placeOrderPage.setCeditCard("1111 2222 3333 4444");
		placeOrderPage.setMonth("2");
		placeOrderPage.setYear("2023");
		placeOrderPage.clickPurchase();
		Thread.sleep(3000);
		assertEquals(driver.findElement(By.xpath("/html/body/div[10]/h2")).isDisplayed(), true);
		assertEquals(driver.findElement(By.xpath("/html/body/div[10]/h2")).getText(), "Thank you for your purchase!");
	}

}
