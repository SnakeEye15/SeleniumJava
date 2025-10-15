import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        SoftAssert a= new SoftAssert();
        WebDriver driver= new ChromeDriver();
        //we will try to findout the broken URL on any webpage
        //Step1- we will get the url of the hyperlink on page.
        //use java methods to call url and validated status code.
        //if status code>400 than it's a broken url
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> Links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        for(WebElement link: Links){
            String url=link.getAttribute("href");
            HttpURLConnection connection  = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode=connection.getResponseCode();
            System.out.println(responseCode);
            a.assertTrue(responseCode<400,"The Link with Text "+link.getText()+" is broken with status code: "+responseCode);

        }
        a.assertAll();
        driver.quit();

    }
}
