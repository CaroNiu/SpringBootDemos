package com.learn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspContriller {
	@RequestMapping("/jsptest")
	public String jspTest(Model model) {
		model.addAttribute("name", "niuheng2");
		return "hello";
	}
}
