# Vector<E>구현클래스

- List<E>를 상속했으므로 동일한 타입의 객체를 수집할 수 있다
- 메로리를 동적 할당 할 수 있다
- 데이터의 추가, 변경, 삭제 등이 가능하다
- ArrayList<E>와 문법 및 사용법이 완벽하게 일치한다


### Vector<E> 와 ArrayList<E> 차이 
- Vector<E>의 주요 메서드는 **🌟 동기화 매서드로 구현되어 있다**
- 즉, 멀티 쓰레드 환경에 적합하다
- 동기화 매서드는 하나의 공유 객체를 2개의 쓰레드가 동시에 사용하지 못하게 만든 매서드이다

```java
  
  public synchronized E remove(int index) {
  // ..
  
  }
  
   public synchronized E get(int index) {
  // ..
  
  }
  
  ```
  
  
  <br>
  
  - 멀티 쓰레드 환경에서 동기화 매서드를 사용하지 않으면, List<E>객체를 하나의 쓰레드는 읽고, <br>
  또 하나의 쓰레드는 삭제하는 작업을 동시에 수행해서 충돌이 일어날 수 있다.
   
<img width="654" alt="스크린샷 2022-08-13 오후 4 45 37" src="https://user-images.githubusercontent.com/101084642/184474457-2fd45657-0511-492e-bdc6-b03938e1bcbf.png">
