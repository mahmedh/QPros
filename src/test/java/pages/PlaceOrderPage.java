package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaceOrderPage {
	WebDriver driver;
	By name = By.id("name");
	By country = By.id("country");
	By city = By.id("city");
	By creditCard = By.id("card");
	By month = By.id("month");
	By year = By.id("year");
	By purchase = By.xpath("//button[contains(@onclick, 'purchaseOrder')]");
	
	public PlaceOrderPage(WebDriver driver) {
		this.driver =driver;
	}
	
	public void setName(String name) {
		driver.findElement(this.name).clear();
		driver.findElement(this.name).sendKeys(name);	
	}
	public void setCountry(String country) {
		driver.findElement(this.country).clear();
		driver.findElement(this.country).sendKeys(country);	
	}
	public void setCity(String city) {
		driver.findElement(this.city).clear();
		driver.findElement(this.city).sendKeys(city);	
	}
	public void setCeditCard(String creditCard) {
		driver.findElement(this.creditCard).clear();
		driver.findElement(this.creditCard).sendKeys(creditCard);	
	}
	public void setMonth(String month) {
		driver.findElement(this.month).clear();
		driver.findElement(this.month).sendKeys(month);	
	}
	public void setYear(String year) {
		driver.findElement(this.year).clear();
		driver.findElement(this.year).sendKeys(year);	
	}
	public void clickPurchase() {
		driver.findElement(purchase).click();
	}
}
