package com.everis.bcn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 
 * @author jsalirio
 *
 */
@Controller
public class HelloWordController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloWordController.class);
	
	
	/**
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("hello")
	public String home(@RequestParam(value="name", required = false)String name, Model model) {
		logger.info("Welcome ! The client locale is : ", name);
		model.addAttribute("name", name);
		return "hello";
	}
	
}
