package fakeTestData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.person.Person.Sex;

public class JFairyAPI {

	@Test
	public void passData() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		JFairyAPI api = new JFairyAPI();
		String[] data = api.generateJFairyData();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(data[0]);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(data[1]);
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(data[2]);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(data[3]);
		String tel = data[4].replaceAll("-", "").replace(".", "");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(tel);
		Thread.sleep(3000);
		String gender = "";
		if(data[5].equals("FEMALE")) {
			 gender = "FeMale";
		}
			else if(data[5].equals("MALE")) {
			 gender = "Male";
			}
		driver.findElement(By.xpath("//input[(@value='"+gender+"')]")).click();
		
		Select year = new Select(driver.findElement(By.xpath("//select[@id='countries']")));
		year.selectByVisibleText("India");
		Select country = new Select(driver.findElement(By.id("yearbox")));
		country.selectByVisibleText(data[7]);
		Select month = new Select(driver.findElement(By.xpath("//select[@ng-model='monthbox']")));
		month.selectByVisibleText("March");
		Select date = new Select(driver.findElement(By.id("daybox")));
		date.selectByVisibleText(data[8]);
		driver.findElement(By.xpath("//input[@ng-model='Password']")).sendKeys(data[9]);
		driver.findElement(By.xpath("//input[@ng-model='CPassword']")).sendKeys(data[9]);
		driver.findElement(By.xpath("//button[@id='submitbtn']")).click();
		
		driver.close();
	}
	
	
	public String[] generateJFairyData() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		
		String [] data= new String[10];
		
		//String fullname = person.getFullName();
		data[0] = person.getFirstName();
		data[1] = person.getLastName();
		data[2] = person.getAddress().getAddressLine1();
		data[3] = person.getEmail();
		data[4] = person.getTelephoneNumber();
		Sex gender = person.getSex();
		data[5] = String.valueOf(gender);
	//	data[6] = person.getAddress().getCity(); - country list not available
		data[9] = person.getPassword();
		int year = person.getDateOfBirth().getYear();
		data[7] = String.valueOf(year);
	//	System.out.println(person.getDateOfBirth().getMonthOfYear()); - gives integer value
		int date = person.getDateOfBirth().getDayOfMonth();
		data[8] = String.valueOf(date);
		//person.getAddress().
		
		/*String fullname = person.getFullName();
		String firstname = person.getFirstName();
		String lastname = person.getLastName();
		String city = person.getAddress().getCity();
		String email = person.getEmail();
		String phone = person.getTelephoneNumber();
				
				System.out.println(fullname);
				System.out.println(firstname);
				System.out.println(lastname);
				System.out.println(city);
				System.out.println(email);
				System.out.println(phone);
				System.out.println(person.getDateOfBirth());
				System.out.println(person.getSex());
				System.out.println(person.getDateOfBirth().getDayOfMonth());*/
		return data;
	}




}

