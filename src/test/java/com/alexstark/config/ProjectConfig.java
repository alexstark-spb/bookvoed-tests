package com.alexstark.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/local.properties"})
public interface ProjectConfig extends Config {
    String login();
    String password();
    String browserURL();
    String email();
    String passwordForEmail();
}
