# 🔎 TCP, UDP

<br>

### 📌 인터넷 프로토콜 4계층

<img width="634" alt="스크린샷 2022-09-03 오후 10 11 41" src="https://user-images.githubusercontent.com/101084642/188271976-ac2b0fe4-2a91-4d22-bcd8-58573f6cbab4.png">

### 📌 프로토콜 계층
- SOCKET 라이브러리로 메시지를 서버로 보낸다고 가정해보면 아래와 같다

![스크린샷 2022-09-04 오후 5 38 10](https://user-images.githubusercontent.com/101084642/188305021-ae0e9583-53a7-4b47-ad97-fdd097891ab4.png)

<br>

### 📌 IP 패킷 정보
- 패킷이란 패키지 + 버팃의 합성어로 네트워크 전송 데이터의 단위를 의마한다
- IP 패킷에는 출발지 IP, 도착지 IP, etc..., 전송 데이터를 포함하고 있다

![스크린샷 2022-09-04 오후 5 45 24](https://user-images.githubusercontent.com/101084642/188305254-f79e50dd-0d29-4d3a-9fa6-c692d188ab52.png)

### 📌 TCP/IP 패키지 정보
- IP 만으로 해결되지 않았던 순서보장 등의 한계점을 TCP가 해결해준다

<img width="558" alt="스크린샷 2022-09-04 오후 5 53 11" src="https://user-images.githubusercontent.com/101084642/188305579-8dfd7e44-0666-477f-b75e-561dc06dea4a.png">

### 📌 TCP 특징
- TCP는 **전송제어 프로토콜(Transmission Control Protocol)** 이다
- 특징으로는...
> **1. 연결지향 - TCP 3 way handshake(가상연결)**  <br>
> **2. 데이터 전달 보증**    <br>
> **3. 순서 보장**   <br>
- 따라서 TCP는 신뢰할 수 있는 프로토콜이다
- 현재는 대부분 TCP를 사용한다
