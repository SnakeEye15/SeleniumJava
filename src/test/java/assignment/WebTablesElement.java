package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablesElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(2000);
        int row_count=driver.findElements(By.xpath("//table[@class='table-display']//tr")).size();
        int column_count=driver.findElements(By.xpath("//table[@class='table-display']//tr[1]//th")).size();

        List<WebElement> secondRow=driver.findElements(By.xpath("//table[@class='table-display']//tr[3]//td"));

        System.out.println("Number of Rows in table: "+row_count);
        System.out.println("Number of Columns in table: "+column_count);
        for(int i=0;i<secondRow.size();i++){
            System.out.println(secondRow.get(i).getText());
        }
        driver.quit();
    }
}
