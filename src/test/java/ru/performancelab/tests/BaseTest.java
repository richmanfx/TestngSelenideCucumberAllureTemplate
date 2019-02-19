package ru.performancelab.tests;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseTest{

    protected static final Logger log = LogManager.getLogger();


    @Attachment("Сообщение: {message}")
    protected String allureMessage(String message) {
        return message;
    }

}
