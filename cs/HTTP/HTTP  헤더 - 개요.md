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
