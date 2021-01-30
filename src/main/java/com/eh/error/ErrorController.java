package com.eh.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/error")
@Controller
public class ErrorController {
	
	@RequestMapping(value = "/error404")
	public String error404 () {
		return "error/error404";
	}
}
