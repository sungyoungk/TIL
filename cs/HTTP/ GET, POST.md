# 📚 HTTP 메서드 - GET, POST
- GET: 리소스 조회
- POST: 요청 데이터 처리, 주로 등록에 사용(서버에 데이터를 보낸다) 
- PUT: 리소스를 대체, 해당 리소스가 없으면 생성 
- PATCH: 리소스 부분 변경
- DELETE: 리소스 삭제

### 기타 메서드
- HEAD: GET과 동일하지만 메시지 부분을 제외하고, 상태 줄과 헤더만 반환 
- OPTIONS: 대상 리소스에 대한 통신 가능 옵션(메서드)을 설명(주로 CORS에서 사용)
- CONNECT: 대상 자원으로 식별되는 서버에 대한 터널을 설정
- TRACE: 대상 리소스에 대한 경로를 따라 메시지 루프백 테스트를 수행
※ Connect, Trace는 실무에서 거의 쓰이지 않는다

<br>


## 🔎 GET

![스크린샷 2022-09-07 오후 12 08 21](https://user-images.githubusercontent.com/101084642/188779999-536b83ee-c216-47d5-a4b9-2cdec125e6b6.png)

- 리소스 조회
- 서버에 전달하고 싶은 데이터는 query(쿼리 파라미터, 쿼리 스트링)를 통해 전달한다
- 메시지 바디를 사용해서 데이터를 전달할 수 있지만, 지원하지 않는 곳이 많아서 권장되지 않는다

![스크린샷 2022-09-07 오후 12 30 05](https://user-images.githubusercontent.com/101084642/188782487-85ccf530-2e66-41e9-883d-17d6f5da27b8.png)



<br>

## 🔎 POST
- 요청 데이터 처리
- 메시지 바디를 통해 서버로 요청 데이터 전달
- 서버는 요청 데이터를 처리
  - 메시지 바디를 통해 들어온 데이터를 처리하는 모든 기능을 수행한다
- 주로 전달된 데이터로 신규 리소스 등록, 프로세스 처리에 사용  

![스크린샷 2022-09-07 오후 3 17 56](https://user-images.githubusercontent.com/101084642/188803009-186be3c8-1ad2-4396-87bd-52c4406beeb8.png)

<br>

### 📌 POST - 요청데이터를 처리한다는 의미
- HTML 양식에 입력된 필드와 같은 데이터 블록을 데이터 처리 프로세스에 제공한다
  - ex) HTML FORM에 입력한 정보로 회원가입, 주문 등에 사용
- 게시판, 뉴스그룹, 메일링 리스트, 블로그 또는 유사한 기사 그룹에 메시지 게시
  - ex) 게시판 글쓰기, 댓글 달기
- 서버가 아직 식별하지 않은 새로운 리소스 생성
  - ex) 새로운 주문 생성
- 기존 자원에 데이터 추가
  - ex) 한 문서 끝에 내용 추가하기 <br>
#### 🌟 이 리소스 URI에 POST 요청이 오면 요청 페이지를 어떻게 처리할지 리소스마다 따로 정해야한다(정해진 것이 없음)

<br>

### 📌 POST - 정리
**1. 새로운 리소스르르 생성(등록)한다** 
  - 서버가 아직 식별하지 않은 새로운 리소스를 생성한다  <br>

<br>

**2.  요청 데이터를 처리한다**  
  -  단순히 데이터를 생성하거나, 변경하는것을 넘어서 프로세스를 처리해야 하는 경우
  -  ex) `주문에서 결제완료 → 배달시작 → 배달완료` 처럼 단순히 값 변경을 넘어 프로세스의 상태가 변경되는 경우
  -  POST 결과로 새로운 리소스가 생성되지 않을 수도 있음(새로운 리소스가 만들어지지 않아도 프로세스의 상태가 변경 되는 경우)
  -  리소스만으로 URI를 설계하기가 어려운 경우 컨트롤 URI로 설계할 수도 있다
    - ex) POST /orders/{orderID}/start-delivery(컨트롤 URL)    <br>

<br>

**3. 다른 매서드로 처리하기 애매한 경우**  
  - ex) JSON으로 조회 데이터를 넘겨야 하는데, GET 메서드를 사용하기 어려운 경우
  - 애매하면 Post 
  - 🌟 하지만, GET을 쓸 수 있는경우 GET을 써야한다. GET은 캐싱 기능을 제공하기 때문. POST로는 캐싱을 하기 어려움



