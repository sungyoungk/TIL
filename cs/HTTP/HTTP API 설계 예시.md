# 📚 HTTP API 설계 예시
#### ▪️ HTTP API 컬렉션
- POST 기반 등록
- 예) 회원 관리 API 제공

#### ▪️ HTTP API - 스토어
- PUT 기반 등록
- 예) 정식 컨텐츠 관리, 원격 파일 관리

#### ▪️ HTML FORM 사용
- 웹페이지 회원 관리
- GET, POST만 지원

<br>

## 🔎 회원 관리 시스템
### 📌 API 설계 - POST 기반 등록 
- 회원 목록 /members → **GET**
- 회원 등록 /members → **POST**
- 회원 조회 /members{id} → **GET**
- 회원 수정 /members{id} → **PATCH, PUT, POST**
- 회원 삭제 /members{id} → **DELETE**

### 🌟 POST 기반의 경우 클라이언트는 등록될 리소스의 URI를 모른다
- 회원 등록 /members → POST
- POST /members
### 🌟 서버가 새로 등록된 리소스 URI를 생성해준다
- HTTP/1.1 201 Created
- Location : /members/100
### 🌟 컬렉션(Collection)
  - POST 기반의 디렉토리 ex) **`/members`** 를 **컬렉션(Collection)** 이라고 한다
