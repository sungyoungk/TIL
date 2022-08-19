# Stack<E> 컬렉션
  
<img width="546" alt="스크린샷 2022-08-19 오후 3 29 36" src="https://user-images.githubusercontent.com/101084642/185557160-f2a77d55-90f0-46d2-91d5-592ec3869d7a.png">

- Stack<E> 컬렉션은 5가지 컬렉션 중 유일하게 **클래스**다
- 즉, 자체적으로 객체를 생성할 수 있다
- List<E> 컬렉션을 구현한 Vector<E> 클래스의 자식 클래스로 후입선출(LIFO) 자료구조를 구현한 컬렉션이다
- 접시를 쌓는다고 생각하면 쉽게 접근할 수 있다

  <br>
  
## Stack<E>의 주요 메서드
#### 🚩 주의
  - Stack<E> 가 Vector<E>의 자식클래스이다
  - 따라서, Vector<E> 에 포함되는 add(), remove() 메서드는 사용 가능하나, LIFO의 특성이 반영되지 않는다
  - Stack<E> 의 특성을 살리기 위해 Stack<E>에 추가한 5개의 매소드를 사용해야한다
  
![스크린샷 2022-08-19 오후 3 51 51](https://user-images.githubusercontent.com/101084642/185560802-81fa7da0-6db1-46b2-aa44-f2c8370b276b.png)
  
  
  <br>
  
#### ✅ Stack<E> 클래스 주요 매서드 활용

```java

        Stack<Integer> stack = new Stack<>();

        // 1.push()
        System.out.println("======= push() ========");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // 2. peek()
        System.out.println("======= peak() =======");
        System.out.println(stack.peek());
        System.out.println(stack.size());

        // 3. search(Object o)
        System.out.println("======= search() =======");
        System.out.println(stack.search(7));  //-1
        System.out.println(stack.search(3));  // 2
        System.out.println(stack.search(5));  // -1
        System.out.println(stack.search(2));  // 3


        // 4. E pop()
        System.out.println("======= pop() =======");
        System.out.println(stack.pop());  // 4
        System.out.println(stack.pop());  // 3
        System.out.println(stack.pop());  // 2
        System.out.println(stack.pop());  // 1

        // 5. boolean empty()
        System.out.println("======= empty() =======");
        System.out.println(stack.isEmpty());  // true
  
```
