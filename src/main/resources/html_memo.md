# 타임리프: HTML 안에 자바 데이터를 넣어 동적인 화면을 만든다. (th:)


# <태그>
`<h1>` : 큰 제목 (숫자가 커질수록 작은 제목)

`<div>` : 여러 태그를 묶는 영역

`<table>` : 표 전체

`<thead>` : 표의 머리 부분

`<tbody>` : 표의 본문 부분

`<tr>` : 행 

`<th>` : 설명 칸

`<td>` : 내용 칸

`<a>`: 링크 칸

`<form>` : 입력값들을 묶어서 서버로 전송

`<ul>` : 목록 전체를 감싸는 태그

`<li>` : 각 목록 항목 (앞에 자동으로 점이 붙는다)

`<label>` : 입력칸의 이름이나 설명

`<input>` : 한 줄 입력

`<textarea>` : 여러 줄 입력

`<link>` : 외부 CSS 파일을 연결

# 페이징 처리

`th:classappend="${!paging.hasPrevious} ? 'disabled'"` : 이전 페이지가 없으면 `disabled` 클래스 추가

`th:classappend="${!paging.hasNext} ? 'disabled'"` : 다음 페이지가 없으면 `disabled` 클래스 추가

`th:href="@{|?page=${paging.number-1}|}"` : 이전 페이지 링크 생성

`th:href="@{|?page=${paging.number+1}|}"` : 다음 페이지 링크 생성

`th:each="page: ${#numbers.sequence(0, paging.totalPages-1)}"` : 0부터 마지막 페이지 번호까지 반복하며 현재 번호를 `page` 변수에 저장

`th:classappend="${page == paging.number} ? 'active'"` : 현재 페이지와 같은 번호에 `active` 클래스 추가
