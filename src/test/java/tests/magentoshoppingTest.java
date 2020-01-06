package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class magentoshoppingTest {

	WebDriver driver;

	@Test
	public void LaunchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// 1. Go to http://live.demoguru99.com
		driver.get("http://live.demoguru99.com/");

		// 2. Click on Mobile menu
		driver.findElement(By.xpath("//*[@id='nav']/ol/li[1]/a")).click();

		// 3. In the list of all mobile, click on "ADD TO CART" for SonyXperia
		// mobile
		driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button/span/span")).click();

		// 4. Change "QTY" value to 1000 and click "UPDATE" button
		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1000");
		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button/span/span")).click();

		// 5. Verify the error message
		// The maximum quantity allowed for purchase is 500.

		// 6. Click on "EMPTY CART" link in the footer of list of all mobile.
		driver.findElement(By.xpath("//*[@id='empty_cart_button']")).click();
		// Verify cart is empty - SHOPPING CART IS EMPTY
	}
}
