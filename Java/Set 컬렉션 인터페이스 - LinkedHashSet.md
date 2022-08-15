# Set 컬렉션 인터페이스 - LinkedHashSet
  - HashSet<E> 의 자식클래스로 HashSet<E> 의 모든 기능에 데이터간 연결 정보만을 추가로 가지고 있다
  - 따라서, 입력된 순서를 기억하고 있다
  - **`LinkedHashSet<E>`** 은 출력 순서가 입력 순서와 동일하다
  - 하지만, **List<E> 처럼 데이터를 추가하거나 특정 순서에 저장된 값을 가져오는것은 불가능 하다**

  `LinkedHashSet<E> 의 주요 매서드 활용 방법`
  ```java
  
  public class LinkedHashSet {

    public static void main(String[] args) {
        Set<String> linkedSet1 = new java.util.LinkedHashSet<>();

        // 1. add(E element)
        linkedSet1.add("a");
        linkedSet1.add("b");
        linkedSet1.add("c");

        System.out.println(linkedSet1.toString());                   // [a, b, c]  

        // 2. addAll(다른 set 객체)
        Set<String> linkedSet2 = new java.util.LinkedHashSet<>();
        linkedSet2.add("b");
        linkedSet2.add("c");
        linkedSet2.addAll(linkedSet1);

        System.out.println(linkedSet2.toString());                     // [b, c, a]

        // 3. remove(Object o)
        linkedSet2.remove("b");

        System.out.println(linkedSet2.toString());                    // [c. a]

        // 4. clear()
        linkedSet2.clear();

        System.out.println(linkedSet2);                               // []

        // 5. isEmpty()
        System.out.println(linkedSet2.isEmpty());                     // true

        // 6. contains(Object o)
        Set<String> linkedSet3 = new java.util.LinkedHashSet<>();
        linkedSet3.add("a");
        linkedSet3.add("b");
        linkedSet3.add("c");

        System.out.println(linkedSet3.contains("b"));                  // true
        System.out.println(linkedSet3.contains("d"));                  // false

        // 7. size
        System.out.println(linkedSet3.size());                         // 3

        // 8. iterator
        Iterator<String> iterator = linkedSet3.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());                       // a b c
        }

        // 9. toArray
        Object[] objects = linkedSet3.toArray();
        System.out.println(Arrays.toString(objects));                 // [a, b, c]

        String[] strings1 = linkedSet3.toArray(new String[0]);
        System.out.println(Arrays.toString(strings1));                // [a, b, c]

        String[] strings2 = linkedSet3.toArray(new String[5]);        // [a. b. c. null, null]
        System.out.println(Arrays.toString(strings2));
    }
}
  
  ```
  
  
