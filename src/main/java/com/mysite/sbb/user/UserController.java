package com.mysite.sbb.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm)
	{
		return "signup_form";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "signup_form";
		}
		
		if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
			bindingResult.rejectValue("password2", "passwordInCorrect",
					"2개의 패스워드가 일치하지 않습니다."); // rejectValue(필드명, 오류 이름, 오류 메시지): 특정 필드에 오류 등록 
			return "signup_form";
		}
		
		try {
			userService.create(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1());
			}catch(DataIntegrityViolationException e) { // DB 규칙 위반 예외(중복)
				e.printStackTrace(); // 예외 종류·메시지·발생 경로를 콘솔에 출력
				bindingResult.reject("signupFailed", "이미 등록된 사용자입니다."); // reject(오류 이름, 오류 메시지): 폼 전체에 오류 등록
				return "signup_form";
			}catch(Exception e) {
				e.printStackTrace();
				bindingResult.reject("signupFailed", e.getMessage()); 
				return "signup_form";
		}
		
		return "redirect:/"; // 홈으로 이동
	}
	
	@GetMapping("/login")
    public String login() {
        return "login_form";
    }
}
