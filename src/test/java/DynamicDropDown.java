import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //xpath for bangaluru : //a[@value='BLR']
        //xpath for chenni: (//a[@value='MAA'])[2]
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
       // driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        //to replace hard coding of index we can use below xpaths for this line
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
    }
}
