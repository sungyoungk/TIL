# `List<E> 컬렉션 인터페이스`
🌟 배열과 유사한 구조를 가지고 있지만 차이점이 존재한다.
- **배열 :** 최초에 크기를 한번 지정하면, 바꿀수 업다(정적이다).
- **List :** 크기를 동적으로 변화 시킬 수 있다(동적이다)
  
  `배열`
  -  최초 length 7 의 배열을 선언하고,
  - 2개의 데이터를 null 값으로 초기화해도 배열의 length 는 변화하지 않는다
  ```java  
        String[] array = new String[]{"가", "나", "다", "라", "마", "바", "사"};
        System.out.println(array.length);
        
        array[2] = null;
        array[5] = null;
        
        System.out.println(array.length);
    }
  ```
  
  `List<E>`
  - 최초에 new 키워드로 생성한 aList의 size 는 0 이다.
  - 이후 문자열을 추가하여 size 7이 되었다.
  - 두개의 문자를 제외하고 다시 프린트 해보면 사이즈가 5가 된다.
  - **즉, 저장공간이 동적으로 변환된다.**
  ```java
  
        <String> aList = new ArrayList<>();

        aList.add("가"); aList.add("나"); aList.add("다"); aList.add("라");
        aList.add("마"); aList.add("바"); aList.add("사");

        System.out.println(aList.size());

        aList.remove("가");
        aList.remove("나");

        System.out.println(aList.size());
  
  ```
  
  <br>
  
## 📌 List<E> 객체 생성하기
- List<E>는 인터페이스이기 때문에 객체 생성을 위해 List<E>를 상속받아 자식 클래스를 생성한 후, 자식 클래스로 객체를 생성해야한다
- 하지만, 컬렉션 프레임워크 이용시, 프레임워크 안에 이미 필요한 클래스가 구현되어 있기 때문에 직접 인터페이스를 구현하지 않아도 된다.

**🌟 대표적인 클래스**
>   - ArrayList<E>
>   - Vector<E>
>   - LinkedList<E>
  
  <br>
  
- List<E> 자체가 제네릭 인터페이스로, 상속한 자식 클래스 역시 제네릭 클래스다. 즉, 객체 생성시 제네릭 타입을 지정해야 한다
- 자식 클래스로 객체를 생성할 때는 각각의 클래스 타입으로 선언할 수도 있지만, **다형적 표현에 따라 부모타임인 List<E> 타입으로 선언할 수 있다**
- LinkedList<E>는 기본생성자만 존재해서 초기 저장용량을 매개변수로 포함하는 생성자를 만들지 못한다(capacity 지정불가!)
  
  ```java
  
  List<String> aList1 = new ArrayList<>();  // capacity = 10 미리 할당해놓은 저장공간의 크기로 size()와는 다른 개념
  
  List<String> aList2 = new ArrayList<>(30); // capacity = 30 이렇게 저장공간을 지정할 수도 있다. 
                                            // 초기 세팅값으로 써도 필요하면 jvm이 저장용량을 자동으로 늘리므로 개발자가 신경쓸 필요가 없음
 
  Vector<String> aList3 = new Vector<>(30);  // 이번에는 자식 타입으로 선언했다. capacity = 30
  
  List<Integer> aList4 = new LinkedList<>();  // capacity = 0
  LinkedList<Integer> aList4 = new LinkedList<>(20); // 오류발생! LinkedList 는 capacity 지정 불가!
  
  ```
  
  <br>
  
## 📌 `Array.asList()` 메서드로 정적 컬렉션 객체 생성하기

- 내부적으로 배열을 먼저 생성하고, 이를 List<E>로 래핑, 즉 포장만 한것
- 따라서, **💡내부 구조는 배열과 동일**하므로 컬렉션 객체임에도 불구하고 저장 공간의 크기를 변경 할 수 없다

```java
  
  List<Integer> aList = new Array.asList(1,2,3,4);
  aList.set(1, 7);       // [1,7,2,4]
  aList.add(5);          // 오류(UnsupportedOperationException)
  aList.remove(0)        // 오류(UnsupportedOperationException)
  
  ```

  <br>
  
