package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// 리포지터리는 데이터베이스 테이블의 데이터들을 저장, 조회, 수정, 삭제 등을 할 수 있도록 도와주는 인터페이스
// <Question, Integer>는 Question 엔티티로 리포지터리를 생성하고, Question 엔티티의 기본키가 Integer
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	// findAll(), save(), findById()는 기본으로 있는 메서드
	// findById: id를 기준으로 데이터(레코드 한줄)를 찾아라
	Question findBySubject(String subject); // (findBy + 속성명)이면 자동으로 조회 기능을 구현
	Question findBySubjectAndContent(String subject, String content); // 두 개의 열을 조회하기 위해서는 And 연산자를 사용
	List<Question> findBySubjectLike(String subject); // subject 열 값들 중에 특정 문자열을 포함하는 데이터를 조회
	Page<Question> findAll(Pageable pageable); // pageable에 지정된 페이지 번호와 개수만큼 Question을 조회하여 Page 객체로 반환
	Page<Question> findAll(Specification<Question> spec, Pageable pageable); // 검색조건(spec)과 페이징조건(pageable)으로 Question 조회

	// @Query = JPQL 문자열로 검색 조건 작성, Specification = 자바 코드로 검색 조건 작성
	 @Query("select "
	            + "distinct q "
	            + "from Question q " 
	            + "left outer join SiteUser u1 on q.author=u1 "
	            + "left outer join Answer a on a.question=q "
	            + "left outer join SiteUser u2 on a.author=u2 "
	            + "where "
	            + "   q.subject like %:kw% "
	            + "   or q.content like %:kw% "
	            + "   or u1.username like %:kw% "
	            + "   or a.content like %:kw% "
	            + "   or u2.username like %:kw% ")
	    Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}
