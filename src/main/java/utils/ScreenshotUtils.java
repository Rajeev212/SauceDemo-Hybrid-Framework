package utils;

import org.openqa.selenium.*;
import java.io.File;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            // Create folder if not exists
            File folder = new File("screenshots");
            if (!folder.exists()) {
                folder.mkdir();
            }

            String path = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            File dest = new File(path);

            FileHandler.copy(src, dest);

            return path;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}