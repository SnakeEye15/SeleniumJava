package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class RealTimeExercies {
    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //CheckBox
        driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
        String SelectedBox = "";
        List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox'] "));

        for(WebElement box : checkboxes){
            if(box.isSelected()){
                WebElement select=box.findElement(By.xpath("./parent::label"));
                SelectedBox=select.getText();
            }
        }
        System.out.println(SelectedBox);

        //Now dropDown part
        WebElement dropDown= driver.findElement(By.cssSelector("#dropdown-class-example"));
        Select dropdown=new Select(dropDown);
        dropdown.selectByVisibleText(SelectedBox);

        //Now Alert
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(SelectedBox);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        String alertMessage=driver.switchTo().alert().getText();
        Assert.assertTrue(alertMessage.contains(SelectedBox));
        driver.switchTo().alert().accept();



    }
}
