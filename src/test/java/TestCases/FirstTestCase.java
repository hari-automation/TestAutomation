package TestCases;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestCase {
		WebDriver driver;
	@BeforeTest()
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://suppliers-master-minus-1-qe1.coupadev.com");
	}
	
	@Test
	public void validatetitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Coupa Home");
	}
	
	@Test
	public void validateImage() {
		boolean  imageDisplayed = driver.findElement(By.className("logo")).isDisplayed();
		Assert.assertEquals(imageDisplayed, true);
		
	}
	
	@AfterTest()
	public void tearDown(){
		driver.quit();
	}
}
