
package TestConfig;

import org.testng.*;

import java.util.logging.Logger;

public class TestListener implements ITestListener, ISuiteListener {
    private static final Logger LOGGER = Logger.getLogger(TestListener.class.getName());

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Reporter.log("TEST " + iTestResult.getName() + " STARTED", true);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Reporter.log("TEST " + iTestResult.getName() + " PASSED", true);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Reporter.log("TEST " + iTestResult.getName() + " FAILED", true);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Reporter.log("TEST " + iTestResult.getName() + " FAILED WITHIN SUCCESS PERCENTAGE", true);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Reporter.log("TEST " + iTestResult.getName() + " SKIPPED", true);
    }

    @Override
    public void onStart(ISuite iSuite) {
        Reporter.log("TEST SUITE " + iSuite.getName() + " STARTED", true);
    }

    @Override
    public void onFinish(ISuite iSuite) {
        Reporter.log("TEST SUITE " + iSuite.getName() + " FINISHED", true);
    }
}