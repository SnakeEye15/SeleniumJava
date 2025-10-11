import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalenderTest {
    public static void main(String[] args) {
        String monthNumber="6";
        String date="15";
        String year="2027";
        String[] expectedList={monthNumber,date,year};

        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='"+year+"']")).click();
        driver.findElements(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']")).get(Integer.parseInt(monthNumber)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+Integer.parseInt(date)+"']")).click();

       List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

       for(int i = 0; i< actualList.size(); i++){
           System.out.println(actualList.get(i).getAttribute("value"));
           Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }


        driver.quit();




    }
}
