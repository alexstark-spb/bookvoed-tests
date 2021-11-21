package com.alexstark.helpers;

import com.alexstark.config.ProjectConfig;
import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {

    public static ProjectConfig credentials = ConfigFactory.create(ProjectConfig.class);

    public static void configure() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        String login = credentials.login();
        String password = credentials.password();
        String browserURL = System.getProperty("url", credentials.browserURL());
        String browserName = System.getProperty("browserName", "chrome");
        String browserSize = System.getProperty("browserSize", "1600x900");
        String browserVersion = System.getProperty("browserVersion");

        Configuration.browser = browserName;
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = browserVersion;
        Configuration.browserCapabilities = capabilities;
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://www.bookvoed.ru";
//        Configuration.remote = format("https://%s:%s@%s", login, password, browserURL);

    }
}
