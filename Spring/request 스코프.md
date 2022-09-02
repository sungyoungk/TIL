# 🔎 request 스코프

### 👀 사전작업
- 웹스코프는 웹 환경에서만 작동하므로, web 환경이 동작하기 위한 라이브러리 추가가 필요하다

<br>

✅ `build.gradle`에 추가

```java

    //web 라이브러리 추가
    implementation 'org.springframework.boot:spring-boot-starter-web'

```

- 웹 라이브러리 추가로 CoreApplication의 main 메서드 실행시 웹 어플리케이션이 실행된다
- 아래 콘솔창과 같이 `spring-boot-starter-web` 라이브러리 추가시 스프링 부트는 내장 톰켓 서버를 활용해서 웹서버와 스프링은 같이 실행시킨다
<img width="1159" alt="스크린샷 2022-09-02 오후 3 57 35" src="https://user-images.githubusercontent.com/101084642/188077371-cf63bbf4-94f3-42f9-9153-d4f2b8011c3f.png">

<br>

### 🌟참고 - web starter 라이브러리가 없을 경우 스프링 부트는...
- `AnnotationConfigApplicationContext`를 기반으로 애블리케이션을 구동한다
- 라이브러리 추가시 `AnnotationConfigServletWebServerApplicationContext`를 기반으로 애플리케이션을 구동한다

<br>

### 포트 변경 필요시
#### ✅ `main/resources/application.properties`
```java
server.port=9090

```

<br>

## request 스코프 예제 코드

<img width="802" alt="스크린샷 2022-09-02 오전 11 27 17" src="https://user-images.githubusercontent.com/101084642/188078356-bac0ef94-a485-4ff4-8506-e2a5a93f9bad.png">

- 동시에 많은 HTTP 요청이 올때 어떤 요청이 남긴 로그인지 구분하기위해 request 스코프를 활용한다
- request 스코프에 로그가 남도록 기능 개발 해보기
- 프로토타입 스코프와 달리 request 스코프는 클라이언트 요청이 들어오고 나갈때 까지는 스프링 컨테이너가 빈 관리를 한다
- 즉, 소멸 메서드 호출이 가능하다
