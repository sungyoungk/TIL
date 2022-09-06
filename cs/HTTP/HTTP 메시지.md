# HTTP 메시지

<img width="438" alt="스크린샷 2022-09-06 오후 8 24 10" src="https://user-images.githubusercontent.com/101084642/188623949-7560760c-b5ed-458a-a6e0-d0345a881050.png">


<img width="846" alt="스크린샷 2022-09-06 오후 8 48 35" src="https://user-images.githubusercontent.com/101084642/188627862-f86aea8f-5a3d-4167-a9ba-d680a64104d0.png">

##  📚 HTTP 응답 메시지 공식 스펙

<img width="912" alt="스크린샷 2022-09-06 오후 8 56 28" src="https://user-images.githubusercontent.com/101084642/188628749-d31207ec-6190-4bfc-8243-5a285ac46147.png">


<br>

## 📚 시작라인 - 요청 메시지
- start-line = **request-line** / status-line
- **request-line** = method SP(공백) request-target SP HTTP-version CRLF(엔터)

- HTTP 메서드 (GET: 조회)
- 요청 대상 (/search?q=hello&hl=ko)
- HTTP Version

<img width="463" alt="스크린샷 2022-09-06 오후 9 02 54" src="https://user-images.githubusercontent.com/101084642/188630229-b76bfeee-4cea-4420-9abe-097eda41dcc1.png">

<br>

### 요청 메시지 - HTTP 메서드
- 종류: GET, POST, PUT, DELETE
- 서버가 수행할 동작을 지정한다
  - GET : 리소스 조회
  - POST : 요청 내역 처리   

<br>

### 요청 메시지 - 요청 대상
- absolute-path[?query] (절대경로[?쿼리])
- 절대경로= "/" 로 시작하는 경로  <br>
※ *, http://...?x=y 와 같이 다른 유형의 경로지정 방법도 있다.

<br>

## 📚 시작라인 - 응답 메시지
- start-line = request-line / status-line
- status-line = HTTP-version SP status-code SP reason-phrase CRLF

- HTTP 버전
- HTTP 상태코드 : 요청 성공, 실패를 나타냄
   - 200 : 성공
   - 400 : 클라이언트 요청 오류
   - 500 : 서버 내부 오류
 - 이유 문구 : 사람이 이해할 수 있는 짧은 상태 코드 설명글 (OK)   

<img width="373" alt="스크린샷 2022-09-06 오후 9 27 34" src="https://user-images.githubusercontent.com/101084642/188634945-fc1e48cc-b497-43f8-888c-f798e8a5f0db.png">

<br>

## 📚 HTTP 헤더
- header-field = field-name ":" OWS fied-value OWS (OWS : 띄어쓰기 허용)
- field name은 대소문자 구분이 없음

<img width="738" alt="스크린샷 2022-09-06 오후 11 04 06" src="https://user-images.githubusercontent.com/101084642/188655838-36c4837f-cf75-4479-8335-301a39db4856.png">

<br>

###  HTTP 헤더의 용도
- HTTP 전송에 필요한 모든 부가정보 <br>
ex) 메시지 바디의 내용, 메시지 바디 크기, 압축, 인증, 요청 클라이언트(브라우저) 정보, 서버 애플리케이션 정보, 캐시 관리 정보, etc...
- 표준 헤더가 너무 많다(https://en.wikipedia.org/wiki/List_of_HTTP_header_fields)
- 필요시 임의의 헤더 추가 가능

<br>

###  HTTP 메세지 바디의 용도

- 실제 전송할 데이터
- HTML문서, 이미지, 영상 JSON 등.. byte로 표현 가능한 모든 데이터 전송 

<img width="375" alt="스크린샷 2022-09-06 오후 11 08 32" src="https://user-images.githubusercontent.com/101084642/188656819-cb85df40-a9c2-455b-9f26-b45f3fbef1ed.png">

