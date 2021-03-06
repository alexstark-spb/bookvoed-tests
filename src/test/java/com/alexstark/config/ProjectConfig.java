package com.alexstark.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/remoteweb.properties"})
public interface ProjectConfig extends Config {
    String login();
    String password();
    String email();
    String passwordForEmail();
}