## 📌 `ArrayList<E>`의 구현 클래스
`ArrayList<E>`는 대표적인 `List<E>` 구현 클래스로, `List<E>`가 가지고 있는 대표적인 데이터를 인덱스로 관리하는 기능, <br>
저장 공간을 동적으로 관리하는 기능 등을 그대로 지니고 있다.
  
#### 🌟 ArrayList<E>의 특징
> - List<E>인터페이스를 구현한 구현 클래스
> - 배열처럼 수집(collect)한 원소(element)를 인덱스(index)로 관리하며 저장 용량(capacity)를 동적으로 관리한다 

<br>
  
### 🔎 데이터 추가하기 - `add()`
  
#### 🌟 컬렉션 구현 클래서의 toString()
  - 모든 컬렉션 구현 클래스는 이 메서드에서 모든 데이터를 한 번에 정리해 출력하도록 오버라이딩 되어있

```java
  
        List<Integer> aList1 = new ArrayList<>();
        
        //add(<E> element)
        aList1.add(3);
        aList1.add(4);
        aList1.add(5);

        System.out.println(aList1.toString());  // [3, 4, 5]

        // add(int index, E element)
        aList1.add(1, 6);
        System.out.println(aList1.toString());
  
```
  
` 컬렉션 객체 추가`
```java

List<Integer> aList1 = new ArrayList<>();
        //add(<E> element)
        aList1.add(3);
        aList1.add(4);
        aList1.add(5);

        System.out.println(aList1.toString());  // [3, 4, 5]

        // add(int index, E element)
        aList1.add(1, 6);
        System.out.println(aList1.toString());
  
  //===================================================
  
  List<Integer> aList2 = new ArrayList<>();
  aList2.add(1);
  aList2.add(2);
  
  System.out.println(aList2.add(aList1));    // -> [1, 2, 3, 4, 5] 객체를 통째로 추가할 수도 있음
  
  Syste.out.println(aList2.add(1, aList1));  // -> [1, 3, 4, 5, 2]  인덱스 지정해서 추가

```
  
  <br>
  
### 🔎 데이터 변경하기 - **`set()`**
  - 잘못된 인덱스값을 입력시에는 `IndexOutOfBoundsException` 발생! <br>
    예) size()가 5 인데 set(8, 9)로 입력하는 경우
  
  ```java
  
  List<Integer> aList = new ArrayList<>();
        aList.add(1); aList.add(2); aList.add(3); aList.add(4);

        System.out.println(aList.toString());   // -> [1, 2, 3, 4]

        aList.set(1, 5);

        System.out.println(aList.toString());   // -> [1, 5, 3, 4]
  
  ```
  
  <br>
  
### 🔎 데이터 삭제하기 - **`remove`**, **`clear`**
  - .remove(index)
  - .remove(new Object(E))
  -. clear()
  
  ```java
  
  List<Integer> aList = new ArrayList<>();
        aList.add(1); aList.add(2); aList.add(3); aList.add(4);

        System.out.println(aList.toString());  // -> [1, 2, 3, 4]

        // remove(index)
        aList.remove(1);
        System.out.println(aList.toString());  // -> [1, 3, 4]

        // remove(Object o)
        aList.remove(new Integer(1));   // -> [3, 4]
        System.out.println(aList.toString());

        aList.clear();
        System.out.println(aList.toString());  // -> []
  
  ```
  
  <br>
  
### 🔎 데이터 정보 추출하기 - **`isEmpty()`**, **`size()`**, **get(int index)**
  - 이번에는  ArrayList<E> 객체의 정보를 추출하는 메서드에 대해 알아보자
  
  ```java
  
  List<Integer> aList = new ArrayList<>();
  aList.add(1); aList.add(2); aList.add(3); aList.add(4);

  System.out.println(aList.toString());            // --> [1, 2, 3, 4]
  System.out.println("size = " + aList.size());    // --> []

  // get(index)
  System.out.println(aList.get(0));                // --> 1

  for(int i = 0; i < aList.size(); i++) {
  System.out.println(i + "번째: " + aList.get(i));}  // 0번째: 1 1번째: 2 --- ~
  
  ```
  
  
  


