package com.mysite.sbb;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // URL 요청을 받아 처리하고, 실행 결과나 화면을 반환하는 컨트롤러로 등록
public class HelloController {
    @GetMapping("/hello") // "/hello" URL과 hello 메서드를 매핑(연결)하는 역할을 한다.
    @ResponseBody // 출력 결과가 문자열 그 자체임을 나타낸다.
    public String hello() {
        return "Hello Spring Boot Board";
    }
}
