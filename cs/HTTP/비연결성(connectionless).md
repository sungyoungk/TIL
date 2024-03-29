# 비연결성(connectionless)

<img width="981" alt="스크린샷 2022-09-06 오후 6 07 27" src="https://user-images.githubusercontent.com/101084642/188595128-d544b4f4-a379-4875-af98-904448f91e4f.png">

- HTTP는 기본이 연결을 유지하지 않는 모델이다
- 일반적으로 초 단위 이하의 빠른 속도로 응답한다
- 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청은 수십개 이하로 매우 적음
  -  ex) 웹 브라우저에서 계속 연속해서 검색버튼을 누르지는 않음
- 서버자원을 효율적으로 사용할 수 있음

<br>

##  🔎 비연결성
### 한계와 극복
- TCP/IP 연결을 새로 맺는 시간 추가(3way handshake 시간 등)
- 웹브라우저로 사이트를 요청하면 HTML 뿐만 아니라 자바스크립트, css, 이미지 등 많은 자원이 같이 다운로드 됨
- 지금은 HTTP 지속연결(Persistenct Connections)로 문제 해결
- HTTP/2, HTTP/3 에서 더 많은 최적화

<img width="850" alt="스크린샷 2022-09-06 오후 5 35 03" src="https://user-images.githubusercontent.com/101084642/188587798-25a583ca-e002-487a-97af-07b8ea847fe9.png">

<br>

### 📌 Stateless, Connectionless 구분하기
- 비연결성은 TCP/IP 커넥션 연결을 지속하지 않는 다는 뜻
- Stateless는 클라이언트와 서버사이에 상태를 유지하지 않는다는 뜻(가게에서 주문했던 예시 참고)

<br>

###  🔎 개발자들이 어려워하는 부분 - Stateless를 기억하자!
- 같은시간에 동시다발적으로 일어나는 대용량 트래픽
- ex) 선착순 이벤트, 명절 KTX 예약, 대학교 수업등록
- ex) 오후 18:00 선착순 1000명 치킨 할인 이벤트 → 수만명 동시 요청

🌟 이런 경우, 최대한 Stateless 로 설계하는것이 중요하다. 서버를 스케일 아웃 할 수 있기 때문이다

