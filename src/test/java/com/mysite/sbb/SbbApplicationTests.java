package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;

@SpringBootTest // 스프링 부트의 테스트 클래스임을 의미
class SbbApplicationTests {

	@Autowired // 스프링 부트가 questionRepository 객체를 자동으로 만들어 주입한다
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionService questionService;
	
//	@Test // JUnit을 실행하면 @Test 애너테이션이 붙은 메서드가 실행
//	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1); // 질문 저장
//		
//		Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);
//	}
	
//	@Test
//	void testJpa() {
//		List<Question> all = this.questionRepository.findAll(); // question 테이블의 모든 데이터를 조회
//		assertEquals(2, all.size()); // assertEquals(기댓값, 실젯값), 앞서 2개의 질문 데이터를 저장했기 때문에 2
//		
//		Question q = all.get(0); // 0번 인덱스 가져오기
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//	}
	
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1); // id값이 1, findById의 리턴 타입은 Optional
//			if(oq.isPresent()) { // Optional은 null값을 포함, isPresent()로 값이 존재하는지 확인
//				Question q = oq.get();
//				assertEquals("sbb가 무엇인가요?", q.getSubject());
//			}
//		
//	}
	
//	@Test
//	void testJpa() {
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?"); // QuestionRepository에 직접 선언한 findBySubject() 메서드 호출
//		assertEquals(1, q.getId());
//	}
	
//	@Test
//	void testJpa() {
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%"); // % 정처기 시험에 나왔지~
//		Question q = qList.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//	}
	
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent()); // assertTrue()는 괄호 안의 값이 true(참) 인지를 테스트
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
//	}
	
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
//	}
	
//	@Test
//	void testJpa() {
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());
//	}
	
//	@Transactional // 메서드가 끝날 때까지 JPA가 DB 작업을 계속할 수 있게 유지
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2); // findById() 메서드 사용 후 DB 세션 종료
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		List<Answer> answerList = q.getAnswerList(); // @Transactional가 없으면 DB 세션이 종료되어 오류
//		
//		assertEquals(1, answerList.size());
//		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
//	}
	
	@Test
	void testJpa() {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터 입니다: [%03d]", i);
			String content = "내용무";
			this.questionService.create(subject, content, null);
		}
	}
	
}
