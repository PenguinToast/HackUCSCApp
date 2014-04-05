package com.fillername.hackucscapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fillername.hackucscapp.TestObject;

@Controller
public class JsonController {
	
	@RequestMapping("/json")
	public @ResponseBody TestObject nameRequest(
			@RequestParam(value="name", required=false, defaultValue="defaultName") String name) {
		return new TestObject(name);
	}
}
