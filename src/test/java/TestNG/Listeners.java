package TestNG;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("I have executed on success from the Listeners class.");

    }

    public void  onTestFailure(ITestResult result){
        System.out.println("I have executed on failure from the Listeners Class."+ result.getName());
    }
}
