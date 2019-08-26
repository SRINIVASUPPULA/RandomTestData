package KrishnaSakinala.krishnaSakinala;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FacebookScreenshot {

	@Test
	public void takePageScreenshot() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://www.automationtesting.in");

		String screenshotname = "AutomationTesting";

		ScreenshotUtility.captureScreenshot(driver, screenshotname);

		driver.quit();
	}

}
