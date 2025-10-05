import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        String name="Dheeraj Saini";
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
        String password=getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        //System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
        //driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
       driver.quit();
    }


    public static String getPassword(WebDriver driver) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String message=driver.findElement(By.cssSelector("form p")).getText();
        String [] pasArrays =message.split("'");
        return pasArrays[1].split("'")[0];
    }

}
