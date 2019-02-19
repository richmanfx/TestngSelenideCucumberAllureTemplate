package ru.performancelab.utils;


import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.apache.logging.log4j.Logger;
import com.codeborne.selenide.Screenshots;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.TakesScreenshot;
import com.codeborne.selenide.WebDriverRunner;


/**
 * Сделай аннотацию для своего класса вида <code>@Listeners({ ScreenShotOnFailListener.class})</code>
 */
public class ScreenShotOnFailListener implements ITestListener {

    private static final Logger log = LogManager.getLogger();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String className = iTestResult.getMethod().getTestClass().getName();
        String methodName = iTestResult.getMethod().getMethodName();
        Screenshots.startContext(className, methodName);
    }

    @Override
    public void onTestFailure  (ITestResult iTestResult) {
        log.debug(String.format("===> Start method: %s", Thread.currentThread().getStackTrace()[1].getMethodName()));
        screenShotOnFailToAllure();
        Screenshots.finishContext();
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Screenshots.finishContext();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        screenShotOnFailToAllure();
        Screenshots.finishContext();

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Screenshots.finishContext();
    }


    /**
     * Сделать скриншот для Аллюре отчёта после падения теста
     */
    @Attachment(value="Скриншот после падения теста", type = "image/png")
    private byte[] screenShotOnFailToAllure() {
        log.debug(String.format("===> Start method: %s", Thread.currentThread().getStackTrace()[1].getMethodName()));
        return screenshot();
    }


    /**
     * Вернуть скриншот в виде byte-массива
     * @return Изображение в виде byte-массива
     */
    private byte[] screenshot() {

        byte[] screenshot_image = new byte[0];

        try {
            screenshot_image = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception ex) {
            log.error(String.format("Ошибка при создании скриншота после падения теста. Exception: '%s'", ex));
        }
        return screenshot_image;
    }

}
