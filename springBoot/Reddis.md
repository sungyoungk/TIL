## 🔎 Reddis의 특징 <br>
- In-Memory 기반의 `key-value` 형식의 비정형 데이터 구조를 가짐. 따라서 별도의 쿼리 없이도 데이터를 간단히 조회가능 <br>
- 콜렉션 프레임워크를 제공함(String, Set, Sorted Set, Hash, List) <br>
- 서비스의 특성에 따라서 캐시로도 사용가능하고, Persistence Data Storage로 사용 가능 <br>
<br>

## 🔎 캐시 사용의 이점 <br>
- 나중에 요청된 결과를 미리 저장해두었다가 빨리 제공하기 위해 캐시를 사용
  - 서비스 요청이 증가할수록, 특히 DB에서 데이터를 조회하는 경우 많은 부하를 줄 수 있음

<img src="https://user-images.githubusercontent.com/101084642/178697388-f21dc8f1-dfcc-4aa3-bd29-a5f82d75ab8b.png" width="600" height="350"/>

<br>

>### 📌 Look aside cache 방식<br>
>- 웹 서버는 클라이언트 요청을 받아서, 데이터가 존재하는지 캐시를 먼저 확인<br>
>- Cache에 데이터가 있으면 조회를 하고, 만약 없으면 DB에서 읽어서 캐시에 저장 후 클라이언트한테 데이터를 전달<br>

<br>

>### 📌 Write Back 방식<br>
>-  데이터를 캐시에 전부 먼저 저장해놓았다가 특정 시점마다 한번씩 캐시 내 데이터를 DB에 INSERT<br>
>- Insert를 1개씩 500번😎 수행하는 것보다 500개를 한번에 삽입하는 동작이 훨씬 빠르고, write back 방식도 성능면에서는 뒤쳐지지 않음<br>
>- 단점은 데이터를 일정 기간 동안은 유지하고 있어야 하고, 이때 이걸 유지하고 있는 Storage는 메모리 공간이므로 서버 장애 상황에서 데이터 손실 우려<br> 
>  그래서 재생 가능한 데이터나, 극단적으로 무거운 데이터에서 write back 방식을 많이 사용<br>

<br>

## 🔎 Reddis의 특징 <br>
- Collection 프레임워크 제공(개발 편의성, 개발난이도 면에서 장점) 사용자가 많은 랭킹을 산출할 경우에도 많이 사용하고, Sorted Set을 사용하면 랭킹 서버를 쉽게 구현
- single-thread 특성을 유지하고 있기 때문에 다른 스토리지 플랫폼보다는 이슈가 적음
   * Redis 4.0 부터는 기본적으로 4개의 쓰레드로 동작하지만 일반 명령어를 처리하는 메인쓰레드 1개와 별도의 시스템 명령들을 사용하는 전용 sub trhead 3개 로써,
     실제로 사용자가 사용하는 명령어들을 싱글쓰레드로 동작
- 싱글 스레드 방식이므로 long-time 명령 수행시 다른 명령어들을 처리 할 수 없는 상태가 되기 때문에 매우 비효율적으로 동작

<br>


##  😎 Spring Boot와 Redis 적용하기 <br>

### 1. Docker 설치<br>
https://www.docker.com/get-started/ <br>

### 2. Reddis 설치<br>
https://emflant.tistory.com/235 <br>


### 3. Reddis 적용 예시 <br>
https://zara49.tistory.com/196





