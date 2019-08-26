package fakeTestData;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JavaRandomClass {

	public static void main(String [] args) {
		Random r = new Random();
		String firstname  = "firstname"+r.nextInt();
		String lastname  = "lastname"+r.nextInt();
		String address  = "India"+r.nextInt();
		String email  = "email"+r.nextInt()+"@mail.com";	
		long mob = (long) (Math.random()*100000 + 3333000000L);
		String phone = Long.toString(mob);
		String password  = "P@ss"+r.nextInt();	
		
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(phone);
		driver.findElement(By.xpath("//input[(@value='Male')]")).click();
		
		Select year = new Select(driver.findElement(By.xpath("//select[@id='countries']")));
		year.selectByVisibleText("India");
		Select country = new Select(driver.findElement(By.id("yearbox")));
		country.selectByIndex(5);
		Select month = new Select(driver.findElement(By.xpath("//select[@ng-model='monthbox']")));
		month.selectByVisibleText("March");
		Select date = new Select(driver.findElement(By.id("daybox")));
		date.selectByIndex(5);
		driver.findElement(By.xpath("//input[@ng-model='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@ng-model='CPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='submitbtn']")).click();
		
		driver.close();
		
		/*String fullname  = "fullname"+r.nextInt();
		long phone = (long) (Math.random()*100000 + 3333000000L);
		System.out.println(fullname);
		System.out.println(phone);*/
	}
	
	
	
}
