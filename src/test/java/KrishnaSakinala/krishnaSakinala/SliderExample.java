package KrishnaSakinala.krishnaSakinala;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderExample {
	//Use Page Ruler extension to calculate distance in chrome
	@Test
	public void adjustSlider() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 //maximize the window - coz slider pixels compressed in minimized window
		
		//identify the circle element - not slider bar
		WebElement loanslidecircle = driver.findElement(By.xpath("//div[@id='loanamountslider']/span"));
		WebElement interestlidecircle = driver.findElement(By.xpath("//div[@id='loaninterestslider']/span"));
		WebElement tenureslidecircle = driver.findElement(By.xpath("//div[@id='loantermslider']/span"));
		
		Actions action = new Actions(driver);
		//Moving from default location
		action.dragAndDropBy(loanslidecircle, 84, 0).build().perform();
		Thread.sleep(2000);
		
		action.dragAndDropBy(interestlidecircle, 88, 0).build().perform();
		Thread.sleep(2000);
		action.dragAndDropBy(tenureslidecircle, -112, 0).perform();
		Thread.sleep(2000);
		
		WebElement loanemi = driver.findElement(By.xpath("//div[@id='emiamount']/p/span"));
		String amount = loanemi.getText();
		
		Assert.assertEquals("92,439", amount);
	}
	
	
}
