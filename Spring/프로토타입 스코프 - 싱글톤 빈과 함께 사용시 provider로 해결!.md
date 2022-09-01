# 📣프로토타입 스코프 - 싱글톤 빈과 함께 사용시 provider로 해결!
- 싱글톤 빈과 함께 프로토타입 빈 사용시 항상 새로운 프로토타입 빈을 생성하는 방법?

<br>

## 1️⃣ 스프링 컨테이너에 요청하기
- 싱글톤 빈이 프로토타입을 사용할 때마다 스프링 컨테이너에 요청하는 방법

#### ✅ 예제코드
- 싱글톤 빈 필드에 스프링 컨테이너를 주입받아 스프링 컨테이너가 필요한 빈을 찾게 한다
- 이렇게 의존관계로 주입받는것이 아닌 직접 필요한 의존관계를 찾는것을 **🌟 DL(Dependency Lookup)** 이라고 한다
- 스프링의 애플리케이션 컨텍스트 전체를 주입받게되면, 스프링 컨테이너에 종속적인 코드가 되고 단위 케이스 테스트가 어려워진다
- 지정한 프로토타입 빈을 컨테이너가 대신 찾아주는 DL 기능만 제공해주는 방법은 없을까? 다음 예제코드 확인!
```java

public class PrototypeProviderTest {

    @Test
    void providerTest(){
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClientBean{
        @Autowired
        private Applicationcontext ac;


        public int logic() {
           PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class)
            prototypeBean.addcount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addcount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init" + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("prototypeBean.destroy");
        }
    }
}

```

<br>

## 2️⃣ ObjectFactory, ObjectProvider
- ObjectProvider은 컨테이너에서 지정한 빈을 찾아주는 **DL** 을 제공한다
- 과거에는 `ObjectFactory`였는데, 편의기능 추가하여 **🌟`ObjectProvider`** 가 되었다

#### ✅ 예제코드 - ObjectProvider
- ObjectProvider 로 인해 실행시 **🌟`ObjectBeanProvider.getObject()`** 매서드를 통해 항상 새로운 프로토타입 빈이 생성된다
- ObjectProvider 의 **getObject()** 를 호출하면 스프링컨테이너를 통해 해당 빈을 찾아서 반환한다**🌟(DL)**
- 여깃 스프링에 종속되지만, 기능이 단순해서 단위테스트 및 mock 코드 만들기가 간단해진다
- **ObjectProvider 은 딱 필요한 DL 정도의 기능만 제공한다**

### 📌ObjectFactory vs ObjectProvider
- **ObjectFactory :** 기능이 단순하고 별도의 라이브러리가 필요없다. 스프링에 의존한다
- **ObjectProvider :** ObjectFactory를 상속한것이다. 옵션, 스트림 처리 등의 편의 기능이 많고 별도의 라이브러리가 필요없다(스프링에 의존하기 때문)
```java

public class PrototypeProviderTest {

    @Test
    void providerTest(){
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClientBean{
        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.addcount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addcount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init" + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("prototypeBean.destroy");
        }
    }

}

```

<br>

## 3️⃣ JSR-330 Provider

