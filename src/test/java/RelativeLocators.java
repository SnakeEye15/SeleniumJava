import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameInputBox=driver.findElement(By.cssSelector("input[name='name']"));
        //for Above
        String name=driver.findElement(with(By.tagName("label")).above(nameInputBox)).getText();
        System.out.println(name);

        WebElement DOB= driver.findElement(By.cssSelector("[for='dateofBirth']"));
        //for below
        driver.findElement(with(By.tagName("input")).below(DOB)).click();

        WebElement LoveIceCream=driver.findElement(By.xpath("//label[normalize-space()='Check me out if you Love IceCreams!']"));
        //for left side
        driver.findElement(with(By.tagName("input")).toLeftOf(LoveIceCream)).click();

        WebElement RadioButton=driver.findElement(By.xpath("//label[normalize-space()='Student']"));
        //for Right side
        driver.findElement(with(By.tagName("input")).toRightOf(RadioButton)).click();



        //driver.quit();
    }
}
