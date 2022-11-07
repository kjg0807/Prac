package com.kjk.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MemberService
{
	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public int setJoin(MemberVO memberVO) throws Exception
	{
		memberVO.setPwd(passwordEncoder.encode(memberVO.getPwd()));
		int rs = memberMapper.setJoin(memberVO);

		if (rs < 1)
		{
			throw new Exception();
		}
		rs = memberMapper.setMemberRole(memberVO);

		if (rs < 1)
		{
			throw new Exception();
		}

		return rs;
	}

	public int getCheckId(MemberVO memberVO) throws Exception
	{
		return memberMapper.getCheckId(memberVO);
	}

	public boolean getMemError(MemberVO memberVO, BindingResult bindingResult) throws Exception
	{
		boolean ch = false;

		ch = bindingResult.hasErrors(); // 에러가 있으면 true

		if (!memberVO.getPwd().equals(memberVO.getPwCheck()))
		{
			ch = true;

			bindingResult.rejectValue("pwCheck", "member.pwd.notEqual");
		}

		int aa = memberMapper.getCheckId(memberVO);
		if (aa == 1)
		{
			ch = true;
			bindingResult.reject("id", "member.id.exist");
		}

		return ch;
	}
}
