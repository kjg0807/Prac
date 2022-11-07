package com.kjk.home.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails
{
	private String id;
	private String pwd;
	private String name;
	private String email;

	private RoleVO roleVO;
	private MemberRoleVO memberRoleVO;

	private String pwCheck;

	@Range(min = 1, max = 150)
	private int age;
	// 태어난 일
	@Past
	private Date birth;

	private List<RoleVO> roleVOs;
	
	private boolean enabled;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleVO roleVO1 : roleVOs)
		{
			authorities.add(new SimpleGrantedAuthority(roleVO1.getRoleName()));
		}

		return authorities;
	}

	@Override
	public String getPassword()
	{
		// TODO Auto-generated method stub
		return this.pwd;
	}

	@Override
	public String getUsername()
	{
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		// TODO Auto-generated method stub
		return true;
	}

}
