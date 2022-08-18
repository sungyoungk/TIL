#  Queue<E> 컬렉션 인터페이스

## 📌 Queue<E> 컬렉션의 특징

<img width="193" alt="스크린샷 2022-08-18 오후 5 13 01" src="https://user-images.githubusercontent.com/101084642/185345018-4a2ce18f-4650-400c-8b95-df4da8fe4819.png">

- `Collection<E>`에게서 상속된 인터페이스로, `LinkedList<E>`가 `Queue<E>` 인터페이스를 구현하고 있다
- `Queue<E>`의 가장 큰 특징은 선입선출, **🚩FIFO(First In First Out)구조를 가진다**
- `Linked` 가 붙은 컬렉션은 입력 순서 정보를 저장하기 때문에 입력순서, 출력순서가 동일한데, 이것은 바로 Queue<E>의 특징이다 
  
![스크린샷 2022-08-18 오후 5 18 44](https://user-images.githubusercontent.com/101084642/185346232-a1659c87-5e42-4f01-a460-b991515dc1c7.png)

  
<br>
  
## 📌 Queue<E>의 주요 메서드
  
![스크린샷 2022-08-18 오후 5 34 58](https://user-images.githubusercontent.com/101084642/185350032-101852b5-e823-449e-a543-a8ee34ad9288.png)
  
#### ✅ Queue<E> 객체 생성
  
```java
  
public class QueuePrac {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        System.out.println(queue1.toString());         // []
        System.out.println(queue1.element());          // NoSuchElementException 발생!
    }
}  
  
```
  
<br>
  
#### ✅ 예외처리 기능 미포함 메서드

```java
        // 예외처리 미포함 메서드
        // 1. add(E item)
        queue1.add(3);
        queue1.add(4);
        queue1.add(5);

        // 2. element()
        System.out.println(queue1.element());           // 3

        // 3. remove()
        System.out.println(queue1.remove());            // 3
        System.out.println(queue1.remove());            // 4
        System.out.println(queue1.remove());            // 5
        // System.out.println(queue1.remove());         // NoSuchElementException 
  
```
  
  <br>
  
#### ✅ 예외처리 기능 포함 메서드
  - add, element, remove 와 기능상 동일하나 exception이 발생하면 멈춰버리는것 보다야 null값처리를 해 주는 것이 더 낫다.

```java
// 예외처리 기능 포함 메서드
        Queue<Integer> queue2 = new LinkedList<>();
        System.out.println(queue2.peek());              // null, exception 처리가 되었음

        // 1. offer(E item)
        queue2.offer(3);
        queue2.offer(4);
        queue2.offer(5);

        // 2. E ppek()
        System.out.println(queue2.peek());

        // 3. poll()
        System.out.println(queue2.poll());          // 3
        System.out.println(queue2.poll());          // 4
        System.out.println(queue2.poll());          // 5
        System.out.println(queue2.poll());          // null    exception처리가 되었음
```
