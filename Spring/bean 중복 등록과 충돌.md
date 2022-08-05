# ❑ 중복 등록과 충돌
컴포넌트 스캔에서 같은 빈 이름을 등록할 경우, 아래의 두 가지 상황이 있음
> 1. 자동빈등록vs자동빈등록
> 2. 수동빈등록vs자동빈등록

<br>

### 🔎 자동 빈 등록 vs 자동 빈 등록
- 컴포넌트 스캔에 의해 자동으로 스프링 빈이 등록되는데, 그 이름이 같은 경우 스프링은 오류를 발생
  - `ConflictingBeanDefinitionException` 예외 발생

<br>

### 🔎 수동 빈 등록 vs 자동 빈 등록
```java

 @Component
 public class MemoryMemberRepository implements MemberRepository {}
 
```
> 이렇게 컴포넌트 스캔에 의해 `memoryMemberRepository` 가 자동으로 스프링 빈에 등록 되어 있는데...

```java

   @Configuration
  @ComponentScan(
          excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
  Configuration.class)
  )
  public class AutoAppConfig {
      @Bean(name = "memoryMemberRepository")
      public MemberRepository memberRepository() {
          return new MemoryMemberRepository();
      }
}

```
> @Bean 어노테이션으로 수동으로 같은 이름을 등록시킨다면?

<br>

#### ☞ 이 경우 수동 빈 등록이 우선권을 가진다.(수동 빈이 자동 빈을 오버라이딩 해버린다.)
- 아래와 같이, 수동 등록한 빈으로 override 했다는 로그를 볼 수 있다.

 ```text
 
  Overriding bean definition for bean 'memoryMemberRepository' with a different
  definition: replacing
 
 ```

### 🔥 하지만...
- 개발자가 의도적으로 설정해서 이런 결과(빈 중복 등록)가 만들어지기 보다는 여러 설정들이 꼬여서 이런 결과가 만들어지는 경우가 대부분이다!
- 이 경우, 버그를 잡기 굉장히 힘들다
- 따라서, 최근 **스프링 부트**는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본 값을 바꾸었다
- 스프링부트인 `CoreApplication`을 실행해보면 오류를 볼 수 있음

```text

// *** 오류발생 ***
   Consider renaming one of the beans or enabling overriding by setting
spring.main.allow-bean-definition-overriding=true

```
