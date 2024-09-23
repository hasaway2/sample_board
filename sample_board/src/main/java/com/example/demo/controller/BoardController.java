package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import jakarta.annotation.*;

@Controller
public class BoardController {
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
}
