package com.kjk.home;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjk.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController
{
	@GetMapping("/admin")
	@ResponseBody
	public String admin()
	{
		return "admin Role";
	}

	@GetMapping("/manager")
	@ResponseBody
	public String manager()
	{
		return "Manager Role";
	}

	@GetMapping("/user")
	@ResponseBody
	public String member()
	{
		return "Member Role";
	}

	@GetMapping("/")
	public String home(HttpSession session) throws Exception
	{
		log.info("============================");

		Enumeration<String> en = session.getAttributeNames();

		while (en.hasMoreElements())
		{
			String key = en.nextElement();
			log.info("KEY: {}", key);
		}
		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		if (context != null)
		{
			log.info("Context: {}", ((MemberVO) context.getAuthentication().getPrincipal()));
		}

		log.info("HOME");
		log.info("============================");

		return "index";
	}
}
