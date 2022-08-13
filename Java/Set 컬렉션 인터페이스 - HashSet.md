# Set 컬렉션 인터페이스 - HashSet

  ### 🔎 Set 컬렉션의 특징
  - List<E> 컬렉션과 같이 동일한 타입의 묶음이라는 특징은 동일함
  - 그러나, 인덱스 정보를 가지고 있지 않음으로, 같은 값의 데이터 저장시 호출 할 방법이 없음
  - 즉, **중복 데이터는 저장되지 않음**

  <br>
  
  ### 🔎 Set<E>의 주요 메서드
  - Set<E>에는 인덱스 정보가 포함되지 않으므로, List<E>의 인덱스가 포함된 메서드는 사용 불가
  
  #### `Contains(Object o)`
  - Set<E> 매개변수로 넘어온 데이터가 객체 내에 포함되어 있는지를 boolean 값으로 리턴
  
  #### `iterator()`
  - Iterator<E> 객체를 리턴한다
  - 이 객체는 Set<E> 객체에서 데이터를 1개씩 꺼내는 기능을 포함한다
  - Set<E> 객체는 인덱스 값이 없으므로 for문을 사용해서 데이터를 꺼낼 수 없다
  - 대신, iterator() 메서드로 리턴되는 Iterator<E>객체가 for문의 기능을 수행한다
  
  > 🌟 **참고** <br>
  > List<E>에서도 iterator() 매서드 사용가능하나, 인덱스 번호가 있으므로, 굳이 Iterator<E>를 가져와 사용할 필요가 없다
  
  <br>
  
  ## Set<E> 구현클래스
  - Set<E>도 인터페이스이므로, 자체적으로 객체를 생성할 수 없다
  - List<E> 처럼, 자바 컬렉션 프레임워크에서 제공하는 Set<E> 인터페이스를 상속한 구현클래스를 이용해야한다
  - 대표적으로 아래의 클래스가 있다
    - **`HashSet<E>`**
    - **`LinkedHashSet<E>`**
    - **`TreeSet<E>`**
  
  <br>
  
  ### 📌 HashSet<E> 구현 클래스
  - 인덱스가 없으므롤, 출력시 입력 순서가 보장되지 않는다(주머니에서 공 꺼내는것 처럼)
  - 동적으로 저장용량을 관리하며 기본값은 16이다(List<E>는 10)
  - 이후 저장 데이터 개수가 많아지면 동적으로 증가한다
  
  <br>
  
  ### 데이터 추가하기 add() / addAll(Collection<? extends E> c)
  ```java
  
  Set<String> hSet1 = new HashSet<>();
        hSet1.add("가");
        hSet1.add("나");
        hSet1.add("가");
        System.out.println(hSet1);                // -> [가, 나] 중복 데이터가 제거되어 출력됨       

        // addAll(Collection<? extends E> c)
        Set<String> hSet2 = new HashSet<>();
        hSet2.add("나");
        hSet1.add("다");
        hSet2.addAll(hSet1);
        System.out.println(hSet2);                // -> [가, 다, 나] 입력순서와 다름
  
  ```

<br>

### 데이터 삭제하기 - remove() / clear()

```java



```
  
   
 

  
