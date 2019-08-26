package KrishnaSakinala.krishnaSakinala;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RobotClassFileUpload {
	
	@Test
	public void  fileUpload() throws AWTException, InterruptedException {

	System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver_win32\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	
	driver.get("http://demo.automationtesting.in/Register.html");
	
	driver.findElement(By.id("imagesrc")).click();
	
	Robot robot = new Robot();
	
	robot.setAutoDelay(2000);
	
	 StringSelection selection = new StringSelection("D:\\Testing\\pros.jpg");
     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

     robot.setAutoDelay(1000);

     robot.keyPress(KeyEvent.VK_CONTROL);
     robot.keyPress(KeyEvent.VK_V);

     robot.keyRelease(KeyEvent.VK_CONTROL);
     robot.keyRelease(KeyEvent.VK_V);

     robot.setAutoDelay(1000);

     robot.keyPress(KeyEvent.VK_ENTER);
     robot.keyRelease(KeyEvent.VK_ENTER);
     	
     driver.close();
	}	

}
