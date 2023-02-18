package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCardPage {
	
	WebDriver driver;
	By cart = By.id("cartur"); 
	By addToCart = By.xpath("//a[contains(@onclick, 'addToCart')]");
	public By delete = By.xpath("//a[contains(@onclick, 'deleteItem')]");
	public By placeOrder = By.xpath("//button[contains(@class, 'btn-success')]");
	public By total = By.id("totalm");
	public AddToCardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickAddToCart(WebDriver driver) {
		driver.findElement(addToCart).click();
	}
	public void clickCart(WebDriver driver) {
		driver.findElement(cart).click();
	}
	public void clickDelete(WebDriver driver) {
		driver.findElement(delete).click();

	}
	public void clickPlaceOrder(WebDriver driver) {
		driver.findElement(placeOrder).click();
	}
}
