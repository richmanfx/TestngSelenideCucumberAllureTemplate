package ru.performancelab.tests;


import io.qameta.allure.Step;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import com.codeborne.selenide.WebDriverRunner;

import ru.performancelab.utils.ScreenShotOnFailListener;


@Listeners({ScreenShotOnFailListener.class})
public class BaseTest{

    protected static final Logger log = LogManager.getLogger();

    @BeforeMethod
    public void setUp() {

    }


    /**
     * Вывод сообщения в Аллюре-отчёт
     * @param message Сообщение в Аллюре-отчёт
     */
    @Attachment("Сообщение: {message}")
    protected String allureMessage(String message) {
        return message;
    }


    /**
     * Вывод сообщения в Аллюре-отчёт через аннотацию @Step
     * @param message Сообщение в Аллюре-отчёт
     */
    @Step("{message}")
    protected void allureLog(String message) {
        // Сообщение "msg" выводится в Аллюре-отчёт через аннотацию @Step
    }


    /**
     * Вывод скриншота в Аллюре отчёт
     * @param screenshot Изображение в виде byte-массива
     * @return Изображение в виде byte-массива
     */
    @Attachment(value="Скриншот: {screenshotDescription}", type = "image/png")
    protected byte[] allureScreenshot(byte[] screenshot, String screenshotDescription) {
        return screenshot;
    }


    /**
     * Вывод скриншота в Аллюре отчёт
     * @return Изображение в виде byte-массива
     */
    @Attachment(value="Скриншот: {screenshotDescription}", type = "image/png")
    protected byte[] allureScreenshot(String screenshotDescription) {
        return screenshot();
    }


    /**
     * Вернуть скриншот в виде byte-массива
     * @return Изображение в виде byte-массива
     */
    private byte[] screenshot() {
        byte[] image = new byte[0];
        try {
            image = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            log.error(String.format("Ошибка при создании скриншота. Exception: %s", e));
        }
        return image;
    }

}
