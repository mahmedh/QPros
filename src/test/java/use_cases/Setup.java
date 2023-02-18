package use_cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {
	
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    
       
		
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
	
	

}
