package com.alexstark.tests;

import com.alexstark.helpers.DriverSettings;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.alexstark.helpers.AllureAttachments.*;
import static io.qameta.allure.Allure.step;

@ExtendWith({AllureJunit5.class})
public class TestBase extends DriverSettings {

    @BeforeAll
    static void setupBeforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
        attachAsText("BrowserRun",System.getProperty("browserName","chrome"));
    }

    @BeforeEach
    public void setupBeforeEach() throws InterruptedException {
        if (System.getProperty("threads") != null) {
            Thread.sleep(10_000);
        }
    }

    @AfterEach
    public void setupAfterEach() {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        addVideo();
        step("Закрытие браузера", Selenide::closeWebDriver);
    }
}
