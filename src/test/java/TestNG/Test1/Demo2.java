package TestNG.Test1;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo2 {
    @Test(groups = {"Smoke"})
    public void demo2(){
        System.out.println("Try");
    }
    @BeforeTest
    public void preRequisite(){
        System.out.println("This will execute first of all the test");
    }


    @BeforeSuite
    public void bfSuit(){
        System.out.println("This will execute before suit.");
    }

    @Parameters({"URL"})
    @Test
    public void justToTestParameters(String URLName){
        System.out.println("Test for printing url only..");
        System.out.println(URLName);
    }
}
