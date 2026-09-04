package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// 리포지터리는 데이터베이스 테이블의 데이터들을 저장, 조회, 수정, 삭제 등을 할 수 있도록 도와주는 인터페이스
// <Question, Integer>는 Question 엔티티로 리포지터리를 생성하고, Question 엔티티의 기본키가 Integer
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	// findAll(), save(), findById()는 기본으로 있는 메서드
	// findById: id를 기준으로 데이터(레코드 한줄)를 찾아라
	Question findBySubject(String subject); // (findBy + 속성명)이면 자동으로 조회 기능을 구현
	Question findBySubjectAndContent(String subject, String content); // 두 개의 열을 조회하기 위해서는 And 연산자를 사용
	List<Question> findBySubjectLike(String subject); // subject 열 값들 중에 특정 문자열을 포함하는 데이터를 조회
	Page<Question> findAll(Pageable pageable); // // pageable에 지정된 페이지 번호와 개수만큼 Question을 조회하여 Page 객체로 반환

}
