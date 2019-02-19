package ru.performancelab.tests.suites.Smoke;


import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;

import ru.performancelab.tests.BaseTest;


public class Smoke extends BaseTest {

    @Step("Шаг - Метод 'openHost'")
    @Пусть("открыт сайт")
    public void openHost() {
        open(System.getProperty("testUrl"));
        log.info("Сайт удачно открыт");

        // Сообщение текстовое в Аллюре отчёт
        allureMessage("Текстовое сообщение в отчёт");

        // Скриншот в Аллюре    TODO: Пока не реализовано
        String screenshotFileName = "selenide_screenshot";
        screenshot(screenshotFileName);
    }

    @Step("Шаг - Метод 'mustBeElementWithTheTagH'")
    @Тогда("должен быть элемент с тегом H{int}")
    public void mustBeElementWithTheTagH(int arg0) {
        $(By.xpath(String.format("//H%s", arg0))).shouldBe(Condition.visible);
        log.info(String.format("Елемент с тегом 'H%s' обнаружен", arg0));
    }

    @Step("Шаг - Метод 'textTagHElementMustBeSpecifiedString'")
    @И("текст элемента с тегом H{int} должен содержать {string}")
    public void textTagHElementMustBeSpecifiedString(int arg0, String arg1) {
        $(By.xpath(String.format("//H%s[contains(string(),'%s')]", arg0, arg1))).shouldBe(Condition.visible);
        log.info(String.format("Текст элемента с тегом 'H%s' содержит: %s", arg0, arg1));
    }
}
