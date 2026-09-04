package com.mysite.sbb;

import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RequiredArgsConstructor // public HelloLombok(String hello) {this.hello = hello}
@Getter // public String getHello() {return this.hello;}
@Setter // public void setHello(String hello) {this.hello = hello;}
public class HelloLombok {
	private final String hello; // final을 사용하면 Setter 메서드를 사용할 수 없다
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok("헬로");
//		helloLombok.setHello("헬로"); 
		
		System.out.println(helloLombok.getHello()); 
	}

}

//위쪽 메뉴의 초록색 재생 버튼에서 HelloLombok 클릭
//@RequiredArgsConstructor 보충설명: final이 붙은 필드의 생성자를 자동으로 만듦