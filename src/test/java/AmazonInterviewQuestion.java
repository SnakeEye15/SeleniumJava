import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonInterviewQuestion {
    public static void main(String[] args) {
        String [] Items={"Cucumber","Brocolli","Carrot"};
        WebDriver driver= new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        addItems(driver,Items);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(normalize-space(),'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static void addItems(WebDriver driver, String[] Items){
        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
        int j=0;
        for(int i=0;i<products.size();i++){
            //String name=products.get(i).getText();
            //Format name to get actual veggies name
            String[] RowName =products.get(i).getText().split("-");
            String name=RowName[0].trim();
            //Convert Array into arrayList for easy searching
            List itemLists= Arrays.asList(Items);
            if(itemLists.contains(name)){
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
                if(j==Items.length)
                    break;
            }
        }
    }
}
