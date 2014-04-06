package com.fillername.hackucscapp.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fillername.hackucscapp.core.DetailsData;
import com.fillername.hackucscapp.core.RecommendationsData;

@Controller
public class JsonController {
	
	@RequestMapping("/api/recommendations")
	public @ResponseBody RecommendationsData recommendationsRequest () {
		RecommendationsData out = new RecommendationsData();
		
		return out;
	}
}

