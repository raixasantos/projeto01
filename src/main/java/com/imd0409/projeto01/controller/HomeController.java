package com.imd0409.projeto01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHomePage(){
		return "home";
	}
}
