package fakeTestData;

import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerAPI {
	
	@Test
	public void passingData() {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		FakerAPI api = new FakerAPI();
		String[] data = api.generateTestData();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(data[1]);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(data[2]);
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(data[3]);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(data[4]);
		String tel = data[5].replaceAll("-", "").replace(".", ""); //mobile number contains symbols. so better to use Java Random Class
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(tel);
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		
		Select country = new Select(driver.findElement(By.id("yearbox")));
		country.selectByVisibleText("1993");
		Select year = new Select(driver.findElement(By.xpath("//select[@id='countries']")));
		year.selectByVisibleText(data[6]);
		Select month = new Select(driver.findElement(By.xpath("//select[@ng-model='monthbox']")));
		month.selectByVisibleText("January");
		Select date = new Select(driver.findElement(By.id("daybox")));
		date.selectByVisibleText("15");
		driver.findElement(By.xpath("//input[@ng-model='Password']")).sendKeys(data[7]);
		driver.findElement(By.xpath("//input[@ng-model='CPassword']")).sendKeys(data[7]);
		driver.findElement(By.xpath("//button[@id='submitbtn']")).click();
		
	}
	public String[] generateTestData() {
		
		Locale local = new Locale("en-IND");
	Faker faker = new Faker(local);
	String [] data = new String[8];
	
	data[0]  = faker.name().fullName();
	data[1]   = faker.name().firstName();
	data[2]   = faker.name().lastName();
	data[3]   = faker.address().city();
	data[4]  = faker.internet().emailAddress();
	data[5]   = faker.phoneNumber().cellPhone();
	data[6]   = faker.address().country();
//	System.out.println(faker.date().birthday().getDay());
	data[7]	= faker.internet().password();

	
	/*String fullname  = faker.name().fullName();
	String firstname  = faker.name().firstName();
	String lastname  = faker.name().lastName();
	String address  = faker.address().city();
	String phonenumber  = faker.phoneNumber().cellPhone();
	String email = faker.internet().emailAddress();
	
	System.out.println("The name is: "+fullname);
	System.out.println("The firstname is: "+firstname);
	System.out.println("The lastname is: "+lastname);
	System.out.println("The address is: "+address);
	System.out.println("The phone number is: "+phonenumber);
	System.out.println("The email is: "+email);*/
	
	return data;
	
	}

}
