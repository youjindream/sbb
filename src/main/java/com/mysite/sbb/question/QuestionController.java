package com.mysite.sbb.question;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.mysite.sbb.answer.AnswerForm;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/question") // 프리픽스(정처기에 나온거 틀려서 더 기억에 남는...) 설정
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionService questionService; // QuestionService가 같은 패키지에 있으므로 import 생략
	private final UserService userService;
	
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value="page", defaultValue="0")int page) { // @RequestParam : URL의 ?이름=값에서 값을 꺼내 메서드의 매개변수에 저장해 주는 애너테이션
		Page<Question> paging = this.questionService.getList(page); // Page는 Spring Data에서 제공하는 인터페이스(import 되어있음)
		model.addAttribute("paging", paging); // Model 객체에 속성을 추가, addAttribute("이름", 전달할 데이터); 
		return "question_list"; // question_list.html 템플릿에 Model 값을 넘겨 화면에 표시
	}
	
	@GetMapping(value = "/detail/{id}") // {중괄호}: 고정된 글자가 아닌 달라지는 값
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) { // URL의 {id} → @PathVariable → Integer id에 저장
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
	
	@PreAuthorize("isAuthenticated()") // @PreAuthorize: 메서드를 실행하기 전 권한 확인, isAuthenticated(): 현재 사용자가 인증(로그인)되어 있니?
	@GetMapping("/create")
    // 매개변수로 받은 QuestionForm 객체는 자동으로 Model에 담겨
    // th:object="${questionForm}"에서 사용할 수 있음
	public String questionCreate(QuestionForm questionForm) { 
		return "question_form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	// @Valid: Form에 적어 둔 검증 규칙을 실행 / BindingResult: 검증 결과를 담는 객체
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		SiteUser siteUser = this.userService.getUser(principal.getName());
		this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
		return "redirect:/question/list";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify/{id}")
	public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal) {
		Question question = this.questionService.getQuestion(id);
		if(!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다."); // ResponseStatusException(상태코드, 설명) : 일부러 HTTP 에러를 발생시킴
		}
		questionForm.setSubject(question.getSubject()); // 수정 입력칸에 표시하기 위해 기존 질문 제목을 Form에 저장
		questionForm.setContent(question.getContent());
		return "question_form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/modify/{id}")
	public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal, @PathVariable("id") Integer id) {
		if (bindingResult.hasErrors()) {
			return "question_form";	
		}
		Question question = this.questionService.getQuestion(id);
		if(!question.getAuthor().getUsername().equals(principal.getName())){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다."); 
		}
		this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
		return String.format("redirect:/question/detail/%s", id);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/delete/{id}")
	public String questionDelete(Principal principal, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		if(!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
		}
		this.questionService.delete(question);
		return "redirect:/";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/vote/{id}")
	public String questionVote(Principal principal, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		SiteUser siteUser = this.userService.getUser(principal.getName());
		this.questionService.vote(question, siteUser); // 한 사람이 같은 질문을 여러 번 추천하지 못하게 하기 위해 siteUser도 전달
		return String.format("redirect:/question/detail/%s", id);
	}
}

