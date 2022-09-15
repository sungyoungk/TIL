# 📚 HTTP 헤더 - 개요
- header-field = field-name ":" OWS field-value OWS (OWS:띄어쓰기 허용)
- field-name은 대소문자 구문 없음



<br>

## HTTP 헤더 - 용도
- HTTP 전송에 필요한 모든 부가정보
- 예) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트, 서버 정보, 캐시 관리 정보...
- 표준 헤더가 너무 많음[(링크)](https://en.wikipedia.org/wiki/List_of_HTTP_header_fields)
- 필요시 임의의 헤더 추가 가능  
    - hello: hi 


<img width="745" alt="스크린샷 2022-09-15 오후 10 54 08" src="https://user-images.githubusercontent.com/101084642/190422261-55f8e3e6-1f3c-4d56-80d1-5e692ecebfd8.png">

<br>

## 🔎 HTTP 표준의 역사
- 1999년 RFC2616(폐기됨)
- 🌟 2014년 **RFC7230~7235** 등장

<br>

### 📌 RFC723x 변화
- 엔티티(Entity) → 표현(Representation)
- Representation = representation Metadata + Representation Data
- 표현 = 표현 메타데이터 + 표현 데이터

<br>

## 🔎 HTTP BODY
#### message body - RFC7230(최신)

- 메시지 본문(message body)을 통해 표현 데이터 전달
- 메시지 본문 = 페이로드(payload)
- **표현**은 요청이나 응답에서 전달할 실제 데이터
- 표현 헤더는 표현 데이터를 해석할 수 있는 정보 제공
  - 데이터 유형(html,json), 데이터 길이, 압축 정보 등등
- 참고 : 표현 헤더는 표현 메타데이터와, 페이로드 메시지를 구분해야 하지만, 여기서는 생략  


<img width="660" alt="스크린샷 2022-09-15 오후 11 07 37" src="https://user-images.githubusercontent.com/101084642/190425376-56b581ab-5fb1-4f76-bc5c-ed58dda65812.png">

<br>

## 🔎 HTTP 헤더 - 표현

<img width="472" alt="스크린샷 2022-09-15 오후 11 28 18" src="https://user-images.githubusercontent.com/101084642/190430339-1c331a69-9109-41ac-afe5-be6d65346def.png">

- Content-Type: 표현 데이터의 형식
- Content-Encoding: 표현 데이터의 압축 방식
- Content-Language: 표현 데이터의 자연 언어
- Content-Length: 표현 데이터의 길이
- 표현 헤더는 전송, 응답 둘다 사용

<br>

### 📌 Content-Type - 표현 데이터의 형식 설명
- 미디어 타입, 문자 인코딩
    - 예) text/html; charset=utf-8
    - 예) application/json
    - 예) image/png
    
    <img width="588" alt="스크린샷 2022-09-15 오후 11 33 57" src="https://user-images.githubusercontent.com/101084642/190431736-6b3c2bbf-15cd-4d18-b292-6e82b3283cea.png">
    
    
<br>

### 📌 Content-Encoding - 표현 데이터의 인코딩
- 표현 데이터를 압축하기 위해 사용
- 데이터를 전달하는 곳에서 압축 후 인코딩 헤더 추가
- 데이터를 읽는 쪽에서 인코딩 헤더의 정보로 압축 해제
    - 예) gzip, deflate, identity
    
    <img width="356" alt="스크린샷 2022-09-15 오후 11 39 16" src="https://user-images.githubusercontent.com/101084642/190433072-ad0dd496-9d87-446b-8b45-481a042c5d3f.png">
    
<br>

### 📌 Content-Language - 표현 데이터의 자연 언어

- 표현 데이터의 자연 언어를 표현
    - 예) ko, en, en-US

    <img width="597" alt="스크린샷 2022-09-15 오후 11 42 47" src="https://user-images.githubusercontent.com/101084642/190433886-764e0d30-1eaa-4b14-bdf7-c8f02fd30631.png">

<br>

### 📌 Content-Length - 표현 데이터의 길이
- 바이트 단위
- Transfer-Encoding(전송 코딩)을 사용하면 Content-Length를 사용하면 안됨
     
    <img width="386" alt="스크린샷 2022-09-15 오후 11 44 24" src="https://user-images.githubusercontent.com/101084642/190434309-04a9aef3-3ca6-4755-a28a-19fb56560807.png">

