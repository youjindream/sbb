package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // 서비스 클래스
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	public List<Question> getList() {
		return this.questionRepository.findAll();
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if (question.isPresent()) { // isPresent(): 값이 있니?
			return question.get(); // Optional 안에 들어 있는 Question 객체를 꺼내 반환
		} else {
			throw new DataNotFoundException("question not found");
		}
	}
	
	public void create(String subject, String content, SiteUser user) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		q.setAuthor(user);
		this.questionRepository.save(q);
	}
	
	public Page<Question> getList(int page, String kw) {
		List<Sort.Order> sorts = new ArrayList<>(); // Sort.Order : 정렬 기준(createDate)과 방향(desc)을 담은 객체, ArrayList : 배열 기반 리스트 객체
		sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts)); // PageRequest.of(조회할 페이지 번호, 한 페이지당 데이터 개수, 정렬 방식);
        // Specification<Question> spec = search(kw); // 같은 클래스에 있는 search(String kw) 호출
        return this.questionRepository.findAllByKeyword(kw, pageable);
    }
	
	public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }
	
	public void delete(Question question) {
		this.questionRepository.delete(question);
	}
	
	public void vote(Question question, SiteUser siteUser) {
		question.getVoter().add(siteUser);
		this.questionRepository.save(question);
	}
	
	/*
	// Specification = 조회 조건(WHERE)을 정의하는 인터페이스
	// Root = 조회의 "기준"이 되는 엔티티를 나타내는 객체
	// CriteriaQuery = 조회할 전체 쿼리의 구조와 설정을 관리하는 객체
	// CriteriaBuilder = WHERE절에 들어갈 검색 조건을 만들어주는 도구 객체
	// Predicate = CriteriaBuilder로 만들어진 WHERE 검색 조건을 나타내는 객체
	// cb.or(...)는 여러 검색 조건 중 하나라도 참이면 통과시키는 OR 조건
	private Specification<Question> search(String kw) { // 문자열 검색어 kw를 받아서, Question을 조회할 검색 "조건"을 반환하는 search 메서드
		return new Specification<>() { // Specification 인터페이스를 익명 객체로 구현해서 반환
			private static final long serialVersionUID = 1L; // 직렬화(객체를 저장하거나 전송할 수 있는 형태로 바꾸는 것) 버전 번호
			@Override
			public Predicate toPredicate(Root<Question> q, CriteriaQuery<?> query, CriteriaBuilder cb) { // Question 조회에 사용할 검색 조건을 만들어 반환
				query.distinct(true); // JOIN으로 인해 중복된 Question 결과 제거
				Join<Question, SiteUser> u1 = q.join("author", JoinType.LEFT); // Question의 author 필드를 통해 SiteUser와 LEFT JOIN
				Join<Question, Answer> a = q.join("answerList", JoinType.LEFT);
				Join<Answer, SiteUser> u2 = a.join("author", JoinType.LEFT);
				return cb.or(cb.like(q.get("subject"), "%" + kw + "%"), // Question의 subject에 검색어 kw가 포함되어 있는지 확인
						cb.like(q.get("content"), "%" + kw + "%"),
						cb.like(u1.get("username"), "%" + kw + "%"),
						cb.like(a.get("content"), "%" + kw + "%"),
						cb.like(u2.get("username"), "%" + kw + "%"));
			}
		};
	} */
}
