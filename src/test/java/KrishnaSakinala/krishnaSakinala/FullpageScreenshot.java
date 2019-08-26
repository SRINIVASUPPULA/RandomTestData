package KrishnaSakinala.krishnaSakinala;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FullpageScreenshot {
	
	@Test
	public void fullpageScrshot() throws IOException {

	System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver_win32\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	driver.get("http://www.automationtesting.in");
	
	Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	
    ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"/Screenshots/FullPageScreenshot.png"));
	
    driver.quit();
	}
}
