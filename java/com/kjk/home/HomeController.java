package com.kjk.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController
{
	@GetMapping("/")
	public String home() throws Exception
	{
		log.info("============================");
		log.info("HOME");
		log.info("============================");

		return "home";
	}
}
