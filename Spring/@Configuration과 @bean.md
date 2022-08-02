# @Configuration & @Bean
- 스프링에서는 일반적으로 컴포넌트 스캔을 사용해 자동으로 빈을 등록하는 방법을 이용한다. 하지만 @Bean 어노테이션을 사용해 수동으로 빈을 등록해야 하는 경우도 있다
- 다음과 같은 경우에 @Bean으로 직접 빈을 등록해준다
  1. 개발자가 직접 제어가 불가능한 라이브러리를 활용할 때
  2. 애플리케이션 전범위적으로 사용되는 클래스를 등록할 때
  3. 다형성을 활용하여 여러 구현체를 등록해주어야 할 때

<br>

## @Configuration 안에 @Bean을 등록하는 이유
- @Configuration 안에 적용되는 프록시 패턴
  - @Configuration 어노테이션 안에는 @Component 어노테이션이 붙어있어서 @Configuration이 붙어있는 클래스 역시 스프링의 빈으로 등록이 된다
  - 스프링이 @Configuration을 따로 만든 이유는 CGLib으로 프록시 패턴을 적용해 수동으로 등록하는 스프링 빈이 반드시 싱글톤으로 생성됨을 보장하기 위해서임

<br>

## 즉,  @Bean이 있는 메소드를 여러 번 호출하여도 항상 동일한 객체를 반환하여 싱글톤을 보장한다

### 📌 예시
 
 ```java
 @Configuration
  public class AppConfig {
  
    @Bean
    public MemberService memberService() {
      //1번
     System.out.println("call AppConfig.memberService");
      return new MemberServiceImpl(memberRepository());
    }
      
    @Bean
    public OrderService orderService() {
      //1번
      System.out.println("call AppConfig.orderService"); 
      return new OrderServiceImpl(
                  memberRepository(),
                  discountPolicy());
    }
      
    @Bean
    public MemberRepository memberRepository() {
      //2번? 3번?
      System.out.println("call AppConfig.memberRepository"); 
      return new MemoryMemberRepository();
    }
      
    @Bean
    public DiscountPolicy discountPolicy() {
      return new RateDiscountPolicy();
       }
    }                
 
 ```
 
 ### 스프링 컨테이너가 각각 @Bean을 호출해서 스프링 빈을 생성한다. 그래서 memberRepository() 는 다음과 같이 총 3번이 호출되는것 처럼 보인다
 1. 스프링 컨테이너가 스프링 빈에 등록하기 위해 @Bean이 붙어있는 `memberRepository() 호출`
 2. memberService() 로직에서 `emberRepository() 호출`
 3. orderService() 로직에서 `memberRepository() 호출`

<br>

### 그런데, 출력해보면 모두 1번만 호출됨

```console
  call AppConfig.memberService
   call AppConfig.memberRepository
  call AppConfig.orderServic
```

```java
  public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new
        AnnotationConfigApplicationContext(AppConfig.class);
        
        MemberServiceImpl memberService = ac.getBean("memberService",
        MemberServiceImpl.class);
        
        OrderServiceImpl orderService = ac.getBean("orderService",
        OrderServiceImpl.class);
        
        MemberRepository memberRepository = ac.getBean("memberRepository",
        MemberRepository.class);

        //모두 같은 인스턴스를 참고하고 있다.
          
        System.out.println("memberService -> memberRepository = " +
          memberService.getMemberRepository());
        
        System.out.println("orderService -> memberRepository  = " +
          orderService.getMemberRepository());
        
        System.out.println("memberRepository = " + memberRepository);
 
      //모두 같은 인스턴스를 참고하고 있다.
      assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
      assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
      }
}
    
```

<br>

- AnnotationConfigApplicationContext 에 파라미터로 넘긴 값은 스프링 빈으로 등록된다. 그래서 AppConfig 도 스프링 빈이 된다.
- AppConfig 스프링 빈을 조회해서 클래스 정보를 출력해보면 - >  `bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$bd479d70 `
- 순수한 자바 클래스인 `class hello.core.AppConfig` 이 아님
- 스프링이 **CGLIB**라는 바이트코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한 것

- <img width="724" alt="스크린샷 2022-08-02 오후 10 08 50" src="https://user-images.githubusercontent.com/101084642/182382391-7b1b50ff-a621-4ad4-a81c-d98160954604.png">


<br>

### AppConfig@CGLIB 예상 코드

```java
  @Bean
  public MemberRepository memberRepository() {
    if (memoryMemberRepository가 이미 스프링 컨테이너에 등록되어 있으면?) { 
      return 스프링 컨테이너에서 찾아서 반환;
    } else { //스프링 컨테이너에 없으면
      기존 로직을 호출해서 MemoryMemberRepository를 생성하고 스프링 컨테이너에 등록 
      return 반환
  } 
}

```
- @Bean이 붙은 메서드마다 이미 스프링 빈이 존재하면 존재하는 빈을 반환하고, 스프링 빈이 없으면 생성해서 스프링 빈으로 등록하고 반환하는 코드가 동적으로 만들어진다.
### 즉, 싱글톤이 보장된다!

<br>
<br>

---
#### reference
- [김영한의 스프링 로드맵](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8)
