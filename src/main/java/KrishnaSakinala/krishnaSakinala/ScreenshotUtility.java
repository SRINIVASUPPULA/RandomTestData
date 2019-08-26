package KrishnaSakinala.krishnaSakinala;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static void captureScreenshot(WebDriver driver, String screenshotname) {

		/* Disadvantage - Not Gives the whole page Screenshot */
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./Screenshots/" + screenshotname + ".png");
		try {
			FileUtils.copyFile(srcfile, destfile);
			System.out.println("Screenshot Captured");
		} catch (IOException e) {
			System.out.println("Exception occured while taking screenshot " + e.getMessage());
		}

	}

}
