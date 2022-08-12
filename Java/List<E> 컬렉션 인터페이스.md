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
  
## List<E> 객체 생성하기
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
