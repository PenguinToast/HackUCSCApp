package com.fillername.hackucscapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {
	
	@RequestMapping("/json")
	public @ResponseBody TestObject nameRequest(
			@RequestParam(value="name", required=false, defaultValue="defaultName") String name) {
		return new TestObject(name);
	}
}
