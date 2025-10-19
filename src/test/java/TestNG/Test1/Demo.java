package TestNG.Test1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo {


    @AfterTest
    public void lastTest(){
        System.out.println("This will execute in the end of all tests");
    }
    @Parameters({"url"})
    @Test
    public void demo(String urlname){
        System.out.println("Hello");
        System.out.println(urlname);
    }
    @Test(groups = {"Smoke"})
    public void secondTest(){
        System.out.println("Bye");
    }

    @AfterSuite
    public void afSuit(){
        System.out.println("This will execute after the suit..");
    }

}
