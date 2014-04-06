package com.fillername.hackucscapp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fillername.hackucscapp.core.scrape.LoginManager;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        LoginManager.getInstance().login();
    }
}
