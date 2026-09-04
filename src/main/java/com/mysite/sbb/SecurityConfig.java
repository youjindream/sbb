package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // 스프링의 환경 설정 파일임을 의미하는 애너테이션
@EnableWebSecurity // 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션
@EnableMethodSecurity(prePostEnabled = true) // @PreAuthorize와 @PostAuthorize를 사용할 수 있도록 활성화(true) 
public class SecurityConfig {
	@Bean // 메서드가 리턴한 객체를 스프링이 관리하도록 등록
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				// 로그인 여부와 관계없이 모든 페이지에 접근할 수 있도록 허용
				.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
						.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
				// /h2-console로 시작하는 URL은 CSRF 검증에서 제외
				.csrf((csrf) -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
				// 같은 출처의 페이지에서 iframe(현재 웹페이지 안에 다른 웹페이지를 넣어 보여주는 HTML 태그) 사용을 허용
				.headers((headers) -> headers.addHeaderWriter(
						new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
				// 로그인 페이지를 지정하고, 인증이 필요하면 로그인 페이지로 이동하며, 로그인 성공 시 메인 페이지로 이동 
				.formLogin((formLogin) -> formLogin.loginPage("/user/login").defaultSuccessUrl("/"))
				// 로그아웃 URL을 지정하고, 로그아웃 시 세션을 삭제한 후 메인 페이지로 이동
				.logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
						.logoutSuccessUrl("/").invalidateHttpSession(true));
		return http.build(); // 보안 규칙을 담은 SecurityFilterChain 객체를 생성하여 리턴
	}

	@Bean 
	PasswordEncoder passwordEncoder() { // 회원가입 시 비밀번호를 BCrypt로 해시
	    // 로그인 시 name="password"에 입력한 값과 SecurityService가 반환한 DB 비밀번호를 비교
		return new BCryptPasswordEncoder();
	}

	@Bean 
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception { // SecurityService의 사용자 조회와 PasswordEncoder의 비밀번호 비교를 이용해 로그인 인증
		return authenticationConfiguration.getAuthenticationManager(); // 진짜 메니저 역할
	}
}
