package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // 데이터베이스의 테이블과 매핑되는 자바 클래스임을 지정
public class Question {
	@Id // id 속성을 기본키로 지정(인조식별자)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터를 자동으로 1씩 증가하여 저장
	private Integer id; // Integer는 null을 가질 수 있는 정수 객체

	@Column(length = 200) // 열(길이 = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT") // 글자 수를 제한할 수 없이 텍스트 저장
	private String content;
	
	private LocalDateTime createDate;
	
	// mappedBy는 참조 엔티티의 속성명을 정의, CascadeType.REMOVE는 질문을 삭제하면 그에 달린 답변들도 모두 삭제 
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) 
	private List<Answer> answerList; // Answer 객체만 저장하겠다는 제네릭
	
	@ManyToOne // 여러 질문이 한 명의 사용자에게 속함 (Question N → SiteUser 1)
	private SiteUser author;
	
	private LocalDateTime modifyDate;
	
	@ManyToMany // @ManyToMany 애너테이션을 사용해 다대다 관계로 속성을 생성하면 새로운 테이블이 생성됨
	Set<SiteUser> voter;
}
