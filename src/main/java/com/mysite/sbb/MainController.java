package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/sbb")
    @ResponseBody
    public String index() {
        return "안녕하세요 sbb에 오신 것을 환영합니다."; // URL과 매핑된 메서드는 반드시 결괏값을 리턴    
    }
    
   @GetMapping("/")
   public String root() {
	   return "redirect:/question/list"; // redirect: 다른 URL로 다시 이동시킴
   }
}
// Controller에 대한 자세한 설명은 HelloController에 있음