package com.lazygamers.poc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AngularController {

	/*
		This controller catches all unmapped requests and forwards them to root /, where our angular app is served.
		This makes it possible to enter link in browser and be taken directly to that page, instead of having to navigate
		all over again.
	*/
	
	@GetMapping("/**/{path:[^\\.]*}")
	public String forwardToAngularApp(@PathVariable("path") String path) {
		return "forward:/";
	}

}