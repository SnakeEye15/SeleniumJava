import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AmazonInterviewQuestion {
    public static void main(String[] args) {
        String [] Items={"Cucumber","Brocolli","Carrot"};
        WebDriver driver= new ChromeDriver();
        int j=0;
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));

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

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.cssSelector("div[class='cart-preview active'] div[class='action-block']")).click();
    }
}
