package com.example.spring;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Main {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
	
		return "home";
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<String> list() {
	
		return Arrays.asList("arun", "mani", "shabbir", "talari");
		
	}
	
}
