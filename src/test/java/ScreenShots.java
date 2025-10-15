import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenShots {
    public static void main(String[] args) throws IOException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().deleteCookieNamed("sessionKey01");

        driver.get("https://google.com");

        //Now ScreenShot part
        // /Users/dheerajv/Downloads/share.png

        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("/Users/dheerajv/SeleniumJava/src/test/java/Screenshots/screenshot.png"));
    }
}
