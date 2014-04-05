package com.fillername.hackucscapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/")
    public @ResponseBody String greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        return String.format(template, name);
    }
}
