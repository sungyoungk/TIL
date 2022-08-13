# LinkedList<E> 구현 클래스
- List<E>의 공통적인 특징(동일 타입 수집, 메모리 동적 할당, 데이터 추가/변경/삭제 매서드)을 모두 가진다
- ArrayList<E>처럼 메서드를 동기화 하지 않음(싱글 스레드에 적합함)
  
  <br>

### 📌 LinkedList<E> 의 차별점
  **1) 저장용량을 매개변수로 가지는 생성자가 없음. 객체 생성시 저장용량 지정이 불가능함**
  ```java
  List<E> aLinkedList = new LinkedList<Integer>();  // 🙆🏻‍♂️
  List<E> aLinkedList = new LinkedList<Integer>();  // ❌
  ```
  
  **2) 데이터 저장시 인덱스 값 저장이 아닌, 앞 뒤 객체의 정보를 저장함. 말 그대로 서로 연결된 형태로 관리됨**
  <img width="848" alt="스크린샷 2022-08-13 오후 5 46 10" src="https://user-images.githubusercontent.com/101084642/184476386-54bf4405-6bf0-4e7c-99c2-ab77eca93e97.png">

  
### 📌 ArrayList<E> 와 LinkedList<E> 의 성능 비교
  
 #### 🆚 데이터 추가/삭제 
  >  😎 LinkedList<E> 승!
  - 인덱스로 값을 저장하는 ArrayLisㅅ<E>의 경우, 데이터 추가/삭제시 다른 전체 데이터의 인덱스 값도 변하므로 모든 데이터를 수정해야함 
  - LinkedList<E>의 경우, 각 원소 앞 뒤 객체정보만 수정하면 됨
  
  #### 🆚 데이터 검색
  >  😎 ArrayList<E> 승!
  - ArrayList<E> 는 각 데이터가 인덱스 값을 저장하고 있어서 특정 위치의 데이터를 빠르게 찾을 수 있음
  - LinkedList<E>의 경우, 데이터가 인덱스 값을 저장하지 않으므로, 처음부터 번호를 세어가며 인덱스 값을 찾아야 함
 
  <br>
  
  > 🌟 참고
  > 이외의 모든 메서드는 ArrayList<E>와 사용법이 동일함
