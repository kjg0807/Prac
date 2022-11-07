package com.kjk.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	@Bean
	WebSecurityCustomizer webSecurityCustomizer()
	{
		return web -> web.ignoring().antMatchers("/image/**") // image폴더 밑 전부 허용
				.antMatchers("/css/**") // css 폴더 밑 전부 허용
				.antMatchers("/js/**") // js 폴더 밑 전부 허용
				.antMatchers("/resources/**") // resources 폴더 및 전부 허용
		;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.cors().and().csrf().disable().authorizeRequests() //
				.antMatchers("/").permitAll() //
				.antMatchers("/login").permitAll().antMatchers("/logout").permitAll() //
				.antMatchers("/admin").hasRole("ADMIN") //
				.antMatchers("/manager").hasAnyRole("ADMIN", "MANAGER") //
				.antMatchers("/member/mypage").hasAnyRole("ADMIN", "MANAGER", "MEMBER") //
				.antMatchers("/board/list").permitAll() //
				.antMatchers("/board/**").hasAnyRole("ADMIN", "MANAGER", "MEMBER") //
				.anyRequest().permitAll() //
				//
				.and() //
				.formLogin()//
				.loginPage("/member/login") //
				.passwordParameter("pwd")//
				.usernameParameter("id") //
				.defaultSuccessUrl("/") //
				.failureForwardUrl("/member/login")//
				.permitAll()//
				.and()//

				.logout()//
				.logoutUrl("/member/logout") //
				.logoutSuccessUrl("/") //
				.invalidateHttpSession(true) //
				.deleteCookies("JSESSIONID") //
				.permitAll() //
		;

		return httpSecurity.build();
	}

	@Bean
	public PasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
