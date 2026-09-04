package com.mysite.sbb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus: 예외 발생 시 응답할 HTTP 상태 지정
//HttpStatus.NOT_FOUND: 404 오류
//reason: 오류 이유로 표시할 문구
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException { 
    private static final long serialVersionUID = 1L; // 객체의 직렬화(객체를 저장·전송 가능한 형태로 변환) 버전 번호
    public DataNotFoundException(String message) { 
        super(message); // 오류 메시지를 부모 생성자에 전달
    }
}
