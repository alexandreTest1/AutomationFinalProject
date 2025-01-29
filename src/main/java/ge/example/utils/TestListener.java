package ge.example.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {


    @Override

    public void onTestStart(ITestResult result){
        String testName = result.getMethod().getMethodName(); // რეპორტინგისთვის
        ExtentReportManager.createTest(testName); // რეპორტისთვის

        System.out.println("Test Started: " + result.getName());

    }

    @Override
    //როდესაც ტესტი წარმატებით გაეშვა
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Test Passed");
        System.out.println("Test Success: " + result.getName());
    }

    // როდესაც ტესტი წარმატებით არ გაეშვა
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failure: " + result.getName());
        ExtentReportManager.getTest().fail("Test Failed: " + result.getThrowable());
    }

    // როდესაც რაღაც მიზეზით ტესტი გამოტოვა
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }


    @Override
    //ტესტის დაწყებისთვის
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    // ტესტის დასრულებისას
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
        ExtentReportManager.flushReports(); // დავასრულოთ რეპორტინგი
    }


}
