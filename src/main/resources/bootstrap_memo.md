# Bootstrap

HTML 요소를 쉽게 꾸밀 수 있도록 CSS 클래스와 디자인 기능을 미리 만들어 놓은 도구

# 부트스트랩 연결

```
<link rel="stylesheet" type="text/css" th:href="@{/bootstrap.min.css}">
```
 
# class

HTML 요소에 적용할 클래스 이름을 적는 속성

클래스는 직접 만들 수도 있고, 부트스트랩이 미리 만든 클래스를 사용할 수도 있다.

```
<div class="container my-3">
```

띄어쓰기로 여러 클래스를 동시에 적용할 수 있다.

# 여백 클래스 규칙

`m` : margin, 바깥 여백  
`p` : padding, 안쪽 여백  

`t` : 위쪽  
`b` : 아래쪽  
`s` : 시작 방향, 보통 왼쪽  
`e` : 끝 방향, 보통 오른쪽  
`x` : 왼쪽과 오른쪽  
`y` : 위쪽과 아래쪽  
방향 없음 : 모든 방향  

`0 ~ 5` : 여백 크기  
`auto` : 자동 여백  
`lg` : large 화면 이상

`mt-3` : 위쪽 바깥 여백  
`mb-3` : 아래쪽 바깥 여백  
`ms-3` : 왼쪽 바깥 여백  
`me-3` : 오른쪽 바깥 여백  
`mx-3` : 좌우 바깥 여백  
`my-3` : 위아래 바깥 여백  
`m-3` : 모든 방향 바깥 여백  

`pt-2` : 위쪽 안쪽 여백  
`pb-2` : 아래쪽 안쪽 여백  
`ps-2` : 왼쪽 안쪽 여백  
`pe-2` : 오른쪽 안쪽 여백  
`px-2` : 좌우 안쪽 여백  
`py-2` : 위아래 안쪽 여백  
`p-2` : 모든 방향 안쪽 여백  

# 너비(가로)와 배치

`container` : 내용을 적당한 너비로 만들고 화면 가운데 배치  
`container-fluid` : 화면 너비를 거의 전부 사용  

`w-25` : 너비 25%  
`w-50` : 너비 50%  
`w-75` : 너비 75%  
`w-100` : 너비 100%  

# 높이(세로)와 배치

`h-25` : 높이 25%
`h-50` : 높이 50%
`h-75` : 높이 75%
`h-100` : 높이 100%

# 글자 정렬

`text-start` : 왼쪽 정렬  
`text-center` : 가운데 정렬  
`text-end` : 오른쪽 정렬 
* 자식 요소에 별도의 정렬 설정이 없으면 부모의 설정을 따라감 

# 글자 모양

`fw-bold` : 굵은 글자  
`fw-normal` : 보통 굵기  
`fst-italic` : 기울임  
`text-decoration-none` : 밑줄 제거  

# 글자 색상

`text-primary` : 주요 색상의 글자 (파란색)
`text-secondary` : 보조 색상의 글자 (회색)
`text-success` : 성공 글자색 (초록색)
`text-danger` : 위험 글자색 (빨간색)
`text-warning` : 경고 글자색 (노란색)
`text-info` : 정보 글자색 (하늘색, 청록색)
`text-light` : 밝은 글자색 (흰색)
`text-dark` : 어두운 글자색 (검정색)

# 배경 색상

`bg-primary` : 주요 배경색  
`bg-secondary` : 보조 배경색  
`bg-success` : 성공 배경색  
`bg-danger` : 위험 배경색  
`bg-warning` : 경고 배경색  
`bg-info` : 정보 배경색  
`bg-light` : 밝은 배경색  
`bg-dark` : 어두운 배경색 

# 테두리

`border` : 모든 방향 테두리  
`border-top` : 위쪽 테두리  
`border-bottom` : 아래쪽 테두리  
`border-start` : 왼쪽 테두리  
`border-end` : 오른쪽 테두리  
`border-0` : 테두리 제거  

`rounded` : 모서리를 둥글게 표시  
`rounded-circle` : 원 모양으로 표시  

# 버튼

`btn` : 버튼 기본 모양  
`btn-primary` : 주요 버튼  
`btn-secondary` : 보조 버튼  
`btn-success` : 성공 버튼  
`btn-danger` : 위험 버튼  
`btn-warning` : 경고 버튼  
`btn-info` : 정보 버튼  
`btn-light` : 밝은 버튼  
`btn-dark` : 어두운 버튼  
`btn-sm` : 작은 버튼  
`btn-lg` : 큰 버튼  
`btn-outline-secondary` : 회색 계열 테두리 버튼

