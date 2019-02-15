package ru.performancelab.tests.suites.Smoke;


import cucumber.api.java.ru.Пусть;
import static com.codeborne.selenide.Selenide.open;


public class Smoke {

    @Пусть("открыт сайт r5am.ru")
    public void openHostR5amRu() {

        open("https://r5am.ru");

    }

}
