import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footerDriver= driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        WebElement columnDriver=footerDriver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
        int columnLinkSize=columnDriver.findElements(By.tagName("a")).size();
        System.out.println(columnLinkSize);

        for(int i=1;i<columnLinkSize;i++){

            String keysToOpenLink= Keys.chord(Keys.COMMAND,Keys.ENTER);//for mac
            //String keysToOpenLink= Keys.chord(Keys.CONTROL,Keys.ENTER); //for windows
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(keysToOpenLink);
            Thread.sleep(2000);
        }
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it= windows.iterator();

        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }



    }
}
