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

<br>

### 📌 TCP - 3 Way Handshake

1. 클라이언트에서 서버로 SYN 메세지를 보낸다
2. 서버에서도 나도 연결해줘! 하고 SYN 을 보내서 클라이언트의 요청을 수락(ACK) 한다
3. 클라이언트에서 다시 서버로 요청을 수락을 한다 
-  만약 연결이 끊어젔다고 하면 SYN 을 보냈는데 ACK 가 반환되지 않기 때문에 연결이 끊어진 것을 알 수 있다(데이터 전달 보증)
-  TCP 는 실제로 연결된 것이 아니라 클라이언트와 서버간 가상 연결이다(논리적인 연결). 중간에 수많은 서버가 있는데 그 노드들은 연결이 되었는지 실제로 모른다
-  즉, 나를 위한 전용 Lan 선이 보장된것이 아니라 논리적으로 연결된 것이다

<img width="712" alt="스크린샷 2022-09-05 오전 10 39 03" src="https://user-images.githubusercontent.com/101084642/188343836-381084b6-12c5-4afb-8314-2ee5702320eb.png">

<br>

### TCP - 데이터 전달 보증
- 클라이언트에서 서버로 데이터를 전송하면, 서버가 클라이언트에게 데이터를 잘 받았다고 응답을 해준다
- 따라서, 데이터 전달 보증이 된다(만약 응답이 없으면 무엇인가 문제가 생겼음을 인지할 수 있다)

<img width="674" alt="스크린샷 2022-09-05 오전 11 14 38" src="https://user-images.githubusercontent.com/101084642/188347490-154b94dd-20be-4e2b-87ce-ee079b917fdb.png">

<br>

### TCP - 순서 보장

<img width="704" alt="스크린샷 2022-09-05 오전 11 18 33" src="https://user-images.githubusercontent.com/101084642/188348336-d66e0f00-2ac2-468a-b0df-bee66aac5b12.png">

<br>

## UDP
- TCP 와 동일한 IP 계층 위에 있는 프로토콜

<img width="676" alt="스크린샷 2022-09-05 오후 2 19 27" src="https://user-images.githubusercontent.com/101084642/188365877-02f1b1f3-30e1-433c-8e1f-571ea84aac47.png">


<br>

### UDP, 사용자 데이터그램 프로토콜(User Datagram Protocol) - 특징
- 하얀 도화지와 같다(기능이 거의 없다)
- 연결지향 - 2 way hand shake (x)
- 데이터 전달 보증 (x)
- 순서보장 (x)

<br>

### 그럼... UDP는 왜쓰나?
- 데이터 전달 및 순서가 보장되지않지만 단순하고 속도가 빠르다
- Port 와 체크섬(메세지에대해서 맞는지 검증해주는것) 정도만 추가된 형태이다
- 애플리케이션에서 추가 작업이 필요하다
  - 🌟 TDP 는 모든 정보가 다 설정되어 있기때문에 최적화가 어렴다 UDP는 도화지와 같기때문에 애플리케이션 레벨에서 최적화가 가능하다   