# 입력칸

`form-control` : 입력칸 스타일  
`form-label` : 입력칸 제목 스타일  
`form-check` : 체크박스 영역  
`form-check-input` : 체크박스 또는 라디오 버튼  
`form-check-label` : 체크박스 설명  

# 표시 방식

`d-none` : 화면에서 숨김  
`d-block` : 한 줄 전체를 차지  
`d-inline` : 내용 크기만 차지  
`d-inline-block` : inline과 block의 특징을 함께 사용  
`d-flex` : Flex 방식으로 배치 (한 줄 중심 배치)
`d-grid` : Grid 방식으로 배치 (표처럼 행과 열로 배치)

# Flex 가로 정렬

`justify-content-start` : 시작 쪽 정렬  
`justify-content-center` : 가운데 정렬  
`justify-content-end` : 끝 쪽 정렬  
`justify-content-between` : 양쪽 끝에 배치하고 사이를 띄움  
`justify-content-around` : 각 요소 주변에 여백을 줌  

# Flex 세로 정렬

`align-items-start` : 세로 시작 쪽 정렬  
`align-items-center` : 세로 가운데 정렬  
`align-items-end` : 세로 끝 쪽 정렬  

# 테이블

`table` : 표에 부트스트랩 기본 디자인 적용  
`table-striped` : 표의 행마다 번갈아 배경색 적용  
`table-bordered` : 표의 모든 칸에 테두리 적용  
`table-hover` : 마우스를 올린 행의 배경색 변경  
`table-sm` : 표의 칸 간격을 작게 표시  
`table-dark` : 어두운 색상의 표  
`table-responsive` : 화면이 좁을 때 표를 가로로 스크롤할 수 있게 감싸는 클래스

# 카드

`card` : 카드 전체  
`card-body` : 카드 내용 영역  
`card-title` : 카드 제목  
`card-text` : 카드 글 내용  
`card-header` : 카드 위쪽 영역  
`card-footer` : 카드 아래쪽 영역  

# 배지

`badge` : 글자를 작고 둥근 배지 모양으로 표시  
`rounded-pill` : 배지의 모서리를 더 둥글게 표시  
`bg-light` : 밝은 배경색 적용 (흰색·연한 회색 계열) 

# 그림자
`shadow-none` : 그림자 없음  
`shadow-sm` : 작은 그림자  
`shadow` : 기본 그림자  
`shadow-lg` : 큰 그림자  

응! 조금 더 정확하고 시험/필기용으로 보기 좋게 다듬으면 이렇게 정리하면 돼.

**# 네비게이션 바**

`navbar` : 네비게이션 바 기본 스타일
`navbar-expand-lg` : `lg` 크기 이상 화면에서는 메뉴를 펼쳐서 표시
`navbar-light` : 밝은 배경에 어울리는 글자/아이콘 스타일
`navbar-brand` : 사이트 이름이나 로고 영역
`navbar-nav` : 네비게이션 메뉴 목록
`nav-item` : 메뉴 항목 하나
`nav-link` : 메뉴 항목의 링크
`navbar-toggler` : 작은 화면에서 메뉴를 열고 닫는 버튼 (icon = 햄버거)
`navbar-collapse` : 작은 화면에서 접히고 펼쳐지는 네비게이션 메뉴 영역
`collapse` : 요소를 접고 펼칠 수 있게 하는 클래스

**# Bootstrap 동작 속성**

`toggle` : 열기/닫기처럼 두 상태를 번갈아 변경한다는 의미
`data-bs-toggle` : 어떤 Bootstrap 기능을 사용할지 지정
`data-bs-toggle="collapse"` : 접기/펼치기 기능 사용
`data-bs-toggle="dropdown"` : 드롭다운 기능 사용
`data-bs-toggle="modal"` : 모달창 기능 사용
`data-bs-target` : Bootstrap 기능을 적용할 HTML 요소 지정

# 접근성 속성

`aria-controls` : 이 요소가 어떤 요소를 제어하는지 알려줌
`aria-expanded` : 현재 대상 요소가 열려 있는지 닫혀 있는지 알려줌
`aria-label` : 요소의 역할을 글로 설명해주는 속성

# 경고창

`alert` : 경고 메시지 영역
`alert-danger` : 빨간색 위험·오류 경고
`role="alert"` : 이 영역이 경고 메시지임을 표시