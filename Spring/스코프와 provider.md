# 🔎 스코프와 provider.md
- request 스코프가 클라이언트 미요청으로 생성되기도 전에 주입 요청을 하면 오류가 발생한다
- 이때, `ObjectProvider` 를 사용하면 `objectProvider.getObject()` 를 호출하는 시점까지 `request scope` 의 생성 시점을 지연할 수 있다
- objectProvider.getObject()  매소드를 호출하는 시점에는 HTTP 요청이 진행중이기 때문에 request 스코프 요청이 정상처리된다

<br>

#### ✅ 예시코드 - ObjectProvider 사용으로 request 스코프 오류 해결

`MyLogger`
```java
@Component
@Scope(value = "request")
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL){
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println(" [ " + uuid + " ] " + " [ " + requestURL + " ] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println(" [ " + uuid + " ] request scope bean create: " + this);

    }

    @PreDestroy
    public void close(){
        System.out.println(" [ " + uuid + " ] request scope bean close: " + this);
    }
}
```

<br>

`controller`
```java
@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
//    private final MyLogger myLogger;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        MyLogger myLogger = myLoggerProvider.getObject();            //Object 프로바이더로 마이로거 가져옴
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testID");
        return "OK";

    }

}

```


<br>


`service`
```java
@Service
@RequiredArgsConstructor
public class LogDemoService {

//    private MyLogger myLogger;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String id) {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id );
    }
}

```
