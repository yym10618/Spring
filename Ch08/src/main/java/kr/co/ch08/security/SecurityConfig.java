package kr.co.ch08.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.co.ch08.service.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 접근권한 설정
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/guest/**").permitAll();
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
		http.authorizeRequests().antMatchers("/member/**").hasRole("MEMBER");
		
		// User2 테이블에 있는 사용자를 위한 기본 인증 설정(특별한 권한 X) (authenticated())
		http.authorizeRequests().antMatchers("/user/loginSuccess").authenticated();
		
		// 사이트 위조 요청에 대한 방지 설정
		http.csrf().disable();
		
		// 로그인 폼 설정(기본 Security 로그인 폼 사용)
		//http.formLogin();
		
		// 로그인 폼 설정(사용자 정의 폼 사용)
		http.formLogin()
		.loginPage("/user/login")
		.defaultSuccessUrl("/user/loginSuccess")
		.failureUrl("/user/login?success=100")
		.usernameParameter("uid")
		.passwordParameter("pass");
		
		// 로그아웃 설정(사용자 정의)
		http.logout()
		.invalidateHttpSession(true) // 세션해제
		.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")) // 로그아웃주소
		.logoutSuccessUrl("/user/login"); // 로그아웃 후 이동페이지
		
		
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Security 테스트 계정 설정
		// {noop}은 비밀번호에 대해서 암호화 처리를 하지 않음
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("manager").password("{noop}1234").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER");
		
		// 로그인 인증 처리 메서드 설정
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
		
	}
}
