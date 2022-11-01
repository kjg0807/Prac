package com.kjk.home.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/member/*")
public class MemberController
{
	public String getLogin() throws Exception
	{
		log.info("===== get Login =====");

		return "member/login";
	}
}
