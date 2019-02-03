package com.everis.bcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.everis.bcn.dto.FindBookingDto;

@Controller
public class EditBookingController {
	
	@RequestMapping(value="findBooking", method=RequestMethod.GET)
	private ModelAndView findBooking() {
		return new ModelAndView("booking", "command", new FindBookingDto());
	}

}
