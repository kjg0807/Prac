package com.kjk.home.member;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/member/*")
public class MemberController
{
	@Autowired
	private MemberService memberService;

	@GetMapping("login")
	public String getLogin() throws Exception
	{
		log.info("===== get Login =====");

		return "member/login";
	}

	@GetMapping(value = "join")
	public String setJoin(@ModelAttribute MemberVO memberVO) throws Exception
	{
		log.info("=== get Join ===");

		return "member/join";
	}

	@PostMapping(value = "join")
	public ModelAndView setJoin(ModelAndView mv, @Valid MemberVO memberVO, BindingResult bindingResult) throws Exception
	// memberVO를 검증하기 위해 @Valid 선언 -> 이 값을 BindingResult에 저장(선언만 하면 담아짐)
	{
		log.info("=== post Join ===");

		boolean ch = memberService.getMemError(memberVO, bindingResult);
		if (ch) // ch: true -> 검증에 에러가 있음
		{
			log.info("===== boolean 검증 에러 발생 =====");
			// 검증에 실패하면 회원가입하는 JSP로 이동(forward)
			mv.setViewName("member/join");
			// ====================================== 안해도 됨?
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError fieldError : errors)
			{
				// log.info("fieldError: {}", fieldError);
				// log.info("Field: {}", fieldError.getField());
				// log.info("Message: {}", fieldError.getRejectedValue());
				// log.info("Defalut: {}", fieldError.getDefaultMessage());
				// log.info("Code: {}", fieldError.getCode());
				mv.addObject(fieldError.getField(), fieldError.getDefaultMessage());
				// log.info("============================================");
			}

			return mv;
		}

		int rs = memberService.setJoin(memberVO);
		log.info("rs: {}", rs);

		mv.addObject("join", memberVO);
		mv.setViewName("redirect:./login");

		return mv;
	}

	@RequestMapping(value = "getIdCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO) throws Exception
	{
		log.info("===== Id Check =====");

		int rs = memberService.getCheckId(memberVO);

		log.info("=== rs: {} ===", rs);

		return rs;
	}

	@GetMapping("mypage")
	public String getMyPage() throws Exception
	{
		log.info("=== GET MyPage ===");

		return "member/mypage";

	}
}
