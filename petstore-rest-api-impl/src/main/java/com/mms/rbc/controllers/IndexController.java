package com.mms.rbc.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 */
@RestController
public class IndexController implements ErrorController {

	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error() {
		return "Unable to retrieve that web page";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
	
}
