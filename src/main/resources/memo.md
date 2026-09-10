# 자바 17버전 다운로드 
Adoptium
Temurin jdk-17.0.19+10, Windows 64 bit (.MSI)

# sts 4.19.1버전 다운로드
https://github.com/spring-projects/spring-tools/wiki/Previous-Versions)
Spring Tools 4.19.1 (Changelog)
제일 처음 jar로 끝나는 링크 다운로드

# 프로젝트 생성
springboot_3.2.1_template 파일 복붙
프로젝트 이름 설정
settings.gradle에 설정한 이름으로 바꾸기

# sbb 프로젝트가 저장된 워크스페이스 경로 확인
File → Switch Workspace → Other...

# JRE Definition설정
괄호안이 jre일 경우 이 과정은 생략 가능
설치한 사이트가 달라서 디렉토리를 교재와 다르게 지정
C:\Program Files\Eclipse Adoptium\jdk-17.0.19.10-hotspot

# lombok
C드라이브에서 SpringToolSuite4.exe선택

# 뭔가 안될때
- Project → Clean
- build.gradle → Refresh
- 프로젝트 또는 폴더 우클릭 → Refresh
- 완전 껏다 키기
- 설정 파일에서는 값 뒤에 공백을 남기지 않고, 주석은 윗줄에 따로 작성하기

# src/main/java 
자바 파일을 저장하는 디렉터리

## com.mysite.sbb 
SBB의 자바 파일을 저장하는 패키지

### SbbApplication.java
SBB프로그램의 시작을 담당하는 파일(자동생성)

### 프로그램 돌아가는거 
[조회할 때]
<a> or URL → Controller → Service → Repository → DB → Repository → Service → Controller → Model → Template

[입력할 때]
<form> → Form → Controller → Service → Repository → DB

[회원가입할 때]
<form> → Form → Controller → Form → Service → PasswordEncoder → Repository → DB → Repository → Service → Controller → redirect

[로그인할 때]
<form> → Spring Security → SecurityService → Repository → DB → Repository → SecurityService → Spring Security → 로그인

[로그아웃할 때]
<a> → Spring Security → 로그아웃

Entity: DB 데이터를 표현하는 자바 클래스
Repository: Entity를 이용해 DB에서 CRUD 처리
Service: Repository를 이용해 필요한 작업 처리
Controller: 요청을 받고 Service를 호출
Form: 사용자가 입력한 값을 받고 검증하는 클래스
Model: Controller의 데이터를 Template에 전달하는 특별한 객체, 스프링 부트가 자동으로 넣어줌
Template: 데이터를 화면에 출력하고 사용자 입력을 받음
Spring Security: 로그인과 권한 검사를 실제로 처리하는 기능
SecurityConfig: Spring Security를 어떻게 사용할지 우리가 작성한 설정 클래스

# src/main/resources
HTML, CSS, 자바스크립트, 환경 파일 등을 저장하는 디렉터리

## templates
HTML 템플릿 파일을 저장하는 디렉터리

## static 
css, 자바스크립트 그리고 이미지 파일(jpg 파일, png 파일 등) 등을 저장

## application.properties 
sbb 프로젝트의 환경 변수, 데이터베이스 등의 설정을 이 파일에 저장

# src/test/java
sbb 프로젝트에서 작성한 파일을 테스트하는 코드를 저장하는 공간

# build.gradle
그레이들(빌드 도구)을 사용하는 빌드 설정 파일

# HTTP 오류 코드
* `400`: 서버가 잘못된 형식의 요청을 받아 처리할 수 없음
* `404`: 요청한 페이지를 찾을 수 없음
* `500`: 서버 내부에서 예상하지 못한 오류가 발생함
* `505`: 서버가 요청에 사용된 HTTP 버전을 지원하지 않음

# Save as UTF-8
한글 주석까지 정상 저장

# CSRF 
CSRF = 로그인된 사용자를 속여 원하지 않는 요청을 보내게 하는 공격
CSRF 토큰 = 그 공격을 막기 위한 확인용 값 

# ORM
자바 객체와 데이터베이스의 테이블을 연결하는 기술
개발자가 작성한 자바 코드를 바탕으로 SQL을 자동 생성하고 실행한다
ORM(최상위 개념) ⊃ JPA(인터페이스), Hibernate(구현체)

# JPA
자바에서 ORM을 사용하기 위한 표준 규칙
인터페이스와 애너테이션으로 구성되어 있다

# Hibernate 
JPA 표준을 실제로 구현한 ORM 프레임워크
자바 코드를 SQL로 변환하여 데이터베이스에 전달한다

# local.mv.db
H2 데이터베이스가 실제 데이터를 저장하는 파일

# 클래스 이름은 보통 대문자
Integer, String, Question 전부 대문자

# 주석

// : 자바, 자바스크립트 등에서 한 줄 주석
 # : application.properties에서 주석 / Markdown에서 제목
<!-- --> : HTML 주석
/* */ : CSS에서 주석, 자바 여러줄 주석

# 단축키 모음
Ctrl + Space: 작성 중인 코드·애너테이션 자동완성
Ctrl + Shift + O: 빠진 import 추가 + 안 쓰는 import 삭제
Ctrl + 1: 빨간 줄이 생겼을 때 해결 방법 표시
Ctrl + H → File Search → 검색
Ctrl + 클릭: 코드의 정의된 위치로 바로 이동하는 기능
Ctrl + Shift + F: 자동정렬


