package TestNG.Test1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo3 {
    @Parameters({"URL"})
    @Test
    public void WebLoginCar(String URLName){
        //will add code
        System.out.println("Car Web Login");
        System.out.println(URLName);
    }
    @Test(enabled = false)
    public void MobileLoginCar(){
        //will add code
        System.out.println("Car Mobile Login");
    }

    @Test(groups = {"Smoke"})
    public void MobileSigninCar(){
        //will add code
        System.out.println("Car Mobile Sign in");
    }
    @Test(timeOut = 4000)
    public void MobileSignOutCar(){
        //will add code
        System.out.println("Car Mobile Sign out");
    }
    @Test(dependsOnMethods = {"WebLoginCar","MobileSignOutCar"})
    public void APICar(){
        //login api code Rest API
        System.out.println("Car Login REST API");
    }


    @BeforeMethod
    public void beforeEveryMethod(){
        System.out.println("This will execute before every method in demo 3 class ");
    }

    @AfterMethod
    public void afterEverymethod(){
        System.out.println("This will execute after the every method in demo 3 class");
    }

}
