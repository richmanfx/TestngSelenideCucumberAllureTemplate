package ru.performancelab.tests.suites.Smoke;


import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;

import ru.performancelab.tests.BaseTest;


public class Smoke extends BaseTest {

    @Пусть("открыт сайт")
    public void openHos() {
        open(System.getProperty("testUrl"));
        log.info("Сайт удачно открыт");

        // Скриншот в Аллюре
        String screenshotFileName = "selenide_screenshot";
        screenshot(screenshotFileName);
    }

    @Тогда("должен быть элемент с тегом H{int}")
    public void mustBeElementWithTheTagH(int arg0) {
        $(By.xpath(String.format("//H%s", arg0))).shouldBe(Condition.visible);
        log.info(String.format("Елемент с тегом 'H%s' обнаружен", arg0));
    }

    @И("текст элемента с тегом H{int} должен содержать {string}")
    public void textTagHElementMustBeSpecifiedString(int arg0, String arg1) {
        $(By.xpath(String.format("//H%s[contains(string(),'%s')]", arg0, arg1))).shouldBe(Condition.visible);
        log.info(String.format("Текст элемента с тегом 'H%s' содержит: %s", arg0, arg1));
    }
}
