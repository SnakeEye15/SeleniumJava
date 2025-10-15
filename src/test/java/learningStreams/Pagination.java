package learningStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Pagination {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //Now store all the elements present in table into list of element.
        List<WebElement> webElementList=driver.findElements(By.xpath("//tr/td[1]"));
        //Now get text of each element and store into new list.
        List<String> OringinalList=webElementList.stream().map(s-> s.getText()).collect(Collectors.toList());
        //Apply sorting on this new orignal list.
        List<String> sortingList=OringinalList.stream().sorted().collect(Collectors.toList());

        //Compare both sorting and original list and they have to be same to pass this test.

        Assert.assertTrue(OringinalList.equals(sortingList));

        List<String> price;
        //Scan the name column with get text -> if get Rice -> print price for that.
        //And also have to check what if it not present in first page
        do{
            List<WebElement> rows =driver.findElements(By.xpath("//tr/td[1]"));
            price= rows.stream().filter(s-> s.getText().contains("Rice")).
                map(s->getVeggiesPrice(s)).collect(Collectors.toList());

        price.forEach(a-> System.out.println(a));

        if(price.size()<1){
            driver.findElement(By.cssSelector("[aria-label='Next']")).click();
        }}while(price.size()<1);



        driver.quit();
    }

    private static String getVeggiesPrice(WebElement s) {
        String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();

        return price;
    }
}
