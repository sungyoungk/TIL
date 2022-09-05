# URI (Uniform Resource Identifier)
- URI 로케이터, 이름 또는 둘다 추가로 분류될 수 있다

- <img width="728" alt="스크린샷 2022-09-05 오후 6 33 15" src="https://user-images.githubusercontent.com/101084642/188417850-4822af7f-06d2-473d-aaf3-da736fdd1238.png">

### 🌟 URL(Resource Locator)
> example.com:8042/over/there?name=ferret#nose

### 🌟 URN(Resource Name)
> urn : example:animal:ferret:nose

#### urn 으로 찾으려면 이름이 매핑이 되어야 하는데, 사실상 찾기가 힘듦. URN이라는것이 있다 라는 정도만 기억하기!

<br>

## 🔎 URI
- **U**niform : 리소스를 식별하는 통일된 방식
- **R**esource : URI로 식별할 수 있는 모든것(자원)
- **I**dentifier : 다른 항목과 구분하기위해 필요한 정보
> URL : Uniform Resource Locator  <br>
> URN : Uniform Resource Name

<br>

### URL / URN
- **Locator **: 리소스가 있는 위치를 지정
- **Name** : 리소스에 이름을 부여 <br>
※ URN 이름만으로 실제 리소스를 찾을 수 있는 방법이 보편화 되지 않음 <br>
※ 편의상 URL URI 를 같은 의미로 생각하면 됨

<br>

### URL 문법

<img width="628" alt="스크린샷 2022-09-05 오후 7 17 08" src="https://user-images.githubusercontent.com/101084642/188426409-bec9a15b-6f1d-460e-871c-953ceaa70785.png">

### 📌 URL Scheme(스키마)
- 주로 **프로토콜** 사용
- **프로토콜** : 클라이언트, 서버간 규칙으로 어떻게 자워에 접근할 것인가 약속하는 규칙
  - ex) http, https, ftp 등
- http 는 80 포트, https 는 430 포트를 주로 사용하고, 포트는 생략 가능하다
- https는 http에 보안이 추가된 프로토콜  

<br>

### 📌 URL Port
- 접속 포트
- 일반적으로 생략, 생략시 `http는 80, https는 430` 이 디폴트값

<br>

### 📌 URL Path(리소스가 있는 경로)
- 리소스가 있는 경로로 계층적 구조로 되어 있음
  - ex) /home/file1.jpg

<br>

### 📌 URL query(쿼리)
- key=value 형태임
- `?` 로 시작, `&`로 주가 가능 **`?keyA=valueA&keyB=valueB`**
- query 파라미터, query 스트링이라고도 부른다

<br>

### 📌 URL fragment
- html 내부에서 이동시에 보통 사용한다
- html 내부 북마크등에서 사용하고, 서버로 전송되는 정보는 아니다
- 잘 사용하지 않는다

