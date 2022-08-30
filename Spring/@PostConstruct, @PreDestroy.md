# @PostConstruct, @PreDestroy
### ☺️ 장점
- 콜백 메서드 사용법 중 가장 편리한 방법이다
- **스프링에서 가장 권장하는 방법**이다
- 스프링에 종속적인 기술이 아닌 자바 표준으로 스프링이 아닌 다른 컨테이너에서도 동작한다(패키지를 확인하면 javax.annotation.PostConstruct 이다)

### 🌧 단점
- 유일한 단점으로, 외부 라이브러리에 적용하지 못한다
- 외부 라이브러리에 사용할 경우 [초기화, 소멸 메서드를 @Bean 에 직접 지정하는 방법](https://github.com/sungyoungk/TIL/blob/master/Spring/%EB%B9%88%20%EB%93%B1%EB%A1%9D%20%EC%B4%88%EA%B8%B0%ED%99%94%2C%20%EC%86%8C%EB%A9%B8%20%EB%A9%94%EC%84%9C%EB%93%9C%20%EC%A7%80%EC%A0%95%ED%95%98%EA%B8%B0.md)을 사용한다


<br>

#### ✅ @PostConstruct, @PreDestroy 사용 예시

```java

public class NetworkClient {

    String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect" + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + "message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkCient.close");
        disconnect();
    }
}

```

<br>

#### ✅ 설정 정보 클래스
```java
@Configuration
    static class LifeCycleConfig{

        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("www.naver.com");
            return networkClient;
        }

```

<br>

### 📣 결론
- @PostConstruct, @PreDestroy 애노테이션을 사용하자
- 코드를 고칠 수 없는 외부 라이브러리를 초기화, 종료해야 하면 @Bean 의 initMethod , destroyMethod 를 사용하자

