package KrishnaSakinala.krishnaSakinala;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	@Test
	public void findJourney() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		WebElement from = driver.findElement(By.xpath("//input[@id='fromCity']"));
	from.sendKeys("mum");
	
		Thread.sleep(2000);
		from.sendKeys(Keys.DOWN);
		from.sendKeys(Keys.ENTER);
		WebElement to =driver.findElement(By.xpath("//input[@id='toCity']"));
		to.sendKeys("goa");
		
		Thread.sleep(2000);
		to.sendKeys(Keys.DOWN);
		to.sendKeys(Keys.ENTER);
	}
	
	
	
}
