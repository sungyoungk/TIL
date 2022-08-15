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
  
  ### 🔎 데이터 추가하기 add() / addAll(Collection<? extends E> c)
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

### 🔎 데이터 삭제하기 - remove() / clear()

```java

Set<String> hSet = new HashSet<>();
        hSet.add("가");
        hSet.add("나");
        hSet.add("다");

        hSet.remove("나");
        System.out.println(hSet.toString());  // -> [가, 다]

        hSet.clear();
        System.out.println(hSet);             //  -> 콜렉션 인터페이스는 toString()이 오버라이딩 되어 있어서 그냥 출력해도 됨

```
  
  <br>

### 🔎 데이터 정보추출하기- isEmpty() / contains() / size() / iterator()

```java

        Set<String> hSet = new HashSet<>();
        System.out.println(hSet.isEmpty());           //  -> .isEmpty()


        Set<String> hSet2 = new HashSet<>();
        hSet2.add("a");
        hSet2.add("b");
        hSet2.add("c");
        System.out.println(hSet2.contains("a"));       //  ->  .contains()


        System.out.println(hSet2.size());              //  -> .size()


        Iterator<String> iterator = hSet2.iterator();  //  -> iterator<E> 객체 호출
        while(iterator.hasNext()) {                    //  -> .hasNext()
            System.out.println(iterator.next() + " "); //  -> .Next()
        }

        System.out.println();


        for(String s : hSet2) {                        // -> iterator 대신 forEach 구문도 사용 가능
            System.out.println(s + " ");
        }

```

#### 📌 `isEmpty()`
- 데이터가 비어있는지 여부를 알 수 있다

#### 📌 `contains(Object o)`
- 객체 안에 해당 원소가 있는지를 boolean 값으로 리턴한다

#### 📌 `size()`
- 저장된 데이터 개수를 정수형으로 리턴한다

#### 📌 `iterator()`
- Set<E> 객체 내부의 데이터를 1개씩 꺼내 처리하고자 할때 사용하는 메서드
- for 문은 Set<E> 객체 데이터가 인덱스 정보를 저장하지 않아서 사용할 수 없음
- .iterator() 객체를 호출하면, 먼저 제네릭 클래스 타입인 Iterator<E> 객체가 생성된다
- 이 제네릭 타입은 당연히 Set<E> 객체가 저장하고 있는 원소 타입이다

#### 🌟 Iterator<E> 클래스에서는 아래의 2가지 메서드만 기억하자!!
> **hasNext()** : 다음으로 가리킬 원소의 존재 여부를 불리언 값으로 리턴  <br>
> **next()** : 다음 원소 위치로 가서 읽은 값을 리턴

- 여기서 주의할 점은, **최초 iterator<E> 객체가 생성되면 이 객체가 가르키는 값은 첫 워소 위치가 아닌 첫 원소 바로 이전의 위치값**이라는 것이다
- 첫 번째 원소값을 읽으려면 **`iterator.next()`** 를 실행해야한다

  <br>

### 🔎 배열로 변환하기- toString() / toString(T[]t)
- List<E> 와 완벽히 같은 문법
- 차이점은 출력시 데이터 입력 순서가 보장되지 않는다

```java

Set<String> hSet = new HashSet<>();
        hSet.add("a");
        hSet.add("b");
        hSet.add("c");
        System.out.println(hSet);                            // -> set<E> 생성 및 데이터 저장

        Object[] objectArray = hSet.toArray();
        System.out.println(Arrays.toString(objectArray));    // -> set<E>를 배열로 변환(오브젝트 타입)

        String[] strings = hSet.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));        // -> set<E>를 다운캐스팅하여 배열로 변환(스트링 타입)

        String[] strings2 = hSet.toArray(new String[5]);
        System.out.println(Arrays.toString(strings2));       // -> 위와 같으나 초기 데이터 크기를 데이터 저장개수 보다
                                                            //      크게 할 경우 null 값으로 기록됨

```

<br>

### 🔎 HashSet의 중복확인 매커니즘

- `a a1 = new A(3)` 과 `A a2 = new A(3)`은 생성자에 동일한 값을 넘겨 생성했으므로 완벽히 똑같이 생겼을 것이다. <br>

- 하지만, 클래스 A에서 특별한 처리를 해주지 않았다면 HashSet<E>의 관점에서는 다른 객체다. 즉, 중복 저장할 수 없다. <br>

- a1 과 a2 가 각각의 객체이기 때문이 아니다. 실제로 모든 컬렉션은 객체만 저장할 수 있고 3의 데이터를 넣으면 내부적으로  <br>
  `new Integer(3)` 과같이 객체로 변환돼 저장된다

- 따라서, `String s1 = new String("안녕")` 과 `String s2 = new String("안녕")`는 HashSet<E>관점에서는 동일한 객체다

- 그렇다면, 어떤 차이가 있을까? 이를 위해서는 해시코드의 개념, 등가연산자(==) 와 .equals() 메서드의 차이를 알아야 한다

<br>

### 🔎 HashCode
- 해시코드는 객체가 저장된 번지와 연관된 값으로, 실제 번지값은 아니다

- 즉, **객체가 저장된 번지를 기준으로 생성된 정수형 고유값이 해시코드이다**

- 객체의 해시코드 값을 리턴하는 **`hashCode()`** 매서드는 Object 클래스에 정의돼있다

- 하위 클래스에서 Object의 **`toString()`** 을 오버라이딩 하지 않았다면, **`toString()`** 으로 해시값을 확인할 수 있다
 
- Object의 **`toString()`** 메서드는 `패키지명.클래스명@해시코드`를 출력한다

```java

public class HashCode extends Object {
    public static void main(String[] args) {

        HashCode a = new HashCode();
        System.out.printf("%x", a.hashCode());       //  ->  4617c264
        System.out.println();                        //  한칸 띄우기
        System.out.println(a.toString());            //  -> listInterface.HashCode@4617c264
    }
}

```

<br>

- 객체가 아닌 조금더 복잡한 기준으로 해시코드를 생성할 수 도 있다
- **`Objects`** 클래스의 정적 매서드인 **hash(Object... values)** 를 사용한다
- 매개변수로 들어오는 값과 순서까지 고려해 고유한 해시코드를 생성한다
```java

        System.out.println(Objects.hash(1, 2, 3));   //  -> 30817
        System.out.println(Objects.hash(2, 1, 3));   //  -> 31747
        System.out.println(Objects.hash("안녕"));     //  -> 1611052
```

<br>

<br>

### 🔎 `등가연산자(==)`  /  `.equals()`
  
