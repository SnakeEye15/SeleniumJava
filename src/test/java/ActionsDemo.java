import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
       // driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);
        WebElement signIn=driver.findElement(By.cssSelector("div[id='nav-link-accountList'] a:nth-child(1)"));
        WebElement searchBar=driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        //Entering Captial letters
        a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("bluetooth speaker").doubleClick().build().perform();
        //Move to specific items
        a.moveToElement(signIn).contextClick().build().perform();

    }
}
