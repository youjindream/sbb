package com.mysite.sbb.user;

import lombok.Getter;

@Getter
public enum UserRole { // enum(열거 자료형) = 넣을 수 있는 값을 미리 제한해 놓은 자료형
	ADMIN("ROLE_ADMIN"), // 열거형 값("저장할 문자열") : 저장할 문자열을 생성자에 전달
	USER("ROLE_USER");
	
	UserRole(String value){ // 생성자
		this.value = value;
	}
	
	private String value;

}
