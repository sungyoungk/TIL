# Autowired필드명, @Qualifier, @Primary

### 조회 대상 빈이 2개 이상일 때 해결 방법
- @Autowired 필드 명 매칭
- @Qualifier -> @Qualifier 끼리 매칭 -> 빈 이름 매칭
- @Primary 사용

<br>

## 🔎 @Autowired필드명 매칭
> **`Autowired`** 는 타입 매칭을 시도하고, 이때 여러 빈이 있으면 <br>
> 필드 이름, 파라미터 이름으로 빈 이름을 추가 매칭한다

<br>

#### 기존코드

```java

  @Autowired
  private DiscountPolicy discountPolicy

```


#### 필드 명을 빈 이름으로 변경

- 필드 명이 **`rateDiscountPolicy`** 이므로 정상 주입된다. 필드 명 매칭은 먼저 타입 매칭을 시도 하고 그 결과에 여러 빈이 있을 때 추가로 동작하는 기능이다

```java

  @Autowired
  private DiscountPolicy rateDiscountPolicy

```


> #### @Autowired 매칭 정리
>
> 1. 타입 매칭
> 2. 타입 매칭의 결과가 2개 이상일 때 필드 명, 파라미터 명으로 빈 이름 매칭

<br>

## 🔎 @Qualifier 사용
- **`@Qualifier`** 는 추가 구분자를 붙여주는 방법이다. 주입시 추가적인 방법을 제공하는 것이지 빈 이름을 변경하는 것은 아니다.

#### 빈 등록시 @Qualifier를 붙여 준다.

```java

   @Component
  @Qualifier("mainDiscountPolicy")
  public class RateDiscountPolicy implements DiscountPolicy {}

```

```java

  Component
  @Qualifier("fixDiscountPolicy")
  public class FixDiscountPolicy implements DiscountPolicy {}

```

####  주입시에 @Qualifier를 붙여주고 등록한 이름을 적어준다.

**`생성자 자동 주입 예시`**

```java

@Autowired
  public OrderServiceImpl(MemberRepository memberRepository,
                          @Qualifier("mainDiscountPolicy") DiscountPolicy
  discountPolicy) {
      this.memberRepository = memberRepository;
      this.discountPolicy = discountPolicy;
}

```

`수정자 자동주입 예시`
```java

@Autowired
  public DiscountPolicy setDiscountPolicy(@Qualifier("mainDiscountPolicy")
  DiscountPolicy discountPolicy) {
      this.discountPolicy = discountPolicy;
  }


```

#### 🌟 참고
- `@Qualifier` 로 주입할 때 `@Qualifier("mainDiscountPolicy")` 를 못찾으면 어떻게 될까? **그러면 mainDiscountPolicy라는 이름의 스프링 빈을 추가로 찾는다**
- `@Qualifier`는 `@Qualifier`를 찾는 용도로만 사용하는것이 명확하고 좋다
- 다음과 같이 직접 빈 등록시에도 @Qualifier를 동일하게 사용할 수 있다

```java

@Bean
  @Qualifier("mainDiscountPolicy")
  public DiscountPolicy discountPolicy() {
    return new ...
  }

```

<br>

### @Qualifier 정리
1. @Qualifier끼리 매칭
2. 빈 이름 매칭
3. `NoSuchBeanDefinitionException` 예외 발생

<br>

## 🔎 @Primary 사용
- @Primary 는 우선순위를 정하는 방법이다
- @Autowired 시에 여러 빈이 매칭되면 @Primary 가 우선권을 가진다

#### `rateDiscountPolicy`가 우선권을 가지도록 설정

```java

  @Component
  @Primary
  public class RateDiscountPolicy implements DiscountPolicy {}

//-------------------------------------------------------
 
  @Component
  public class FixDiscountPolicy implements DiscountPolicy {}

```

#### 사용코드

```java

//생성자
@Autowired
public OrderServiceImpl(MemberRepository memberRepository,
                          DiscountPolicy discountPolicy) {
      this.memberRepository = memberRepository;
      this.discountPolicy = discountPolicy;
       }
       
//수정자
@Autowired
public DiscountPolicy setDiscountPolicy(DiscountPolicy discountPolicy) {
      this.discountPolicy = discountPolicy;
  }


```

- 코드를 실행해보면 문제 없이 @Primary 가 잘 동작하는 것을 확인할 수 있다
- 여기까지 보면 @Primary 와 @Qualifier 중에 어떤 것을 사용하면 좋을지 고민이 될 것이다
- @Qualifier 의 단점은 주입 받을 때 다음과 같이 모든 코드에 @Qualifier 를 붙여주어야 한다는 점이다
- 반면에 @Primary 를 사용하면 이렇게 @Qualifier 를 붙일 필요가 없다.

```java

@Autowired
  public OrderServiceImpl(MemberRepository memberRepository,
                          @Qualifier("mainDiscountPolicy") DiscountPolicy
  discountPolicy) {
      this.memberRepository = memberRepository;
      this.discountPolicy = discountPolicy;
}

```

<br>


### @Primary, @Qualifier 활용
- 코드에서 자주 사용하는 메인 데이터베이스의 커넥션을 획득하는 스프링 빈이 있고, 코드에서 특별한 기능으로 <br>
  가끔 사용하는 서브 데이터베이스의 커넥션을 획득하는 스프링 빈이 있다고 생각해보자
- 데이터베이스의 커넥션을 획득하는 스프링 빈은 @Primary 를 적용해서 조회하는 곳에서 @Qualifier 지정 없이 <br
  편리하게 조회하고, 서브 데이터베이스 커넥션 빈을 획득할 때는 @Qualifier 를 지정해서 명시적으로 획득 하는 <br>
  방식으로 사용하면 코드를 깔끔하게 유지할 수 있다 
- 이때 메인 데이터베이스의 스프링 빈을 등록할 때 @Qualifier 를 지정해주는 것은 상관없다

<br>

###  우선순위
- @Primary 는 기본값 처럼 동작하는 것이고, @Qualifier 는 매우 상세하게 동작한다
- 스프링은 자동보다는 수동이, 넒은 범위의 선택권 보다는 좁은 범위의 선택권이 우선 순위가 높다
- 따라서, 여기서도 @Qualifier 가 우선권이 높다



