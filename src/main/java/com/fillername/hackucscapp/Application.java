package com.fillername.hackucscapp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fillername.hackucscapp.core.scrape.LoginManager;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
    	// Run the server
        SpringApplication.run(Application.class, args);
        // TODO: Delete this line, it is only for testing login
        LoginManager.getInstance().login();
    }
}
