package TestNG.Test1;

import org.testng.annotations.*;

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
    @Test(dataProvider ="getData" )
    public void MobileSignOutCar(String username, String password){
        //will add code
        System.out.println("Car Mobile Sign out");
        System.out.println(username);
        System.out.println(password);
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


    @DataProvider
    public Object[][] getData(){
        //we will try to give 3 different username and password and try to run the login method for all using this data provider
        //First declare the Object array to store data
        Object[][] data= new Object[3][2];
        //1st user - with good credit score
        data[0][0]="FirstUserName";
        data[0][1]="FirstPassword";
        //2nd user - no records for credit score new user
        data[1][0]="SecondUserName";
        data[1][1]="SecondPassword";
        //3rd user - user with bad history
        data[2][0]="ThirdUserName";
        data[2][1]="ThirdPassword";
        return data;
    }

}
