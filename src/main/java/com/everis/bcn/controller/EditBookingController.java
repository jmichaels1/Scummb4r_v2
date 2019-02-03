package com.everis.bcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


import com.everis.bcn.dto.FindBookingDto;
import com.everis.bcn.dto.UpdateBookingDto;

@Controller("/edit")
public class EditBookingController {
	
	@RequestMapping(value="findBooking", method=RequestMethod.GET)
	private ModelAndView findBooking() {
		return new ModelAndView("findBooking", "command", new FindBookingDto());
	}
	
	
	@RequestMapping(value="findBooking", method=RequestMethod.POST)
	private ModelAndView findBooking(@ModelAttribute("command") FindBookingDto dto, BindingResult result, SessionStatus session) {
		System.out.println("localizator from front: " + dto.getLocalizator());
		//TODO localizator validation logic and dto map 
		return new ModelAndView("updateBooking", "commandUpdate", new UpdateBookingDto());
	}
	
	@RequestMapping(value="updateBooking", method=RequestMethod.POST)
	private ModelAndView updateBooking(@ModelAttribute("commandUpdate") UpdateBookingDto dto, BindingResult result, SessionStatus session) {
		System.out.println("UpdateBookingDto from front : " + dto);
		return null;
	}
}
