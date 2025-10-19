package TestNG.Test1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo4 {
    @Test
    public void WebLoginHome(){
        //will add code
        System.out.println("HomeWeb Login");
    }
    @Test
    public void MobileLoginHome(){
        //will add code
        System.out.println("Home Mobile Login");
       Assert.assertTrue(false);
    }
    @Test(groups = {"Smoke"})
    public void LoginAPIHome(){
        //login api code Rest API
        System.out.println("Home Login REST API");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("This will execute before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("This will execute after the complete class");
    }

}
