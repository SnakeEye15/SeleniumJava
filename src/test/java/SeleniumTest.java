import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        //running on Chrome browser/driver
        //WebDriver driver= new ChromeDriver();

        //Running on FireFoxDriver
        //WebDriver driver= new FirefoxDriver();

        //Running on EdgeDriver
        WebDriver driver= new EdgeDriver();
        driver.get("https://mvnrepository.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();

    }
}
