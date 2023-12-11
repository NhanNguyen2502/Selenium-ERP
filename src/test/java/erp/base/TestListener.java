package erp.base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener implements ITestListener {


    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        System.out.println("End: " + arg0.getName());

    }

    @Override
    public void onStart(ITestContext arg0) {
        System.out.println("Start: " + arg0.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("a "+ arg0.getName());

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        System.out.println("test case failed: "+ arg0.getName());

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("Start with Test name: "+ arg0.getName());


    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("End test name: "+ arg0.getName());


    }
}

