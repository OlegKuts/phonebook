package com.lardi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = { "/notes", "/" })
public class IndexController {

	@RequestMapping("")
	public String index() {
		return "main";
	}
}
