package KrishnaSakinala.krishnaSakinala;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class WebelementScreenshot {

	@Test
	public void fullpageScrshot() throws IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://demo.automationtesting.in/Register.html");
		
		WebElement logo = driver.findElement(By.xpath("//img[@id='imagetrgt']"));

		Screenshot screenshot = new AShot().takeScreenshot(driver,logo);

		ImageIO.write(screenshot.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/Screenshots/WebElementScreenshot.png"));
		
		driver.quit();
	}
}
